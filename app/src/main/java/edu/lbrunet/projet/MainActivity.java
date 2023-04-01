package edu.lbrunet.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClickableActivity {
    private PelucheAdapter adapter;
    private ArrayList<Peluches.Peluche> peluchesSelected = new ArrayList<>();

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

        Button valider = findViewById(R.id.buttonValider);

        valider.setOnClickListener(view -> {
            if (peluchesSelected.size() == 0) {
                Context context = getApplicationContext();
                CharSequence text = "Il faut sélectionner au moins une peluche";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            else {
                Intent intent = new Intent(MainActivity.this,CommandeActivity.class);
                System.out.println(peluchesSelected);
                intent.putExtra("list",peluchesSelected);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClickNom(Peluches.Peluche item) {
        System.out.println("T'as cliqué");
        ListView listView = findViewById(R.id.listStichs);
        listView.setAdapter(adapter);

        if (item.isSelect()) {
            peluchesSelected.remove(item);
            item.setSelect(false);
        } else {
            peluchesSelected.add(item);
            item.setSelect(true);
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        super.onPause();
        stopService(new Intent(MainActivity.this, BackgroundMusicService.class));
    }

    @Override
    public void onResume() {
        super.onResume();
        startService(new Intent(MainActivity.this, BackgroundMusicService.class));
    }
    
    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
