package edu.lbrunet.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ClickableActivity {
    private PelucheAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Peluches pokemons = new Peluches(getContext());

        //Creation et initialisation de l'Adapter pour les personnes
        adapter = new PelucheAdapter(MainActivity.this, pokemons);

        //Recuperation du composant ListView
        ListView display = findViewById(R.id.listStichs);

        //Initialisation de la liste avec les donnees
        display.setAdapter(adapter);
    }

    @Override
    public void onClickNom(Peluche item) {
        System.out.println("T'as cliqué");
        ListView listView = findViewById(R.id.listStichs);
        listView.setAdapter(adapter);

        if (item.isSelect()) {
            item.setSelect(false);
        } else {
            item.setSelect(true);
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}