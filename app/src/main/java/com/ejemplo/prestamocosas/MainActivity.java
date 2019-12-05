package com.ejemplo.prestamocosas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Registro(View view) {
        Intent segundo = new Intent(this, Registro.class);
        startActivity(segundo);
    }

    public void Devolucio(View view) {
       Intent segundo = new Intent(this, ActiDevolucion.class);
       startActivity(segundo);
        }


    public void Administracion(View view) {
        Intent segundoo = new Intent(this, Administracion.class);
        startActivity(segundoo);
    }
    public void devo(View view) {
        Intent segundoo = new Intent(this, ActiDevolucion.class);
        startActivity(segundoo);
    }
}

