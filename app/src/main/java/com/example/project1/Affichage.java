package com.example.project1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;



import java.util.ArrayList;

public class Affichage extends AppCompatActivity {

    private ListView lv_aff;
    ArrayList<Contact> data = new ArrayList<Contact>();
    ArrayList<Contact> search_data_orig = new ArrayList<>();
    private EditText searchBar ;
    MonAdapterContact ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);

        lv_aff = findViewById(R.id.lv_aff);
        searchBar = findViewById(R.id.recher_edit);


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
        search_data_orig = manager.getAllContact();

        ad = new MonAdapterContact(Affichage.this,  data) ;
        lv_aff.setAdapter(ad);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                data = filter_arrayList_Contact(charSequence.toString());
                ad = new MonAdapterContact(getApplicationContext(),data);
                lv_aff.setAdapter(ad);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }

    private ArrayList<Contact> filter_arrayList_Contact (String textFilter)
    {
        ArrayList<Contact> search_data_temp= new ArrayList<>();
        if (textFilter != null)
        {
            for (int i =0; i< search_data_orig.size(); i++)
            {
                // verifier que l elemnet qu on est en train de boucler contient notre textFilter
                if (search_data_orig.get(i).getNom().toUpperCase().contains(textFilter.toUpperCase())){
                    search_data_temp.add(search_data_orig.get(i));
                }
            }
        }else {
            search_data_temp = search_data_orig;
        }
        return search_data_temp;
    }


}