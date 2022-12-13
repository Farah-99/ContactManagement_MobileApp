package com.example.project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ContactManager {

    SQLiteDatabase db = null;
    Context context;

    ContactManager(Context context){
        this.context = context;
    }

    public void ouvrir(){
        ContactHelper helper = new ContactHelper(context,"mabased.db",null, 1);
        db = helper.getWritableDatabase();
    }

    public long ajout(String nom, String prenom, String email, String numero){
        long res = 0;
        ContentValues values = new ContentValues();

        values.put(ContactHelper.col_nom, nom);
        values.put(ContactHelper.col_prenom,prenom);
        values.put(ContactHelper.col_email,email);
        values.put(ContactHelper.col_numero,numero);

        res = db.insert(ContactHelper.table_contact, null, values);
        return res;
    }

    public ArrayList<Contact> getAllContact(){
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        Cursor cr = db.query(ContactHelper.table_contact,
                new String[]{ContactHelper.col_id,
                        ContactHelper.col_nom,
                        ContactHelper.col_prenom,
                        ContactHelper.col_email,
                        ContactHelper.col_numero},
                null, null,
                null,null,null);

        cr.moveToFirst();
        while (!cr.isAfterLast()){
            int i1 = cr.getInt(0);
            String i2 = cr.getString(1);
            String i3 = cr.getString(2);
            String i4 = cr.getString(3);
            String i5 = cr.getString(4);
            contacts.add(new Contact(i1,i2,i3,i4,i5));
            cr.moveToNext();
        }

        return contacts;
    }

    public void supprimerItem(String i){
        db.delete(ContactHelper.table_contact, "col_email=?",new String[]{i});
        db.close();
    }

    public void fermer(){

    }
}
