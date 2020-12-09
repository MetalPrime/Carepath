package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /*private ImageButton botonHomePage;
    private ImageButton botonAgenda;
    private ImageButton botonVisitante;
    private ImageButton botonNotificacion;*/

    private FirebaseDatabase database;
    private FirebaseAuth auth;

    //botones individuales
    private ConstraintLayout botonAgendaHome;
    private ConstraintLayout botonVisitanteHome;
    private ConstraintLayout botonNotificacionHome;

    View view;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (auth.getCurrentUser() == null) fueraDeLaPAgina();
        else {
        /*botonHomePage = findViewById(R.id.botonHome);
        botonAgenda = findViewById(R.id.botonAgenda);
        botonVisitante = findViewById(R.id.botonVisita);
        botonNotificacion = findViewById(R.id.botonNotificaciones);*/

            botonAgendaHome = findViewById(R.id.agendaBtn);
            botonVisitanteHome = findViewById(R.id.visitanteBtn);
            botonNotificacionHome = findViewById(R.id.notificacionBtn);

            database = FirebaseDatabase.getInstance();
            auth = FirebaseAuth.getInstance();

            botonAgendaHome.setOnClickListener(this);
            botonVisitanteHome.setOnClickListener(this);
            botonNotificacionHome.setOnClickListener(this);

        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.agendaBtn:
                break;

            case R.id.visitanteBtn:
                break;

            case R.id.notificacionBtn:
                break;
        }
    }

    private void fueraDeLaPAgina() {

        Intent l = new Intent(this,LoginRegistroActivity.class);
        startActivity(l);
        finish();

    }
}