package com.example.menu;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBSqlite extends SQLiteOpenHelper {
    private Context context;
    public static final String DB_NAME ="My_Menu.db";
    public static final  String Table_NameF = "restaurent";
    public static final  String Table_NameD1 = "category";
    public static final  String Table_NameD2 = "option";
    public static final  int DB_version = 1;
    public static final  String Column_id = "_id";
    public static final  String Column_Nom = "nom";
    public static final  String Column_Description = "descreption";
    public static final  String Column_Adresse = "adresse";
    public static final  String Column_Telephone = "telephone";
    public static final  String Column_Option = "option";
    public static final  String Column_Image = "image";
    public static final  String Column_Menu_img = "menu_img";
    public static final  String Column_Reduction = "reduction";
    public static final  String Column_Category = "category";
    public static final  String Column_Speciality = "speciality";
    public static final  String Column_id_op = "_id";
    public static final  String Column_id_cat = "_id";
    public static final  String Column_Nom_cat = "nom";
    public static final  String Column_Nom_op = "nom";

    public DBSqlite(@Nullable Context context) {
        super(context, DB_NAME, null, DB_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryF = "CREATE TABLE " +Table_NameF
                +"("
                +Column_id+" Integer primary key AUTOINCREMENT,"
                +Column_Nom+" Text,"
                +Column_Nom_cat+" Text,"
                +Column_Description+" Text,"
                +Column_Adresse+" Text,"
                +Column_Telephone+" Text,"
                +Column_Option+" INTEGER,"
                +Column_Image+" Text,"
                +Column_Menu_img+" Text,"
                +Column_Reduction+" Text,"
                +Column_Category+" INTEGER,"
                +Column_Speciality+" Text,"
                +"FOREIGN KEY("+Column_Option+") REFERENCES "+Table_NameD2+"("+Column_id_op+"),"
                +"FOREIGN KEY("+Column_Nom_cat+") REFERENCES "+Table_NameD1+"("+Column_id_cat+"));";
        String queryD1 = "create table "+Table_NameD1+"("+Column_id_cat+" Integer primary key AUTOINCREMENT,"+Column_Nom_cat+" Text"+");";
        String queryD2 = "create table "+Table_NameD2+"("+Column_id_op+" Integer primary key AUTOINCREMENT,"+Column_Nom_op+" Text"+");";
        db.execSQL(queryD1);
        db.execSQL(queryD2);
        db.execSQL(queryF);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_NameF);
        db.execSQL("DROP TABLE IF EXISTS "+Table_NameD1);
        db.execSQL("DROP TABLE IF EXISTS "+Table_NameD2);
        onCreate(db);

    }
    void addData(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Column_Nom_cat,"BURGER");
        db.insert(Table_NameD1,null,cv);
        cv.put(Column_Nom_cat,"PIZZA");
        db.insert(Table_NameD1,null,cv);
        cv.put(Column_Nom_cat,"COFFE");
        db.insert(Table_NameD1,null,cv);
        cv.put(Column_Nom_op,"Sur place");
        db.insert(Table_NameD2,null,cv);
        cv.put(Column_Nom_op,"A emporter");
        db.insert(Table_NameD2,null,cv);
        cv.put(Column_Nom_op,"Traiteur");
        long result = db.insert(Table_NameD2,null,cv);
        if(result == -1){
            Toast.makeText(context,"failed",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Added successfully!",Toast.LENGTH_SHORT).show();
        }
    }
}
