package com.ejemplo.prestamocosas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class DatosSqliteHelper extends SQLiteOpenHelper {
    public DatosSqliteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);


    } @Override                         //esto es la base de datos
    public void onCreate(SQLiteDatabase registroDB) {
        //aqui creamos la tabla
        registroDB.execSQL("create table prestamo(ci integer(12) primary key ,nombre varchar(40)not null, apellido varchar(40) not null, curso varchar(10) not null, lista varchar(100) not null  )");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}