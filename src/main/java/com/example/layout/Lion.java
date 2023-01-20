package com.example.layout;

import com.example.App;

public class Lion extends Entity {

    public Lion() {
        this.animalName = "Lion";
        this.pathImage = App.class.getResource("images/lion.png").toExternalForm();
        this.pathImageButton = "images/lionButton.png";
    }

    @Override
    String score() {
        // TODO Auto-generated method stub
        return "10";
    }
}
