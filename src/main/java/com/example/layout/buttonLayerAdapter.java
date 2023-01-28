package com.example.layout;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;

public class buttonLayerAdapter extends Button {
    DropShadow shadow;

    public buttonLayerAdapter() {
        super();
        shadow = new DropShadow();
        this.setEffect(shadow);
        // this.setMaxWidth(100);
        this.setMinSize(150, 50);
        this.setStyle("-fx-background-color: #0099e5; -fx-text-fill: #ffffff; -fx-font-size: 15px;");
    }

    public buttonLayerAdapter(String buttonText) {
        super(buttonText);
        shadow = new DropShadow();
        this.setEffect(shadow);
        this.setMinSize(100, 50);
        this.setStyle("-fx-background-color: #00ad2e; -fx-text-fill: #000000; -fx-font-size: 15px;");
        // this.setMaxSize(300, 500);
    }
}
