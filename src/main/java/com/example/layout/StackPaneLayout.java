package com.example.layout;

import java.util.Hashtable;

import com.example.App;
import com.example.Log.LoggerTestFactory;
import com.example.animalConstant.*;

import javafx.scene.image.*;
import javafx.scene.layout.*;

public class StackPaneLayout extends StackPane {

    // dont allow any null in hashtable !!
    // Image view from java fx 
    private Hashtable<Animal,ImageView> imgview;
    
    
    public StackPaneLayout(){
        jungleBackground();
        animalImage();
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

    private void animalImage() {
        LoggerTestFactory.getLogger().log("Initialize animal image");

        ImageView tiger = new ImageView(new Image(App.class.getResource("images/tiger.png").toExternalForm()));
        ImageView lion = new ImageView(new Image(App.class.getResource("images/lion.png").toExternalForm()));
        ImageView monkey = new ImageView(new Image(App.class.getResource("images/monkey.png").toExternalForm()));
        ImageView bird = new ImageView(new Image(App.class.getResource("images/bird.png").toExternalForm()));
        ImageView giraffe = new ImageView(new Image(App.class.getResource("images/giraffe.png").toExternalForm()));
        ImageView panda = new ImageView(new Image(App.class.getResource("images/panda.png").toExternalForm()));

        tiger.setVisible(false);
        lion.setVisible(false);
        monkey.setVisible(false);
        bird.setVisible(false);
        giraffe.setVisible(false);
        panda.setVisible(false);
        
        imgview = new Hashtable<>();

        imgview.put(Animal.tiger,tiger);
        imgview.put(Animal.lion,lion);
        imgview.put(Animal.monkey,monkey);
        imgview.put(Animal.bird,bird);
        imgview.put(Animal.giraffe,giraffe);
        imgview.put(Animal.panda,panda);
       
        this.getChildren().addAll(imgview.values());
    }
}

