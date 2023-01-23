package com.codejunior.testservice.view;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.codejunior.testservice.R;
import com.codejunior.testservice.databinding.ActivityRegisterLibroBinding;
import com.codejunior.testservice.modelo.Cliente;
import com.codejunior.testservice.modelo.data.Schema;

import java.util.ArrayList;
import java.util.Objects;

public class RegisterLibro extends AppCompatActivity {
    ActivityRegisterLibroBinding activityRegisterLibroBinding;
    Context context;
    ArrayList<String> category = new ArrayList<>();
     private static final Cliente cliente = new Cliente();
    ArrayAdapter<String> arrayAdapter;

    public static Cliente getCliente() {
        return cliente;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRegisterLibroBinding = ActivityRegisterLibroBinding.inflate(getLayoutInflater());
        setContentView(activityRegisterLibroBinding.getRoot());

        this.context = RegisterLibro.this;

        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, Schema.getCategorias(category));
        activityRegisterLibroBinding.spinner.setAdapter(arrayAdapter);
        cliente.setCategoria(activityRegisterLibroBinding.spinner.getSelectedItem().toString());


        activityRegisterLibroBinding.btnSgt.setOnClickListener(view -> {
            cliente.setCedula(Objects.requireNonNull(activityRegisterLibroBinding.tieCedula.getText()).toString());
            cliente.setNombre(Objects.requireNonNull(activityRegisterLibroBinding.tieNombre.getText()).toString());
            startActivity(new Intent(context,SelectCategoria.class));
        });


    }

    public void clickRadio(View view) {

        if (activityRegisterLibroBinding.radioButton.isChecked()) {
            cliente.setSexo(activityRegisterLibroBinding.radioButton.getText().toString());
        }
        if (activityRegisterLibroBinding.radioButton2.isChecked()) {
            cliente.setSexo(activityRegisterLibroBinding.radioButton.getText().toString());
        }

    }


}