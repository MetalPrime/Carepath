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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth auth;

    private EditText correo;
    private EditText password;

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        correo = findViewById(R.id.inputCorreoLogin);
        password = findViewById(R.id.inputContrasenaLogin);

        login = findViewById(R.id.botonIniciarsesionLogin);

        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.botonIniciarsesionLogin:

                //confirmacion del perfil de autenticacion
                auth.signInWithEmailAndPassword(correo.getText().toString().trim(), password.getText().toString().trim())
                        .addOnCompleteListener(
                                task -> {
                                    if(task.isSuccessful()){

                                        //cambio de pantalla
                                        Intent m = new Intent(this, MainActivity.class);
                                        startActivity(m);
                                        finish();

                                    }else{

                                        //generador de errores
                                        Toast.makeText(this,task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                    }
                                }
                        );

                break;
        }
    }
}