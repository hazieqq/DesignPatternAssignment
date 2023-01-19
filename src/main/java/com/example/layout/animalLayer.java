package com.example.layout;

import com.example.App;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class animalLayer extends ImageView {
    
    public animalLayer(String pathToImage, boolean visibility) {
        super(new Image(App.class.getResource(pathToImage).toExternalForm()));
        this.setVisible(visibility);
    }

    public animalLayer(String pathToImage) {
        super(new Image(App.class.getResource(pathToImage).toExternalForm()));
    }
}
