package com.codejunior.testservice.view;


import static com.codejunior.testservice.modelo.data.Schema.Utilities.INSERT_CATEGORIA;

import static com.codejunior.testservice.modelo.data.Schema.Utilities.INSERT_VIDEOJUEGO;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.codejunior.testservice.databinding.ActivityMainBinding;
import com.codejunior.testservice.interfaces.Resource;
import com.codejunior.testservice.modelo.adapter.MyRecyclerViewAdapter;
import com.codejunior.testservice.modelo.data.Conexion;
import com.codejunior.testservice.server.App;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements Resource {

    App http = new App(4545);
    public ActivityMainBinding mainBinding;
    public MyRecyclerViewAdapter myRecyclerViewAdapter;
    Context context;
     public static final String[] vOption = new String[]{"ALMACENAR", "VER ALQUILERES", "VER REGISTROS", "VENTA POR DIA"};

    // Evento de creación de Android
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        this.context=MainActivity.this;
        System.out.println("Inicio del servicio");

        try {
            http.start();
            Conexion conexion = new Conexion();
            SQLiteDatabase sqLiteDatabase = conexion.getWritableDatabase();

            sqLiteDatabase.execSQL(INSERT_CATEGORIA);
            sqLiteDatabase.execSQL(INSERT_VIDEOJUEGO);

            System.out.println("Inicio del servicio completo");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error de inicio del servicio");
        }

        mainBinding.recycler.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(vOption, getApplicationContext(), this);
        mainBinding.recycler.setAdapter(myRecyclerViewAdapter);
        mainBinding.executePendingBindings();
    }

    // Evento de destrucción de Android
    @Override
    protected void onDestroy() {
        super.onDestroy();
        http.stop();
    }

    @Override
    public void selection(String option) {
        if (option.equals("ALMACENAR")) {

            Toast.makeText(getApplicationContext(), option, Toast.LENGTH_LONG).show();
            startActivity(new Intent(context,RegisterLibro.class));

        }
    }


}
