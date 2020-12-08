package com.example.carepath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText numero;
    private EditText correo;
    private EditText tipoIdentificacion;
    private EditText numeroIdentificacion;
    private EditText torre;
    private EditText apartamento;
    private EditText nombreUsuario;
    private EditText password;
    private EditText confPassword;

    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registrar = findViewById(R.id.botonRegistrarRegistro);

        nombre = findViewById(R.id.inputNombreRegistro);
        apellido = findViewById(R.id.inputApellidoRegistro);
        numero = findViewById(R.id.inputCelularRegistro);
        correo = findViewById(R.id.inputCorreoRegistro);
        tipoIdentificacion = findViewById(R.id.inputTipoIdRegistro);
        numeroIdentificacion = findViewById(R.id.inputNumeroIdRegistro);
        torre = findViewById(R.id.inputTorreRegistro);
        apartamento = findViewById(R.id.inputApartamentoRegistro);
        nombreUsuario = findViewById(R.id.inputNombreUsuarioRegistro);
        password = findViewById(R.id.inputContrasenaRegistro);
        password = findViewById(R.id.inputConfirmarContrasenaRegistro);

    }
}