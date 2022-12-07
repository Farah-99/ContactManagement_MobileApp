package com.example.project1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class MonAdapterContact extends BaseAdapter{


    ArrayList<Contact> data;
    Context conn;

    public MonAdapterContact(Context conn, ArrayList<Contact> data) {
        this.data = data;
        this.conn = conn;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CardView card = null;

        //creation d'un view
        LayoutInflater inf = LayoutInflater.from(conn);
        card = (CardView) inf.inflate(R.layout.element, null);

        //recupeartion des champs

        TextView tv_nom_prenom = card.findViewById(R.id.tv_nom_prenom_el);
        TextView tv_num = card.findViewById(R.id.tv_num_el);
        TextView tv_mail = card.findViewById(R.id.tv_mail_el);

        // affecter les valeurs des champs
        //Produit p = data.get(position);
        Contact c = data.get(i);
        tv_nom_prenom.setText(""+c.getPrenom()+ " "+ c.getNom());
        tv_num.setText(""+c.getNumero());
        tv_mail.setText(""+c.getEmail());


        if (c.getNumero() != null)
        {
            tv_num.setTextColor(Color.rgb(255, 173,188));
        }
        return card;
    }

}
