package edu.lbrunet.projet;

import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

public class Peluches extends ArrayList<Peluche> {
    public Peluches(Context context) {
        for (int i = 1; i < 4 ; i++) {
            this.add(new Peluche("Stitchela", new Random().nextInt(40) + 40,context.getResources().getIdentifier("stitchela","drawable", context.getPackageName())));
        }
    }
}

class Peluche {
    private String name;
    private float price;
    private int image;
    private boolean select;

    public Peluche(String name, float price, int image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}