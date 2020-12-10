package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogeoRegistroAdmin extends AppCompatActivity implements View.OnClickListener{

    private Button loginSeleccion;
    private Button registroSeleccion;
    private TextView cambioAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logeo_registro_admin);

        loginSeleccion = findViewById(R.id.botonLoginLoginRegistroAdmin);
        registroSeleccion = findViewById(R.id.botonRegistroLoginRegistroAdmin);
        cambioAdmin = findViewById(R.id.cambioAInquilino);

        loginSeleccion.setOnClickListener(this);
        registroSeleccion.setOnClickListener(this);
        cambioAdmin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.botonLoginLoginRegistroAdmin:

                Intent l = new Intent(this,LoginAdmin.class);
                startActivity(l);
                finish();

                break;

            case R.id.botonRegistroLoginRegistroAdmin:

                Intent r = new Intent(this,Registro_admin.class);
                startActivity(r);
                finish();

                break;

            case R.id.cambioAAdmin:

                Intent i = new Intent(this,LoginRegistroActivity.class);
                startActivity(i);
                finish();

                break;
        }
    }
}