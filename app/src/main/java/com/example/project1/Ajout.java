package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Ajout extends AppCompatActivity {

    private EditText ednom, edprenom, edemail, ednum;
    private Button btnajout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        ednom = findViewById(R.id.ednom_ajt);
        edprenom = findViewById(R.id.edprenom_ajt);
        edemail = findViewById(R.id.edemail_ajt);
        ednum = findViewById(R.id.ednum_ajt);

        btnajout = findViewById(R.id.btnajt_ajt);

        btnajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = ednom.getText().toString();
                String prenom = edprenom.getText().toString();
                String email = edemail.getText().toString();
                String numero = ednum.getText().toString();
                if (nom.equals("") || prenom.equals("")){
                    Toast.makeText(Ajout.this, "Les cases du nom et prenom doit étre remplisses", Toast.LENGTH_SHORT).show();
                } else if (!email.equals("") &&(email.indexOf('@')==-1 || email.indexOf('.')==-1)) {
                    Toast.makeText(Ajout.this, "Format d'email incorrecte.", Toast.LENGTH_SHORT).show();
                } else {
                    ContactManager manager = new ContactManager(Ajout.this);
                    manager.ouvrir();
                    manager.ajout(nom,prenom,email,numero);
                    Intent i = new Intent(Ajout.this, Affichage.class);
                    startActivity(i);
                }

            }
        });


    }
}