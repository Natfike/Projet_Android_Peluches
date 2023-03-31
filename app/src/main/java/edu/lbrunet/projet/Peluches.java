package edu.lbrunet.projet;

import java.util.ArrayList;

public class Peluches extends ArrayList<Peluche> {
    private static Peluches instance = null;

    public static Peluches getInstance() {
        if (instance == null) {
            instance = new Peluches();
        }
        return instance;
    }

    private Peluches() {
    }
}

class Peluche {
    private String name;
    private float price;
    private int image;

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
}