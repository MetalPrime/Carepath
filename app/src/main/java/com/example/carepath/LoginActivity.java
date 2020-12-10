package com.example.carepath;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth auth;
    private FirebaseDatabase database;

    private EditText correo;
    private EditText password;

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        correo = findViewById(R.id.inputCorreoLogin);
        password = findViewById(R.id.inputContrasenaLogin);

        login = findViewById(R.id.botonIniciarsesionLogin);

        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.botonIniciarsesionLogin:

                //confirmacion del perfil de autenticacion
                auth.signInWithEmailAndPassword(correo.getText().toString().trim(), password.getText().toString().trim())
                        .addOnCompleteListener(
                                task -> {
                                    if(task.isSuccessful()){

                                        verificacionInquilino();

                                    }else{

                                        //generador de errores
                                        Toast.makeText(this,task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                    }
                                }
                        );

                break;
        }
    }

    public void verificacionInquilino(){

        String id = auth.getCurrentUser().getUid();

        database.getReference().child("inquilinos").child(id).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        Inquilino inquilino = snapshot.getValue(Inquilino.class);

                        if (inquilino.getEstado().equals("inquilino")){

                            //cambio de pantalla
                            Intent m = new Intent(getBaseContext(),MainActivity.class);
                            startActivity(m);
                            finish();

                        }else {

                            AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext())
                                    .setTitle("Problema de logeo")
                                    .setMessage("¿Estás seguro que eres inquilino?")
                                    .setPositiveButton("Si", (dialog, idD) -> {

                                        auth.signOut();
                                        dialog.dismiss();

                                    })
                                    .setNegativeButton("No", (dialog, idD) -> {

                                        auth.signOut();
                                        Intent m = new Intent(getBaseContext(), LoginRegistroActivity.class);
                                        startActivity(m);
                                        finish();

                                    });
                            builder.show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                }
        );

    }
}