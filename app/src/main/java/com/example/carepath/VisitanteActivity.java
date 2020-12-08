package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class VisitanteActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton botonHomePage;
    private ImageButton botonAgenda;
    private ImageButton botonVisitante;
    private ImageButton botonNotificacion;
    private ImageButton agregar;

    private Button backAgenda;

    private ListView listaVisitantes;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitante);

        listaVisitantes = findViewById(R.id.listaVisitantes);

        botonHomePage = findViewById(R.id.botonHome);
        botonAgenda = findViewById(R.id.botonAgenda);
        botonVisitante = findViewById(R.id.botonVisita);
        botonNotificacion = findViewById(R.id.botonNotificaciones);
        agregar = findViewById(R.id.aggVisitanteBtn);
        backAgenda = findViewById(R.id.backAgendaBtn);
    }

    @Override
    public void onClick(View view) {

    }
}