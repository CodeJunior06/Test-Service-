package com.codejunior.testservice.modelo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codejunior.testservice.databinding.ButtonBinding;
import com.codejunior.testservice.interfaces.Resource;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>  {
    String[] option;
    static Context context;
    String opc;
    public static Resource resource;
    public MyRecyclerViewAdapter(String[] option, Context context, Resource resource) {
        this.option = option;
        this.context = context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ButtonBinding buttonBinding = ButtonBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(buttonBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        opc = option[position];
        holder.bind(opc);
    }

    @Override
    public int getItemCount() {
        return option.length;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder  {
        ButtonBinding buttonBinding;

        ViewHolder(ButtonBinding itemView) {
            super(itemView.getRoot());
            this.buttonBinding = itemView;
        }
        public void bind(String option){
            buttonBinding.buttonId.setText(option);
            buttonBinding.buttonId.setOnClickListener(view ->resource.selection(option));

        }

    }

}
