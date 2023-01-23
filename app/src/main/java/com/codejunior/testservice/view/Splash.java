package com.codejunior.testservice.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.codejunior.testservice.R;
import com.codejunior.testservice.modelo.data.Conexion;

public class Splash extends AppCompatActivity {


    private static SQLiteDatabase sqLiteDatabase;
    public static Context context;

    public static SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }

    public static final Conexion conexion = Conexion.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        context = getApplicationContext();
        this.test();
    }

    protected void test() {
        sqLiteDatabase = conexion.getReadableDatabase();

    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(() -> {
            startActivity(new Intent(context, MainActivity.class));
            finish();
        }, 3000);
    }
}