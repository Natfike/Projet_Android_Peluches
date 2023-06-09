package edu.lbrunet.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CommandeActivity extends AppCompatActivity {
    private CommandeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);

        Intent intent = getIntent();
        ArrayList<Peluches.Peluche> peluchesintent = intent.getParcelableArrayListExtra("list");

        //Creation et initialisation de l'Adapter pour les personnes
        adapter = new CommandeAdapter(this, peluchesintent);

        //Recuperation du composant ListView
        ListView display = findViewById(R.id.listStichsPanier);

        //Initialisation de la liste avec les donnees
        display.setAdapter(adapter);


    }
}
