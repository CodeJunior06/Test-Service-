package com.codejunior.testservice.view;

import static com.codejunior.testservice.view.RegisterLibro.getCliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.codejunior.testservice.R;

public class SelectCategoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_categoria);
        System.out.println(getCliente());
    }
}