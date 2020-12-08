package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class NotificacionesActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton botonHomePage;
    private ImageButton botonAgenda;
    private ImageButton botonVisitante;
    private ImageButton botonNotificacion;

    private Button backNotificacion;

    private ListView listaNotificaciones;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        listaNotificaciones = findViewById(R.id.listaNotificaciones);

        botonHomePage = findViewById(R.id.botonHome);
        botonAgenda = findViewById(R.id.botonAgenda);
        botonVisitante = findViewById(R.id.botonVisita);
        botonNotificacion = findViewById(R.id.botonNotificaciones);
        backNotificacion = findViewById(R.id.backNotificacionBtn);

    }

    @Override
    public void onClick(View view) {

    }
}