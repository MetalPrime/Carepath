package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class VisitanteActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase database;
    private FirebaseAuth auth;

    private ImageButton botonHomePage;
    private ImageButton botonAgenda;
    private ImageButton botonVisitante;
    private ImageButton botonNotificacion;
    private ImageButton agregar;

    private Button backVisitante;

    //informacion a mostrar
    private ListView listaVisitantes;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitante);

        if (auth.getCurrentUser() == null) fueraDeLaPAgina();
        else {

            database = FirebaseDatabase.getInstance();
            auth = FirebaseAuth.getInstance();

            listaVisitantes = findViewById(R.id.listaVisitantes);

            botonHomePage = findViewById(R.id.botonHome);
            botonAgenda = findViewById(R.id.botonAgenda);
            botonVisitante = findViewById(R.id.botonVisita);
            botonNotificacion = findViewById(R.id.botonNotificaciones);
            agregar = findViewById(R.id.aggVisitanteBtn);
            backVisitante = findViewById(R.id.backVisitanteBtn);

            botonHomePage.setOnClickListener(this);
            botonAgenda.setOnClickListener(this);
            botonVisitante.setOnClickListener(this);
            botonNotificacion.setOnClickListener(this);
            agregar.setOnClickListener(this);
            backVisitante.setOnClickListener(this);

        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.backVisitanteBtn:
                break;

            case R.id.aggVisitanteBtn:
                break;

            case R.id.botonHome:
                break;

            case R.id.botonAgenda:
                break;

            case R.id.botonVisita:
                break;

            case R.id.botonNotificaciones:
                break;
        }

    }

    private void fueraDeLaPAgina() {

        Intent l = new Intent(this, LoginRegistroInquilino.class);
        startActivity(l);
        finish();

    }
}