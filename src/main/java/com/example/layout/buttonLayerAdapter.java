package com.example.layout;

import javafx.scene.control.Button;

public class buttonLayerAdapter extends Button {
    
    public buttonLayerAdapter() {
        super();
        this.setMaxWidth(100);
    }

    public buttonLayerAdapter(String buttonText) {
        super(buttonText);
        this.setMaxWidth(100);
    }
}
