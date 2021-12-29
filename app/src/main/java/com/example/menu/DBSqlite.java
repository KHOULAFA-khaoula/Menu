package com.example.menu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.menu.model.Category;

import java.util.ArrayList;

public class DBSqlite extends SQLiteOpenHelper {
    private static DBSqlite sInstance;
    private Context context;
    public static final String DB_NAME ="My_Menu.db";
    public static final  String Table_NameF = "restaurent";
    public static final  String Table_NameD1 = "category";
    public static final  String Table_NameD2 = "option";
    public static final  int DB_version = 1;
    public static final  String Column_id = "_id";
    public static final  String Column_Nom = "nomRest";
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
    public static final  String Column_Nom_cat = "nomCat";
    public static final  String Column_Nom_op = "nomOpt";
    public static final  String Column_Img_Cat ="Image_category";
    public static final String Column_Cat_music="category_music";

    /*public static synchronized DBSqlite getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        if (sInstance == null) {
            sInstance = new DBSqlite(context.getApplicationContext());
            //sInstance.addData();
        }
        return sInstance;
    }*/

    public DBSqlite(@Nullable Context context) {
        super(context, DB_NAME, null, DB_version);
        Log.d("const","in middle of construction");
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("creat","in middle of construction");
        String queryD1 = "create table "+Table_NameD1+"("+Column_id_cat+" Integer primary key AUTOINCREMENT,"+Column_Nom_cat+" Text,"+Column_Img_Cat+" INTEGER,"+Column_Cat_music+" INTEGER"+");";
        String queryD2 = "create table "+Table_NameD2+"("+Column_id_op+" Integer primary key AUTOINCREMENT,"+Column_Nom_op+" Text"+");";
        String queryF  = "create table "+Table_NameF+"("+Column_id+" Integer primary key AUTOINCREMENT,"+Column_Nom+" Text,"+Column_Nom_cat+" Text,"+Column_Description+" Text,"+Column_Adresse+" Text,"+Column_Telephone+" Text,"+Column_Option+" Text,"+Column_Image+" Text,"+Column_Menu_img+" Text,"+Column_Reduction+" Text,"+Column_Category+" Text,"+Column_Speciality+" Text,"+"FOREIGN KEY("+Column_Option+") REFERENCES "+Table_NameD2+"("+Column_id_op+"),"+"FOREIGN KEY("+Column_Nom_cat+") REFERENCES "+Table_NameD1+"("+Column_id_cat+"));";
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

        cv.put(Column_Nom_cat,"FAST-FOOD");
        cv.put(Column_Img_Cat,R.drawable.fastfood);
        cv.put(Column_Cat_music,R.raw.fast_food_music);
        db.insert(Table_NameD1,null,cv);
        //##########################################
        cv.put(Column_Nom_cat,"ITALIEN");
        cv.put(Column_Img_Cat,R.drawable.italian);
        cv.put(Column_Cat_music,R.raw.italian_music);
        db.insert(Table_NameD1,null,cv);
        //##########################################
        cv.put(Column_Nom_cat,"COFFE");
        cv.put(Column_Img_Cat,R.drawable.coffe);
        cv.put(Column_Cat_music,R.raw.coffe_music);
        db.insert(Table_NameD1,null,cv);
        //##########################################
        cv.put(Column_Nom_cat,"ASIAN");
        cv.put(Column_Img_Cat,R.drawable.asian);
        cv.put(Column_Cat_music,R.raw.asian_music);
        db.insert(Table_NameD1,null,cv);
        //##########################################
        cv.put(Column_Nom_cat,"ORIENTAL");
        cv.put(Column_Img_Cat,R.drawable.oriental);
        cv.put(Column_Cat_music,R.raw.oriental_music);
        db.insert(Table_NameD1,null,cv);
        //##########################################
        cv.put(Column_Nom_cat,"MOROCCAN");
        cv.put(Column_Img_Cat,R.drawable.moroccan);
        cv.put(Column_Cat_music,R.raw.moroccan_music);
        db.insert(Table_NameD1,null,cv);

        ContentValues cv1 = new ContentValues();
        cv1.put(Column_Nom_op,"Sur place");
        db.insert(Table_NameD2,null,cv1);
        cv1.put(Column_Nom_op,"A emporter");
        db.insert(Table_NameD2,null,cv1);
        cv1.put(Column_Nom_op,"Traiteur");
        db.insert(Table_NameD2,null,cv1);
        ContentValues cv2 = new ContentValues();
        cv2.put(Column_Nom,"Le Gouthé");
        cv2.put(Column_Nom_cat,"COFFE");
        cv2.put(Column_Description,"Cuisine maison, plats raffinés et classiques, ambiance décontractée et conviviale, café familial.");
        cv2.put(Column_Adresse,"Villa 92 , quartier mabroka (abwab gueliz)\n" +
                "Marrakech");
        cv2.put(Column_Telephone,"0661965115");
        cv2.put(Column_Option,"Sur place");
        cv2.put(Column_Image,"gouth");
        cv2.put(Column_Menu_img,"src/main/res/drawable-v24/gouth1.jpg");
        cv2.put(Column_Reduction,"0%");
        cv2.put(Column_Category,"COFFE");
        Log.d("middle","in middle of creation");
        cv2.put(Column_Speciality,"Petit-déjeuner, Café, Pizza, Tacos, Crêpes");
        db.insert(Table_NameF,null,cv2);
        ContentValues cv3 = new ContentValues();
        cv3.put(Column_Nom,"Allo mama");
        cv3.put(Column_Nom_cat,"ITALIEN");
        cv3.put(Column_Description,"Cuisine maison, plats raffinés et classiques, ambiance décontractée et conviviale, café familial.");
        cv3.put(Column_Adresse,"Residence Rayhana Imm LC5 MAG 36\n" +
                "(En face centre mabrouka de langues)\n" +
                "Marrakech");
        cv3.put(Column_Telephone,"0525006603");
        cv3.put(Column_Option,"Sur place");
        cv3.put(Column_Image,"aloo");
        cv3.put(Column_Menu_img,"src/main/res/drawable-v24/gouth1.jpg");
        cv3.put(Column_Reduction,"20%");
        cv3.put(Column_Category,"ITALIEN");
        Log.d("middle","in middle of creation");
        cv3.put(Column_Speciality,"Italien, Pâtes, Pizza");
        db.insert(Table_NameF,null,cv3);
        ContentValues cv4 = new ContentValues();
        cv4.put(Column_Nom,"Zatchi sushi");
        cv4.put(Column_Nom_cat,"ASIAN");
        cv4.put(Column_Description,"Asian modern cuisine");
        cv4.put(Column_Adresse,"Rue oummo El banine, N1\n" +
                "Marrakech");
        cv4.put(Column_Telephone,"05244-34343");
        cv4.put(Column_Option,"Sur place");
        cv4.put(Column_Image,"zatchi");
        cv4.put(Column_Menu_img,"src/main/res/drawable-v24/gouth1.jpg");
        cv4.put(Column_Reduction,"15%");
        cv4.put(Column_Category,"ASIAN");
        Log.d("middle","in middle of creation");
        cv4.put(Column_Speciality,"Sushis, Desserts, Nems");
        db.insert(Table_NameF,null,cv4);
        ContentValues cv5 = new ContentValues();
        cv5.put(Column_Nom,"Café Lobo");
        cv5.put(Column_Nom_cat,"COFFE");
        cv5.put(Column_Description,"Cuisine maison, plats raffinés et classiques, ambiance décontractée et conviviale, café familial.");
        cv5.put(Column_Adresse,"Imm N°1 Rés Les Oliviers 2, Avenue Mohamed VI\n" +
                "Marrakech");
        cv5.put(Column_Telephone,"05244-22422");
        cv5.put(Column_Option,"Sur place");
        cv5.put(Column_Image,"lobo");
        cv5.put(Column_Menu_img,"src/main/res/drawable-v24/gouth1.jpg");
        cv5.put(Column_Reduction,"10%");
        cv5.put(Column_Category,"COFFE");
        Log.d("middle","in middle of creation");
        cv5.put(Column_Speciality,"Café, Petit-déjeuner, Pizza, Tapas");
        db.insert(Table_NameF,null,cv5);
        //####################################################################
        ContentValues cv6 = new ContentValues();
        cv6.put(Column_Nom,"Café La Giraffe");
        cv6.put(Column_Nom_cat,"COFFE");
        cv6.put(Column_Description,"Cuisine maison, plats raffinés et classiques, ambiance décontractée et conviviale, café familial.");
        cv6.put(Column_Adresse,"Avenue tasseltant, n528 sidi youssef el waha\n" +
                "(el waha)");
        cv6.put(Column_Telephone,"0602984878");
        cv6.put(Column_Option,"Sur place");
        cv6.put(Column_Image,"giraffe");
        cv6.put(Column_Menu_img,"src/main/res/drawable-v24/gouth1.jpg");
        cv6.put(Column_Reduction,"10%");
        cv6.put(Column_Category,"COFFE");
        Log.d("middle","in middle of creation");
        cv6.put(Column_Speciality,"Pizza");
        db.insert(Table_NameF,null,cv6);
        //#######################################################################
        ContentValues cv7 = new ContentValues();
        cv7.put(Column_Nom,"CNews Café");
        cv7.put(Column_Nom_cat,"COFFE");
        cv7.put(Column_Description,"Cuisine maison, plats raffinés et classiques, ambiance décontractée et conviviale, café familial.");
        cv7.put(Column_Adresse,"1 Rue Abou Baker Seddiq");
        cv7.put(Column_Telephone,"05 24 44 99 99");
        cv7.put(Column_Option,"Sur place");
        cv7.put(Column_Image,"cnews");
        cv7.put(Column_Menu_img,"src/main/res/drawable-v24/gouth1.jpg");
        cv7.put(Column_Reduction,"10%");
        cv7.put(Column_Category,"COFFE");
        Log.d("middle","in middle of creation");
        cv7.put(Column_Speciality,"Fast-food, Petit-déjeuner, Café");
        long result = db.insert(Table_NameF,null,cv7);
        if(result == -1){
            Toast.makeText(context,"failed",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Added successfully!",Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readData(){
        String query = "SELECT * FROM "+Table_NameF;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db!=null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    public Category[] getAllCategories()
    {
        ArrayList<Category> categoryList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+Table_NameD1,null);

        while (cursor.moveToNext())
        {
            int id =  cursor.getInt(0);
            String category_name = cursor.getString(1);
            int image = cursor.getInt(2);
            int music = cursor.getInt(3);
            Category category = new Category(id,category_name,image,music);
            categoryList.add(category);
        }
        return categoryList.toArray(new Category[categoryList.size()]);
    }

    Cursor getRestaurantByCat(String category){
        String query = "SELECT * FROM "+Table_NameF+" WHERE category = '"+category+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db!=null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

}
