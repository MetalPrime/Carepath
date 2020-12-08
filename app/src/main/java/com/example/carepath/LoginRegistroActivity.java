package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class LoginRegistroActivity extends AppCompatActivity {

    private Button loginSeleccion;
    private Button registroSeleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_registro);

        loginSeleccion = findViewById(R.id.botonLoginLoginRegistro);
        registroSeleccion = findViewById(R.id.botonRegistroLoginRegistro);

    }
}