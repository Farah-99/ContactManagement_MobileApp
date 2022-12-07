package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // declaration des composantes
    Button btn_quitter, btn_valider;
    EditText ed_email, ed_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recuperation des composantes
        btn_quitter = findViewById(R.id.btn_quit_auth);
        btn_valider = findViewById(R.id.btn_val_auth);
        ed_email = findViewById(R.id.ed_mail_auth);
        ed_pass = findViewById(R.id.ed_pass_auth);

        // gestion des evenement
        // ecouteur
        btn_quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // recuperer les chaines
                String email = ed_email.getText().toString();
                String pass = ed_pass.getText().toString();

                if (email.equalsIgnoreCase("quer") && pass.equals("000")) {

                    //passage vers acceuil
                    Intent i = new Intent(MainActivity.this, Acceuil.class);
                    startActivity(i);

                }
                else {
                    Toast.makeText(MainActivity.this, "Echec!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}