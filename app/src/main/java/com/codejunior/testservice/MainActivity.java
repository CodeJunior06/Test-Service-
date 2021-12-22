package com.codejunior.testservice;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.codejunior.testservice.modelo.data.Conexion;
import com.codejunior.testservice.server.App;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    App http = new App(4545);
    
    // Evento de creación de Android
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Inicio del servicio");
        try {
            http.start();
            Conexion conexion = new Conexion(getApplicationContext());
            SQLiteDatabase sqLiteDatabase = conexion.getWritableDatabase();
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