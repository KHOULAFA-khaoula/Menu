package com.example.menu.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menu.Home;
import com.example.menu.R;
import com.example.menu.model.Category;


public class CategoryAdapter extends ArrayAdapter<Category> {
    private Context context;

    private Category[] listeCategory;

    public CategoryAdapter(Context context, Category[] listeCategory) {
        super(context, R.layout.category_item, listeCategory);
        this.listeCategory = listeCategory;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // Permet de lier un layout à un autre
        LayoutInflater inflater = LayoutInflater.from(getContext());

        //Layout View ==> créer un view a adpatée

        View listItemView = inflater.inflate(R.layout.category_item, parent, false);

        TextView CategoryNom = (TextView) listItemView.findViewById(R.id.textView);

        CategoryNom.setText(listeCategory[position].getNom_category());
        listItemView.setBackgroundResource(listeCategory[position].getImage());

        listItemView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
              //  Toast.makeText(getContext(), listeCategory[position].getNom_category(), Toast.LENGTH_LONG).show();
                toRestaurantActivity(position);
            }

        });

        return listItemView;

    }

    private void toRestaurantActivity(int position) {
        Intent switchToRestaurant = new Intent(getContext(), Home.class);
        switchToRestaurant.putExtra("Category_music",listeCategory[position].getMusic());
        switchToRestaurant.putExtra("Category_name",listeCategory[position].getNom_category());
        // switchToRestaurant.putExtra("Category_music",R.raw.italian_music);
        getContext().startActivity(switchToRestaurant);
    }


}




