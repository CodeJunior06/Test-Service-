package com.codejunior.testservice.modelo.data;

import static com.codejunior.testservice.modelo.data.Schema.Utilities.*;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.codejunior.testservice.view.Splash;

public class Conexion extends SQLiteOpenHelper {
    public static  Conexion conexion=null;
    public Conexion() {
        super(Splash.context, Schema.Utilities.DB, null, Schema.Utilities.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_CATEGORIAS);
        sqLiteDatabase.execSQL(SQL_CREATE_CLIENTES);
        sqLiteDatabase.execSQL(SQL_CREATE_VIDEO_JUEGOS);
        sqLiteDatabase.execSQL(SQL_CREATE_FACTURAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_CATEGORIAS);
        sqLiteDatabase.execSQL(SQL_DELETE_CLIENTES);
        sqLiteDatabase.execSQL(SQL_DELETE_VIDEO_JUEGOS);
        sqLiteDatabase.execSQL(SQL_DELETE_FACTURAS);
        onCreate(sqLiteDatabase);
    }

    public static Conexion getInstance( ){
        if(conexion==null){
            conexion = new Conexion();
        }
        return conexion;
    }

}
