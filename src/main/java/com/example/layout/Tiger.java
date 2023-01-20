package com.example.layout;

import com.example.App;

public class Tiger extends Entity {
    
    public Tiger(){
        this.animalName = "Tiger";
        this.pathImage = App.class.getResource("images/tiger.png").toExternalForm();
        this.pathImageButton = "images/tigerButton.png";
    }

    @Override
    String score() {
        // TODO Auto-generated method stub
        return "10";
    }
}
