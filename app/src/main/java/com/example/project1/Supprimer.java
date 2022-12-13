package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Supprimer extends  AppCompatActivity{

    private TextView edemail;
    private Button btnsupp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);


        edemail = findViewById(R.id.tv_mail_el);


        btnsupp = findViewById(R.id.btnsup_aff);

        btnsupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = edemail.getText().toString();
                ContactManager manager = new ContactManager(Supprimer.this);
                manager.ouvrir();
                manager.supprimerItem(email);
                Intent i = new Intent(Supprimer.this, Affichage.class);
                startActivity(i);


            }
        });


    }
}