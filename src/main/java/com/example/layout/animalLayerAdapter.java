package com.example.layout;

import com.example.App;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class animalLayerAdapter extends ImageView {

    public animalLayerAdapter(String pathToImage, boolean visible) {
        super(new Image(App.class.getResource(pathToImage).toExternalForm()));
        this.setVisible(visible);
    }

    public animalLayerAdapter(String pathToImage) {
        super(new Image(App.class.getResource(pathToImage).toExternalForm()));
    }
}
