package edu.lbrunet.projet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CommandeAdapter extends BaseAdapter {
    private ArrayList<Peluches.Peluche> items;
    private LayoutInflater mInflater;
    private Activity activity;

    public CommandeAdapter(Activity activity, ArrayList<Peluches.Peluche> items) {
        this.activity = activity;
        this.items = items;
        mInflater = LayoutInflater.from(activity.getApplicationContext());
    }

    public int getCount() {
        return items.size();
    }

    public Object getItem(int position) {
        return items.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    public View getView(int position, View convertView, ViewGroup parent) {
        View layoutItem;

        //(1) : Réutilisation des layouts
        layoutItem = convertView == null ? mInflater.inflate(R.layout.activity_commande_peluche, parent, false) : convertView;

        //(2) : Récupération des TextView de notre layout
        TextView displayNom = layoutItem.findViewById(R.id.pelucheNameCommande);
        TextView displayPrice = layoutItem.findViewById(R.id.peluchePriceCommande);
        ImageView img = layoutItem.findViewById(R.id.imagePelucheCommande);

        //(3) : Renseignement des valeurs
        displayNom.setText(items.get(position).getName());
        displayPrice.setText(items.get(position).getPrice() + "");

        //(4) Changement de la couleur du fond de notre item
        img.setBackgroundResource(items.get(position).getImage());

        displayNom.setTag(position);
        return layoutItem; //On retourne l'item créé.
    }
}
