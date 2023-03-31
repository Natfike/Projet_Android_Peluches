package edu.lbrunet.projet;

import android.content.Context;

/**
 * Interface pour écouter les évènements sur le nom d'une personne
 */
public interface ClickableActivity {
    void onClickNom(Peluches.Peluche item);

    Context getContext();
}