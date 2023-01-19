package com.example.layout;

import java.util.Hashtable;

import com.example.App;
import com.example.Log.LoggerTestFactory;

import javafx.scene.image.*;
import javafx.scene.layout.*;

public class AnimalLayout extends StackPane {

    // private Hashtable<AnimalConstant,ImageView> animalImage;
    private Hashtable<String,ImageView> animalImage;
    
    
    public AnimalLayout() {
        jungleBackground();
        animalImage(new JungleFactory());
    }


    private void jungleBackground() {
        try{
            LoggerTestFactory.getLogger().log("Initialize jungle background");
            Image image = new Image(App.class.getResource("images/jungle2.png").toExternalForm());
            BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            this.setBackground(new Background(bgImage));
        } catch (Exception e) {
            LoggerTestFactory.getLogger().log("Path image jungle not found");
            System.exit(0);
        }
        
    }

    // private void animalImage() {
    //     LoggerTestFactory.getLogger().log("Initialize animal image");

    //     ImageView tiger = new ImageView(new Image(App.class.getResource("images/tiger.png").toExternalForm()));
    //     ImageView lion = new ImageView(new Image(App.class.getResource("images/lion.png").toExternalForm()));
    //     ImageView monkey = new ImageView(new Image(App.class.getResource("images/monkey.png").toExternalForm()));
    //     ImageView bird = new ImageView(new Image(App.class.getResource("images/bird.png").toExternalForm()));
    //     ImageView giraffe = new ImageView(new Image(App.class.getResource("images/giraffe.png").toExternalForm()));
    //     ImageView panda = new ImageView(new Image(App.class.getResource("images/panda.png").toExternalForm()));

    //     tiger.setVisible(false);
    //     lion.setVisible(false);
    //     monkey.setVisible(false);
    //     bird.setVisible(false);
    //     giraffe.setVisible(false);
    //     panda.setVisible(false);
        
    //     animalImage = new Hashtable<>();

    //     animalImage.put(AnimalConstant.tiger,tiger);
    //     animalImage.put(AnimalConstant.lion,lion);
    //     animalImage.put(AnimalConstant.monkey,monkey);
    //     animalImage.put(AnimalConstant.bird,bird);
    //     animalImage.put(AnimalConstant.giraffe,giraffe);
    //     animalImage.put(AnimalConstant.panda,panda);
       
    //     this.getChildren().addAll(animalImage.values());
    // }

    public void animalImage(AnimalFactory animalfactory) {
        try {
            ImageView tiger = new ImageView(new Image(animalfactory.createTiger().pathImage));
            ImageView lion = new ImageView(new Image(animalfactory.createLion().pathImage));
    
            tiger.setVisible(true);
            lion.setVisible(true);
    
            animalImage = new Hashtable<>();
    
            animalImage.put(animalfactory.createTiger().animalName,tiger);
            animalImage.put(animalfactory.createLion().animalName,lion);
    
            this.getChildren().addAll(animalImage.values());

        } catch (Exception e) {
            LoggerTestFactory.getLogger().log("Path animal image not found");
            System.exit(0);
        }
       
    }
}

