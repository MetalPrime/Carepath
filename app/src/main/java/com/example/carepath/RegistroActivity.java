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

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase database;
    private FirebaseAuth auth;

    private EditText nombre;
    private EditText apellido;
    private EditText numero;
    private EditText correo;
    private EditText tipoIdentificacion;
    private EditText numeroIdentificacion;
    private EditText torre;
    private EditText apartamento;
    private EditText nombreUsuario;
    private EditText password;
    private EditText confPassword;

    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        registrar = findViewById(R.id.botonRegistrarRegistro);

        nombre = findViewById(R.id.inputNombreRegistro);
        apellido = findViewById(R.id.inputApellidoRegistro);
        numero = findViewById(R.id.inputCelularRegistro);
        correo = findViewById(R.id.inputCorreoRegistro);
        tipoIdentificacion = findViewById(R.id.inputTipoIdRegistro);
        numeroIdentificacion = findViewById(R.id.inputNumeroIdRegistro);
        torre = findViewById(R.id.inputTorreRegistro);
        apartamento = findViewById(R.id.inputApartamentoRegistro);
        nombreUsuario = findViewById(R.id.inputNombreUsuarioRegistro);
        password = findViewById(R.id.inputContrasenaRegistro);
        confPassword = findViewById(R.id.inputConfirmarContrasenaRegistro);

        registrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.botonRegistrarRegistro:

                //creacion de usuario para autenticacion
                if(password.getText().toString().trim().equals(confPassword.getText().toString().trim())){

                    auth.createUserWithEmailAndPassword(correo.getText().toString().trim(), password.getText().toString().trim())
                            .addOnCompleteListener(

                                    task -> {

                                        //validacion de creaacion del usuario para crear el objeto en firebase
                                        if(task.isSuccessful()){

                                            String id = auth.getCurrentUser().getUid();

                                            //creacion de objeto para el hilo inquilinos de firebase
                                            Inquilino inquilino = new Inquilino(

                                                    id,
                                                    nombre.getText().toString()+ " " + apellido.getText().toString(),
                                                    numero.getText().toString().trim(),
                                                    tipoIdentificacion.getText().toString().trim(),
                                                    numeroIdentificacion.getText().toString().trim(),
                                                    torre.getText().toString().trim(),
                                                    apartamento.getText().toString().trim(),
                                                    nombreUsuario.getText().toString().trim()

                                            );
                                            //envio de de informacion a firebase
                                            database.getReference().child("inquilinos").child(id).setValue(inquilino)
                                                    .addOnCompleteListener(

                                                            taskDb -> {
                                                                if(taskDb.isSuccessful()){

                                                                    //cambio de pantalla
                                                                    Intent c = new Intent(this,MainActivity.class);
                                                                    startActivity(c);
                                                                    finish();

                                                                }
                                                            }
                                                    );
                                        }else{

                                            //generador de errores
                                            Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                        }
                                    }
                            );
                }

                break;

        }
    }
}