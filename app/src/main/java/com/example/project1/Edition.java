package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Edition extends AppCompatActivity {
    private RecyclerView rv_contact;
    private EditText edrecherche;
    private TextView recherche;
    ArrayList<Contact> search_data = new ArrayList<Contact>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edition);
        rv_contact = findViewById(R.id.rv);
        recherche = findViewById(R.id.recher_edit);

        MonAdapterContact ad = new MonAdapterContact(Edition.this, Acceuil.data);
        //rv.setAdapter(ad);


    }
}