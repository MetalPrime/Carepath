package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText contraseña;

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre = findViewById(R.id.inputCorreoLogin);
        contraseña = findViewById(R.id.inputContrasenaLogin);

        login = findViewById(R.id.botonIniciarsesionLogin);

    }
}