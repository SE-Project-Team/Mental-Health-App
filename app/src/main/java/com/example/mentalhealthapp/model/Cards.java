package com.example.mentalhealthapp.model;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Cards { // class for card

    private int imageProfile; // card image
    private String cardtext; // text in the card

    public Cards(int imageProfile, String cardtext) {
        this.imageProfile = imageProfile;
        this.cardtext = cardtext;
    }

    // getters and setters
    public int getImageProfile() {
        return imageProfile;
    }


    public String getCardtext() {
        return cardtext;
    }

}
