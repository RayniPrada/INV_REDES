package com.ejemplo.prestamocosas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class vistarRegistro extends AppCompatActivity {


    private TextView tvnombre, tvci, tvape, tvcur, tvlis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistar_registro);

        tvci = (TextView) findViewById(R.id.tv_ci);
        tvnombre = (TextView) findViewById(R.id.tv_nombre);
        tvape = (TextView) findViewById(R.id.tv_apellido);
        tvcur = (TextView) findViewById(R.id.tv_curso);
        tvlis = (TextView) findViewById(R.id.tv_lista);

        Bundle datos = this.getIntent().getExtras(); // PARA CAPTURAR LO DE AFUERA
        String ci = datos.getString("ci"); // poner los datos a un string
        tvci.setText(ci);

        String nombre = datos.getString("nombre"); // poner los datos a un string
        tvnombre.setText(nombre);

        String apellido = datos.getString("apellido"); // poner los datos a un string
        tvape.setText(apellido);

        String curso = datos.getString("curso"); // poner los datos a un string
        tvcur.setText(curso);

        String lista = datos.getString("lista"); // poner los datos a un string
        tvlis.setText(lista);
   }
    public void atras(View view){
        Intent atras = new Intent(this, Registro.class);
        startActivity(atras);
    }
}
