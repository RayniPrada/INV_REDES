package com.ejemplo.prestamocosas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Administracion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administracion);
    }
    public void Atras(View view) {
        Intent segundo = new Intent(this, MainActivity.class);
        startActivity(segundo);
    }
}
