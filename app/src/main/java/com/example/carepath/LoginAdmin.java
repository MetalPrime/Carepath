package com.example.carepath;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginAdmin extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth auth;
    private FirebaseDatabase database;

    private EditText correo;
    private EditText password;

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        correo = findViewById(R.id.inputCorreoLoginAdmin);
        password = findViewById(R.id.inputContrasenaLoginAdmin);

        login = findViewById(R.id.botonIniciarsesionLoginAdmin);

        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.botonIniciarsesionLoginAdmin:

                //confirmacion del perfil de autenticacion
                auth.signInWithEmailAndPassword(correo.getText().toString().trim(), password.getText().toString().trim())
                        .addOnCompleteListener(
                                task -> {
                                    if(task.isSuccessful()){

                                        verificaciondmin();

                                    }else{

                                        //generador de errores
                                        Toast.makeText(this,task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                    }
                                }
                        );

                break;
        }
    }

    public void verificaciondmin(){

        String id = auth.getCurrentUser().getUid();

        database.getReference().child("administradores").child(id).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        Administrador administrador = snapshot.getValue(Administrador.class);

                        if (administrador.getEstado().equals("administrador")){

                            //cambio de pantalla
                            Intent m = new Intent(getBaseContext(),HomePageAdmin.class);
                            startActivity(m);
                            finish();

                        }else {

                           AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext())
                                    .setTitle("Problema de logeo")
                                    .setMessage("¿Estás seguro que eres administrador?")
                                    .setPositiveButton("Si", (dialog, idD) -> {

                                        auth.signOut();
                                        dialog.dismiss();

                                    })
                                    .setNegativeButton("No", (dialog, idD) -> {

                                        auth.signOut();
                                        Intent m = new Intent(getBaseContext(), LogeoRegistroAdmin.class);
                                        startActivity(m);
                                        finish();

                                    });
                            builder.show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                }
        );

    }
}