package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroActividadAvtivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase database;
    private FirebaseAuth auth;

    private ImageButton botonHomePage;
    private ImageButton botonAgenda;
    private ImageButton botonVisitante;
    private ImageButton botonNotificacion;

    //botones individuales
    private Button backRegistroActividad;
    private Button aggActividad;

    //informacion pedida
    private EditText cantidadDeGente;
    private EditText metodoDeTransporte;
    private EditText horaDeLlegada;
    private EditText horaDeSalida;
    private EditText motivo;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_actividad_avtivity);

        if (auth.getCurrentUser() == null) fueraDeLaPAgina();
        else {

            database = FirebaseDatabase.getInstance();
            auth = FirebaseAuth.getInstance();

            botonHomePage = findViewById(R.id.botonHome);
            botonAgenda = findViewById(R.id.botonAgenda);
            botonVisitante = findViewById(R.id.botonVisita);
            botonNotificacion = findViewById(R.id.botonNotificaciones);
            backRegistroActividad = findViewById(R.id.backRegistroAvticidadBtn);
            aggActividad = findViewById(R.id.aggSalida);

            cantidadDeGente = findViewById(R.id.inputCantidadGenteRV);
            metodoDeTransporte = findViewById(R.id.inputTransporteRV);
            horaDeLlegada = findViewById(R.id.inputHoraDeLlegadaRV);
            horaDeSalida = findViewById(R.id.inputHoraDeSalidaRV);
            motivo = findViewById(R.id.inputRazonDeSalidaRV);

            botonHomePage.setOnClickListener(this);
            botonAgenda.setOnClickListener(this);
            botonVisitante.setOnClickListener(this);
            botonNotificacion.setOnClickListener(this);
            aggActividad.setOnClickListener(this);
            backRegistroActividad.setOnClickListener(this);

        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.backRegistroAvticidadBtn:
                break;

            case R.id.aggSalida:
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