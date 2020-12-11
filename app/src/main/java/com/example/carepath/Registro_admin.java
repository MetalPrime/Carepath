package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Registro_admin extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase database;
    private FirebaseAuth auth;

    private EditText nombre;
    private EditText apellido;
    private EditText numero;
    private EditText correo;
    private EditText numeroIdentificacion;
    private EditText password;
    private EditText confPassword;

    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_admin);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        registrar = findViewById(R.id.botonRegistrarAdmin);

        nombre = findViewById(R.id.inputNombreAdmin);
        apellido = findViewById(R.id.inputApellidoAdmin);
        numero = findViewById(R.id.inputCelularAdmin);
        correo = findViewById(R.id.inputCorreoAdmin);
        numeroIdentificacion = findViewById(R.id.inputCedulaAdmin);
        password = findViewById(R.id.inputContrasenaAdmin);
        confPassword = findViewById(R.id.inputConfirmarContrasenaAdmin);

        registrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.botonRegistrarAdmin:

                //creacion de usuario para autenticacion
                if(password.getText().toString().trim().equals(confPassword.getText().toString().trim())){

                    auth.createUserWithEmailAndPassword(correo.getText().toString().trim(), password.getText().toString().trim())
                            .addOnCompleteListener(

                                    task -> {

                                        //validacion de creacion del usuario para crear el objeto en firebase
                                        if(task.isSuccessful()){

                                            String id = auth.getCurrentUser().getUid();
                                            String estado = "administrador";

                                            //creacion de objeto para el hilo administradores de firebase
                                            Administrador administrador = new Administrador(

                                                    id,
                                                    nombre.getText().toString()+ " " + apellido.getText().toString(),
                                                    numero.getText().toString().trim(),
                                                    estado,
                                                    numeroIdentificacion.getText().toString().trim()

                                            );
                                            //envio de de informacion a firebase
                                            database.getReference().child("administradores").child(id).setValue(administrador)
                                                    .addOnCompleteListener(

                                                            taskDb -> {
                                                                if(taskDb.isSuccessful()){

                                                                    //cambio de pantalla
                                                                    Intent h = new Intent(this,HomePageAdmin.class);
                                                                    startActivity(h);
                                                                    finish();

                                                                }
                                                            }
                                                    );
                                        }else{

                                            //generador de errores
                                            //Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                        }
                                    }
                            );
                }

                break;

        }
    }
}