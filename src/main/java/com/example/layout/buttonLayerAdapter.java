package com.example.layout;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;

public class buttonLayerAdapter extends Button {
    DropShadow shadow ;
    
    public buttonLayerAdapter() {
        super();
        shadow = new DropShadow();
        this.setEffect(shadow);
        this.setMaxWidth(100);
    }

    public buttonLayerAdapter(String buttonText) {
        super(buttonText);
        shadow = new DropShadow();
        this.setEffect(shadow);
        this.setMaxWidth(100);
    }
}
