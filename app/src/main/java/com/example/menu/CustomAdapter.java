package com.example.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList _id,nomRest,nomCat,Reduction;

    CustomAdapter(Context context,ArrayList _id,ArrayList nomRest, ArrayList nomCat,ArrayList Reduction){
    this.context = context;
    this._id = _id;
    this.nomRest = nomRest;
    this.nomCat = nomCat;
    this.Reduction = Reduction;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder._id.setText(String.valueOf(_id.get(position)));
        holder.nomRest.setText(String.valueOf(nomRest.get(position)));
        holder.nomCat.setText(String.valueOf(nomCat.get(position)));
        holder.Reduction.setText(String.valueOf(Reduction.get(position)));

    }

    @Override
    public int getItemCount() {
        return _id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView _id,nomRest,nomCat,Reduction;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            _id = itemView.findViewById(R.id._id);
            nomRest = itemView.findViewById(R.id.nomRest);
            nomCat = itemView.findViewById(R.id.nomCat);
            Reduction = itemView.findViewById(R.id.Reduction);
        }
    }
}
