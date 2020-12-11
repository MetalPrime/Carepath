package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginRegistroInquilino extends AppCompatActivity implements View.OnClickListener {

    private Button loginSeleccion;
    private Button registroSeleccion;
    private TextView cambioAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_registro);

        loginSeleccion = findViewById(R.id.botonLoginLoginRegistro);
        registroSeleccion = findViewById(R.id.botonRegistroLoginRegistro);
        cambioAdmin = findViewById(R.id.cambioAAdmin);

        loginSeleccion.setOnClickListener(this);
        registroSeleccion.setOnClickListener(this);
        cambioAdmin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.botonLoginLoginRegistro:

                Intent l = new Intent(this, LoginInquilino.class);
                startActivity(l);
                finish();

                break;

            case R.id.botonRegistroLoginRegistro:

                Intent r = new Intent(this, RegistroInquilino.class);
                startActivity(r);
                finish();

                break;

            case R.id.cambioAAdmin:

                Intent a = new Intent(this,LogeoRegistroAdmin.class);
                startActivity(a);
                finish();

                break;
        }

    }
}