package com.ejemplo.prestamocosas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    private EditText ci,nombre,apellido,lista;
    private Spinner curso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    ci=(EditText)findViewById(R.id.nro_ci);
    nombre=(EditText)findViewById(R.id.nombre);
    apellido=(EditText)findViewById(R.id.apellido);
    curso=(Spinner) findViewById(R.id.curso);
    lista=(EditText) findViewById(R.id.lista);
        String[] opciones = {"primero","Segundo","Tercero","Cuarto","Quinto"};
        ArrayAdapter<String> adaptar = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        curso.setAdapter(adaptar);
    }
    public void Registrar(View view){
        DatosSqliteHelper admin = new DatosSqliteHelper(this, "prestamo",null, 1);
        SQLiteDatabase prestamoBaseDatos = admin.getWritableDatabase();
        // ""caputar los datos""

        String cii=ci.getText().toString();
        String nombree=nombre.getText().toString();
        String apellidoo=apellido.getText().toString();
        String cursoo = curso.getSelectedItem().toString();
        String list=lista.getText().toString();

        if(!cii.isEmpty() && !nombree.isEmpty() && !apellidoo.isEmpty() && !cursoo.isEmpty() && !list.isEmpty()){
            ContentValues insert = new ContentValues();
            insert.put("ci",cii);
            insert.put("nombre",nombree);
            insert.put("apellido",apellidoo);
            insert.put("curso",cursoo);
            insert.put("lista",list);

            prestamoBaseDatos.insert("prestamo",null,insert);
            prestamoBaseDatos.close();
            ci.setText("");
            nombre.setText("");
            apellido.setText("");
            curso.getSelectedItem();
            lista.setText("");
            Toast.makeText(this,"Registrado con exito"+nombree, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Debes llenar los datos", Toast.LENGTH_LONG).show();
        }
        //implementar validacion de campos vacios en el mismo metodo
        Intent segundo = new Intent(this, vistarRegistro.class);
        segundo.putExtra("ci",cii);
        segundo.putExtra("nombre",nombree);
        segundo.putExtra("apellido",apellidoo);
        segundo.putExtra("curso",cursoo);
        segundo.putExtra("lista",list);
        startActivity(segundo);

    }
    public void atras(View view){
        Intent atras = new Intent(this, MainActivity.class);
        startActivity(atras);
    }
}
