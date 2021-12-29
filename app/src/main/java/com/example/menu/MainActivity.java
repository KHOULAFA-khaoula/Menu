package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.menu.adapter.CategoryAdapter;
import com.example.menu.model.Category;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DBSqlite myDB;
    ArrayList<String> _id,nomRest,nomCat,descreption,adresse,telephone,option,image,menu_img,reduction,category,speciality;
    ListView l1;
    Category[] categories;
    CategoryAdapter categoryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l1 = findViewById(R.id.listview);
        myDB = new DBSqlite(this);

        SharedPreferences prefs = getSharedPreferences("prefs",MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart",true);
        if (firstStart){
            InsertData();
        }
        ShowCategories();
    }

    private void InsertData(){
        DBSqlite inst = new DBSqlite(MainActivity.this);
        inst.addData();
        Log.d("creation","Accessed To DB");
        SharedPreferences prefs = getSharedPreferences("prefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart",false);
        editor.apply();
    }

    void ShowCategories() {
        categories = myDB.getAllCategories();
        categoryAdapter = new CategoryAdapter(this, categories);
        l1.setAdapter(categoryAdapter);
    }

}