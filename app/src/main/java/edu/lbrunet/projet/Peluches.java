package edu.lbrunet.projet;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Random;

public class Peluches extends ArrayList<Peluches.Peluche> {
    public Peluches(Context context) {
        for (int i = 1; i < 4; i++) {
            this.add(new Peluche("Stitchela", new Random().nextInt(40) + 40, context.getResources().getIdentifier("stitchela", "drawable", context.getPackageName())));
        }
    }

    public class Peluche implements Parcelable {
        private String name;
        private float price;
        private int image;
        private boolean select;

        public Peluche(String name, float price, int image) {
            this.name = name;
            this.price = price;
            this.image = image;
        }

        public Peluche(Parcel in) {
            this.name = in.readString();
            this.price = in.readFloat();
            this.image = in.readInt();
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

        @Override
        public int describeContents() {
            return 0;
        }


        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeFloat(price);
            dest.writeInt(image);
        }

        public final Parcelable.Creator<Peluche> CREATOR = new Parcelable.Creator<Peluche>() {
            @Override
            public Peluche createFromParcel(Parcel source) {
                return new Peluche(source);
            }

            @Override
            public Peluche[] newArray(int size) {
                return new Peluche[size];
            }
        };
    }
}