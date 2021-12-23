package com.codejunior.testservice.view;


import static com.codejunior.testservice.modelo.data.Schema.Utilities.INSERT_CATEGORIA;

import static com.codejunior.testservice.modelo.data.Schema.Utilities.INSERT_VIDEOJUEGO;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.codejunior.testservice.R;
import com.codejunior.testservice.databinding.ActivityMainBinding;
import com.codejunior.testservice.modelo.data.Conexion;
import com.codejunior.testservice.server.App;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    App http = new App(4545);
    public  static ActivityMainBinding mainBinding;
    // Evento de creación de Android
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        System.out.println("Inicio del servicio");

        try {
            http.start();
            Conexion conexion = new Conexion(getApplicationContext());
            SQLiteDatabase sqLiteDatabase = conexion.getWritableDatabase();

            sqLiteDatabase.execSQL(INSERT_CATEGORIA);
            sqLiteDatabase.execSQL(INSERT_VIDEOJUEGO);

            System.out.println("Inicio del servicio completo");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error de inicio del servicio");
        }
    }

    // Evento de destrucción de Android
    @Override
    protected void onDestroy() {
        super.onDestroy();
        http.stop();
    }
}