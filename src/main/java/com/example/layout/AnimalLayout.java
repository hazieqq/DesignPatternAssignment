package com.example.layout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import com.example.App;
import com.example.Log.LoggerTestFactory;

import javafx.scene.image.*;
import javafx.scene.layout.*;

public class AnimalLayout extends StackPane implements Subscriber {

    // private Hashtable<AnimalConstant,ImageView> animalImage;
    private HashMap<String,animalLayerAdapter> animalImage;
    private HashMap<String, String[]> animalScore;
    public int score;
    
    public AnimalLayout() {
        score = 0;
        jungleBackground();
        animalImage(new JungleFactory());
    }


    private void jungleBackground() {
        try{
            LoggerTestFactory.getLogger().log("Initialize jungle background");
            Image image = new Image(App.class.getResource("images/jungleBackground.png").toExternalForm());
            BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            this.setBackground(new Background(bgImage));
        } catch (Exception e) {
            LoggerTestFactory.getLogger().log("Path image jungle not found");
            System.exit(0);
        }
        
    }

    public void animalImage(AnimalFactory animalfactory) {
        try {
            animalImage = new HashMap<>();
            animalScore = new HashMap<>();

    
            animalImage.put(animalfactory.createTiger().animalName,new animalLayerAdapter(animalfactory.createTiger().pathImage,false));
            animalImage.put(animalfactory.createLion().animalName,new animalLayerAdapter(animalfactory.createLion().pathImage,false));
            animalImage.put(animalfactory.createDeer().animalName,new animalLayerAdapter(animalfactory.createDeer().pathImage,false));
            animalImage.put(animalfactory.createDoll().animalName,new animalLayerAdapter(animalfactory.createDoll().pathImage,false));
            animalImage.put(animalfactory.createGorilla().animalName,new animalLayerAdapter(animalfactory.createGorilla().pathImage,false));
            animalImage.put(animalfactory.createLight().animalName,new animalLayerAdapter(animalfactory.createLight().pathImage,false));
            animalImage.put(animalfactory.createMonitor().animalName,new animalLayerAdapter(animalfactory.createMonitor().pathImage,false));
            animalImage.put(animalfactory.createParrot().animalName,new animalLayerAdapter(animalfactory.createParrot().pathImage,false));
            animalImage.put(animalfactory.createRafflesia().animalName,new animalLayerAdapter(animalfactory.createRafflesia().pathImage,false));
            animalImage.put(animalfactory.createTrash().animalName,new animalLayerAdapter(animalfactory.createTrash().pathImage,false));
            animalImage.put(animalfactory.createWhale().animalName,new animalLayerAdapter(animalfactory.createWhale().pathImage,false));


            animalScore.put(animalfactory.createTiger().animalName,new String[]{animalfactory.createTiger().environment,animalfactory.createTiger().score});
            animalScore.put(animalfactory.createLion().animalName,new String[]{animalfactory.createLion().environment,animalfactory.createLion().score});
            animalScore.put(animalfactory.createDeer().animalName,new String[]{animalfactory.createDeer().environment,animalfactory.createDeer().score});
            animalScore.put(animalfactory.createDoll().animalName,new String[]{animalfactory.createDoll().environment,animalfactory.createDoll().score});
            animalScore.put(animalfactory.createGorilla().animalName,new String[]{animalfactory.createGorilla().environment,animalfactory.createGorilla().score});
            animalScore.put(animalfactory.createLight().animalName,new String[]{animalfactory.createLight().environment,animalfactory.createLight().score});
            animalScore.put(animalfactory.createMonitor().animalName,new String[]{animalfactory.createMonitor().environment,animalfactory.createMonitor().score});
            animalScore.put(animalfactory.createParrot().animalName,new String[]{animalfactory.createParrot().environment,animalfactory.createParrot().score});
            animalScore.put(animalfactory.createRafflesia().animalName,new String[]{animalfactory.createRafflesia().environment,animalfactory.createRafflesia().score});
            animalScore.put(animalfactory.createTrash().animalName,new String[]{animalfactory.createTrash().environment,animalfactory.createTrash().score});
            animalScore.put(animalfactory.createWhale().animalName,new String[]{animalfactory.createWhale().environment,animalfactory.createWhale().score});
            // animalScore.put(animalfactory.createTiger().animalName,animalfactory.createTiger().score);
            // animalScore.put(animalfactory.createDeer().animalName,animalfactory.createDeer().score);
            // animalScore.put(animalfactory.createDoll().animalName,animalfactory.createDoll().score);
            // animalScore.put(animalfactory.createGorilla().animalName,animalfactory.createGorilla().score);
            // animalScore.put(animalfactory.createLight().animalName,animalfactory.createLight().score);
            // animalScore.put(animalfactory.createMonitor().animalName,animalfactory.createMonitor().score);
            // animalScore.put(animalfactory.createParrot().animalName,animalfactory.createParrot().score);
            // animalScore.put(animalfactory.createRafflesia().animalName,animalfactory.createRafflesia().score);
            // animalScore.put(animalfactory.createTrash().animalName,animalfactory.createTrash().score);
            // animalScore.put(animalfactory.createWhale().animalName,animalfactory.createWhale().score);
    
            this.getChildren().addAll(animalImage.values());

        } catch (Exception e) {
            LoggerTestFactory.getLogger().log("Path animal image not found sini");
            System.exit(0);
        }
       
    }


    @Override
    public void updateVisible(ArrayList<String> animalVisible) {
        for (String animal : animalImage.keySet()) {
            if (animalVisible.contains(animal)) {
                if (!animalImage.get(animal).isVisible()) {
                    score += Integer.parseInt(animalScore.get(animal)[1]);
                }
                System.out.println(animal);
                animalImage.get(animal).setVisible(true);
            } else {
                if (score != 0 && animalImage.get(animal).isVisible()) {
                    score -= Integer.parseInt(animalScore.get(animal)[1]);
                } 
                animalImage.get(animal).setVisible(false);
            }
            
        }
    }

    public HashMap<String,animalLayerAdapter> getAnimalImage(){
        return animalImage;
    }

    public int getScore(){
        return score;
    }


    @Override
    public void updateScore() {
        // TODO Auto-generated method stub
        
    }

    
}

