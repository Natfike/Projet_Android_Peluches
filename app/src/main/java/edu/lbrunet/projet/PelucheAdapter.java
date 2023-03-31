package edu.lbrunet.projet;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PelucheAdapter extends BaseAdapter {
    private Peluches items;
    private LayoutInflater mInflater;
    private ClickableActivity activity;

    public PelucheAdapter(ClickableActivity activity, Peluches items) {
        this.activity = activity;
        this.items = items;
        mInflater = LayoutInflater.from(activity.getContext());
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
        layoutItem = convertView == null ? mInflater.inflate(R.layout.activity_peluche, parent, false) : convertView;

        //(2) : Récupération des TextView de notre layout
        TextView displayNom = layoutItem.findViewById(R.id.pelucheName);
        TextView displayPrice = layoutItem.findViewById(R.id.peluchePrice);
        ImageView img = layoutItem.findViewById(R.id.imagePeluche);

        //(3) : Renseignement des valeurs
        displayNom.setText(items.get(position).getName());
        displayPrice.setText(items.get(position).getPrice() + "");

        boolean select = items.get(position).isSelect();

        if (select) {
            displayNom.setTextSize(40);
        }
        else {
            displayNom.setTextSize(20);
        }

        //(4) Changement de la couleur du fond de notre item
        img.setBackgroundResource(items.get(position).getImage());

        displayNom.setTag(position);
        layoutItem.setOnClickListener(v -> activity.onClickNom(items.get(position)) );

        return layoutItem; //On retourne l'item créé.
    }
}
