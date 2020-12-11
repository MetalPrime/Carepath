package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class AgendaActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase database;
    private FirebaseAuth auth;

    private ImageButton botonHomePage;
    private ImageButton botonAgenda;
    private ImageButton botonVisitante;
    private ImageButton botonNotificacion;

    //botones individuales
    private ImageButton agregar;
    private Button backAgenda;
    private Button botonNN;

    //informacion a mostrar
    private ListView listaActividades;
    private TextView textDate;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        if (auth.getCurrentUser() == null) fueraDeLaPAgina();
        else {

            database = FirebaseDatabase.getInstance();
            auth = FirebaseAuth.getInstance();

            listaActividades = findViewById(R.id.listaAgenda);
            textDate = findViewById(R.id.textDate);

            botonHomePage.setOnClickListener(this);
            botonAgenda.setOnClickListener(this);
            botonVisitante.setOnClickListener(this);
            botonNotificacion.setOnClickListener(this);
            agregar.setOnClickListener(this);
            backAgenda.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.backAgendaBtn:
                break;

            case R.id.aggAgendaBtn:
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