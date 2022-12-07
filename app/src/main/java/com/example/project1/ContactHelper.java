package com.example.project1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContactHelper extends SQLiteOpenHelper {


    public static final String table_contact = "Contact";
    public static final String col_id = "ID";
    public static final String col_nom = "Nom";
    public static final String col_prenom = "Prenom";
    public static final String col_email = "Email";
    public static final String col_numero = "Numero";

    String requeute = "create table "+ table_contact + " (" +  col_id + " Integer Primary Key Autoincrement, " +
            col_nom + " Text not null, " + col_prenom + " Text not null, " +
            col_email + " Text not null, " + col_numero + " Text not null)";




    public ContactHelper(@Nullable Context context, @Nullable String name,
                         @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Lors de l'ouverture de la base
        db.execSQL(requeute);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //En cas de modification de la version
        db.execSQL("drop table "+table_contact);
        onCreate(db);
    }
}
