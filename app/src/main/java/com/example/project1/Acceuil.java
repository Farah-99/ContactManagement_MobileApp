package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Acceuil extends AppCompatActivity {

    private TextView tvusername;
    private Button btnajout, btnaffi,btnedit;
    public static ArrayList<Contact> data=new ArrayList<Contact>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        tvusername = findViewById(R.id.tv_user_acc);
        btnajout = findViewById(R.id.btn_aj_acc);
        btnaffi = findViewById(R.id.btn_aff_acc);
        btnedit = findViewById(R.id.btn_ed_acc);

        btnaffi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Acceuil.this, Affichage.class);
                startActivity(i);

            }
        });
        btnajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Acceuil.this, Ajout.class);
                startActivity(i);
            }
        });

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Acceuil.this, Edition.class);
                startActivity(i);
            }
        });

    }
}