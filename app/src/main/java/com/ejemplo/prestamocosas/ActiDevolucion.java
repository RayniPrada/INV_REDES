package com.ejemplo.prestamocosas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActiDevolucion extends AppCompatActivity {
    private EditText ci;
    private TextView  tv1, tv2, tv3, tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acti_devolucion);
        ci = (EditText) findViewById(R.id.ci);
        tv1 = (TextView) findViewById(R.id.nombre);
        tv2 = (TextView) findViewById(R.id.apellido);
        tv3 = (TextView) findViewById(R.id.curso);
        tv4 = (TextView) findViewById(R.id.lista);
    }
    public void Buscar(View view){
        DatosSqliteHelper admin= new DatosSqliteHelper(this, "prestamo", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String cii = ci.getText().toString();
        if(!cii.isEmpty())
        {
            Cursor fila= db.rawQuery("select * from prestamo where ci = "+cii, null);
            if (fila.moveToFirst())
            {

                ci.setText(fila.getString(0));
                tv1.setText(fila.getString(1));
                tv2.setText(fila.getString(2));
                tv3.setText(fila.getString(3));
                tv4.setText(fila.getString(4));
                db.close();
            }else
            {
                Toast.makeText(this, "No existe los datos", Toast.LENGTH_LONG).show();
                db.close();
            }
        }else{
            Toast.makeText(this, "Debes darme el ci", Toast.LENGTH_LONG).show();
        }
    }
    public void Elimina(View view)
    {
        DatosSqliteHelper admin= new DatosSqliteHelper(this, "prestamo", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String cii = ci.getText().toString();

        if(!cii.isEmpty())
        {
            int cant = db.delete("prestamo","ci = "+cii,null);
            db.close();
            //dejar los campos vacios
            if(cant ==1){
                Toast.makeText(this, "exito",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "ci inexistente",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "campo vacio",Toast.LENGTH_LONG).show();
        }
        ci.setText("");
        tv1.setText("");
        tv2.setText("");
        tv3.setText("");
        tv4.setText("");


    }
    public void atras(View view) {
        Intent atras = new Intent(this, MainActivity.class);
        startActivity(atras);
    }
}