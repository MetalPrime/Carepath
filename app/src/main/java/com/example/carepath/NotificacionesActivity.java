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

public class NotificacionesActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase database;
    private FirebaseAuth auth;

    private ImageButton botonHomePage;
    private ImageButton botonAgenda;
    private ImageButton botonVisitante;
    private ImageButton botonNotificacion;

    //botones individuales
    private Button backNotificacion;

    //informacion a mostrar
    private ListView listaNotificaciones;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        if (auth.getCurrentUser() == null) fueraDeLaPAgina();
        else {

            database = FirebaseDatabase.getInstance();
            auth = FirebaseAuth.getInstance();

            listaNotificaciones = findViewById(R.id.listaNotificaciones);

            botonHomePage = findViewById(R.id.botonHome);
            botonAgenda = findViewById(R.id.botonAgenda);
            botonVisitante = findViewById(R.id.botonVisita);
            botonNotificacion = findViewById(R.id.botonNotificaciones);
            backNotificacion = findViewById(R.id.backNotificacionBtn);

            botonHomePage.setOnClickListener(this);
            botonAgenda.setOnClickListener(this);
            botonVisitante.setOnClickListener(this);
            botonNotificacion.setOnClickListener(this);
            backNotificacion.setOnClickListener(this);

        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.backNotificacionBtn:
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