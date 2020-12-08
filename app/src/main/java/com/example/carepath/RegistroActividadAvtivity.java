package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class RegistroActividadAvtivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton botonHomePage;
    private ImageButton botonAgenda;
    private ImageButton botonVisitante;
    private ImageButton botonNotificacion;

    private Button backRegistroActividad;

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

        botonHomePage = findViewById(R.id.botonHome);
        botonAgenda = findViewById(R.id.botonAgenda);
        botonVisitante = findViewById(R.id.botonVisita);
        botonNotificacion = findViewById(R.id.botonNotificaciones);
        backRegistroActividad = findViewById(R.id.backRegistroAvticidadBtn);

        cantidadDeGente= findViewById(R.id.inputCantidadGenteRV);
        metodoDeTransporte= findViewById(R.id.inputTransporteRV);
        horaDeLlegada = findViewById(R.id.inputHoraDeLlegadaRV);
        horaDeSalida = findViewById(R.id.inputHoraDeSalidaRV);
        motivo = findViewById(R.id.inputRazonDeSalidaRV);


    }

    @Override
    public void onClick(View view) {

    }
}