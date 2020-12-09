package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginRegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginSeleccion;
    private Button registroSeleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_registro);

        loginSeleccion = findViewById(R.id.botonLoginLoginRegistro);
        registroSeleccion = findViewById(R.id.botonRegistroLoginRegistro);

        loginSeleccion.setOnClickListener(this);
        registroSeleccion.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.botonLoginLoginRegistro:

                Intent l = new Intent(this,LoginActivity.class);
                startActivity(l);
                finish();

                break;

            case R.id.botonRegistroLoginRegistro:

                Intent r = new Intent(this,RegistroActivity.class);
                startActivity(r);
                finish();

                break;
        }

    }
}