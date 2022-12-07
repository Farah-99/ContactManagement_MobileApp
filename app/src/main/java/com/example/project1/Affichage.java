package com.example.project1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;



import java.util.ArrayList;

public class Affichage extends AppCompatActivity {

    private ListView lv_aff;
    Button btn_supp;
    ArrayList<Contact> data = new ArrayList<Contact>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);

        lv_aff = findViewById(R.id.lv_aff);
        Button btn_supp = findViewById(R.id.btnsup_aff);
        // without sql light
         /*data.add(new Produit(1, "pc",  "efg", 12.5, 100));
        data.add(new Produit(2, "clavier",  "bla", 15.5, 150));
        data.add(new Produit(3, "souris",  "aaa", 20.5, 10));
        data.add(new Produit(4, "tapis",  "ccv", 10.5, 1000));*/

        /*ArrayAdapter ad = new ArrayAdapter(Affichage.this, android.R.layout.simple_list_item_1 , data) ;
        // gerer l'ensemble des list view grace a l'adapter
        lv_aff.setAdapter(ad);*/

        // with sql light
        //ProduitManager manager = new ProduitManager(Affichage.this);
        ContactManager manager = new ContactManager(Affichage.this);
        manager.ouvrir();
        //manager.ajout( "Fekih",  "Farah", "farahfekiih@gmail.com", "99786225");


        data = manager.getAllContact();

        MonAdapterContact ad = new MonAdapterContact(Affichage.this,  data) ;
        lv_aff.setAdapter(ad);
        /*btn_supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

    }
}