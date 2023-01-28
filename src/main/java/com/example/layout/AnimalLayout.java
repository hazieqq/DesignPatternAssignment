package com.example.layout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;

import com.example.App;
import com.example.Log.LoggerTestFactory;

import javafx.scene.image.*;
import javafx.scene.layout.*;

public class AnimalLayout extends StackPane implements Subscriber {

    // private Hashtable<AnimalConstant,ImageView> animalImage;
    private HashMap<String, animalLayerAdapter> animalImage;
    private HashMap<String, animalLayerAdapter> anomaliesAnimalImage;
    private HashMap<String, Integer> animalScore;
    public int score;
    public ArrayList<String> visibility;

    public AnimalLayout(String scene) {
        if (scene == "scene3") {
            score = 0;
            jungleBackground();
            animalImage(new JungleFactory());
        } else {
            score = 0;
            seaBackground();
            animalImage(new SeaFactory());
        }
    }

    private void jungleBackground() {
        try {
            LoggerTestFactory.getLogger().log("Initialize jungle background");
            Image image = new Image(App.class.getResource("images/jungleBackground.png").toExternalForm());
            BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            this.setBackground(new Background(bgImage));
        } catch (Exception e) {
            LoggerTestFactory.getLogger().log("Path image jungle not found");
            System.exit(0);
        }

    }

    private void seaBackground() {
        try {
            LoggerTestFactory.getLogger().log("Initialize sea background");
            Image image = new Image(App.class.getResource("images/SeaBackground.png").toExternalForm());
            BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            this.setBackground(new Background(bgImage));
        } catch (Exception e) {
            LoggerTestFactory.getLogger().log("Path image sea not found");
            System.exit(0);
        }

    }

    public void animalImage(AnimalFactory animalfactory) {

        animalImage = new HashMap<>();
        animalScore = new HashMap<>();
        anomaliesAnimalImage = new HashMap<>();

        for (int i = 0; i < animalfactory.createAnimals().length; i++) {
            animalImage.put(animalfactory.createAnimals()[i].animalName,
                    new animalLayerAdapter(animalfactory.createAnimals()[i].pathImage, false));
            animalScore.put(animalfactory.createAnimals()[i].animalName, animalfactory.createAnimals()[i].score);
        }

        for (int i = 0; i < animalfactory.createAnomalies().length; i++) {
            anomaliesAnimalImage.put(animalfactory.createAnomalies()[i].animalName,
                    new animalLayerAdapter(animalfactory.createAnomalies()[i].pathImage, false));
            animalScore.put(animalfactory.createAnomalies()[i].animalName, animalfactory.createAnomalies()[i].score);
        }

        this.getChildren().addAll(animalImage.values());
        this.getChildren().addAll(anomaliesAnimalImage.values());

    }

    @Override
    public void updateVisible(ArrayList<String> animalVisible) {
        visibility = new ArrayList<>();
        visibility = animalVisible;
        for (String animal : animalImage.keySet()) {
            if (animalVisible.contains(animal)) {
                if (!animalImage.get(animal).isVisible()) {
                    score += animalScore.get(animal);
                }
                animalImage.get(animal).setVisible(true);
            } else {
                if (score != 0 && animalImage.get(animal).isVisible()) {
                    score -= animalScore.get(animal);
                }
                animalImage.get(animal).setVisible(false);
            }

        }

        for (String animal : anomaliesAnimalImage.keySet()) {
            if (animalVisible.contains(animal)) {
                if (!anomaliesAnimalImage.get(animal).isVisible()) {
                    score -= animalScore.get(animal);
                }
                anomaliesAnimalImage.get(animal).setVisible(true);
            } else {
                if (score != 0 && anomaliesAnimalImage.get(animal).isVisible()) {
                    score += animalScore.get(animal);
                }
                anomaliesAnimalImage.get(animal).setVisible(false);
            }

        }
    }

    public ArrayList<String> getAnimalVisible() {
        return visibility;
    }

    public Set<String> getAnimalImage() {
        return animalImage.keySet();
    }

    public Set<String> getAnimalImageAnomalies() {
        return anomaliesAnimalImage.keySet();
    }

    public int getScore() {
        return score;
    }

    @Override
    public void updateScore() {

    }

    public void reset() {

    }

}
