package com.example.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList _id,nomRest,nomCat,Reduction,Image,Speciality, Adresse,Telephone;
    String d_name, d_speciality, d_adresse, d_tel;
    int music;

    CustomAdapter(Context context, ArrayList _id, ArrayList nomRest, ArrayList nomCat, ArrayList Reduction, ArrayList Image, ArrayList Speciality, ArrayList Adresse, ArrayList Telephone, int music){
    this.context = context;
    this._id = _id;
    this.nomRest = nomRest;
    this.nomCat = nomCat;
    this.Reduction = Reduction;
    this.Image = Image;
    this.Speciality = Speciality;
    this.Adresse = Adresse;
    this.Telephone = Telephone;
    this.music = music;
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

        int i = position;
        holder._id.setText(String.valueOf(_id.get(position)));
        holder.nomRest.setText(String.valueOf(nomRest.get(position)));
        holder.nomCat.setText(String.valueOf(nomCat.get(position)));
        holder.Reduction.setText(String.valueOf(Reduction.get(position)));
        //int ids = getId(String.valueOf(Image.get(position)), R.drawable.class);
       // holder.Image.setImageResource(R.drawable.);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d_adresse = String.valueOf(Adresse.get(i));
                d_name = String.valueOf(nomRest.get(i));
                d_speciality = String.valueOf(Speciality.get(i));
                d_tel = String.valueOf(Telephone.get(i));
                show_menu();
            }
        });

    }

    public static int getId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
            throw new RuntimeException("No resource ID found for: "
                    + resourceName + " / " + c, e);
        }
    }

    @Override
    public int getItemCount() {
        return _id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView _id,nomRest,nomCat,Reduction;
        ImageView Image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            _id = itemView.findViewById(R.id._id);
            nomRest = itemView.findViewById(R.id.nomRest);
            nomCat = itemView.findViewById(R.id.nomCat);
            Reduction = itemView.findViewById(R.id.Reduction);
            Image=itemView.findViewById(R.id.Image);
        }
    }
    public void show_menu(){
        Intent intent = new Intent(context, Menu.class);
        intent.putExtra("le_nom_du_resto", d_name);
        intent.putExtra("la_speciality", d_speciality);
        intent.putExtra("l_adresse", d_adresse);
        intent.putExtra("le_tel", d_tel);
        intent.putExtra("Category_music", music);
        context.startActivity(intent);
    }
}
