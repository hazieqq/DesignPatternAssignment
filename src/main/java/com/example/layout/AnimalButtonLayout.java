package com.example.layout;

import java.util.*;

import com.example.App;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

public class AnimalButtonLayout extends GridPane implements Subscriber {

    private HashMap<String, buttonLayerAdapter> animalbuttons;
    private HashMap<String, buttonLayerAdapter> anomaliesAnimalbuttons;
    private HashMap<String, animalLayerAdapter> animalButtonsImage;
    private HashMap<String, animalLayerAdapter> anomaliesAnimalButtonImage;
    public AnimalLayout animallayout;
    // Button undobutton;
    // private Button soundBtn;
    
    public AnimalButtonLayout(String scene) {
        if (scene == "scene3") {
            menuBackground();
            button(new JungleFactory());
        } else {
            menuBackground();
            button(new AmazonFactory());
        }
        
    }

    private void button(AnimalFactory animalfactory) {


        Button checkAnswer = new Button("Check Answer");
        checkAnswer.setOnAction(e -> executeScore());

        animalButtonsImage = new HashMap<>();
        anomaliesAnimalButtonImage = new HashMap<>();
        animalbuttons = new HashMap<>();
        anomaliesAnimalbuttons = new HashMap<>();

        for (int i = 0; i < animalfactory.createAnimals().length; i++) {
            animalButtonsImage.put(animalfactory.createAnimals()[i].animalName,new animalLayerAdapter(animalfactory.createAnimals()[i].pathImageButton));
            animalbuttons.put(animalfactory.createAnimals()[i].animalName,new buttonLayerAdapter());
            // System.out.println(animalfactory.createAnimals()[i].animalName);
        }

        for (int i = 0; i < animalfactory.createAnomalies().length; i++) {
            anomaliesAnimalButtonImage.put(animalfactory.createAnomalies()[i].animalName,new animalLayerAdapter(animalfactory.createAnomalies()[i].pathImageButton));
            anomaliesAnimalbuttons.put(animalfactory.createAnomalies()[i].animalName,new buttonLayerAdapter());
        }


        for (String animal : animalbuttons.keySet()) {
            Button btn = animalbuttons.get(animal);
            ImageView imageView = animalButtonsImage.get(animal);
            imageView.setFitHeight(100);
            imageView.setPreserveRatio(true);
            btn.setGraphic(imageView);
            btn.setContentDisplay(ContentDisplay.TOP);
            animalbuttons.get(animal).setText(animal);
            animalbuttons.get(animal).setOnAction(e -> execute(animal));
        }

        for (String animal : anomaliesAnimalbuttons.keySet()) {
            Button btn = anomaliesAnimalbuttons.get(animal);
            ImageView imageView = anomaliesAnimalButtonImage.get(animal);
            imageView.setFitHeight(100);
            imageView.setPreserveRatio(true);
            btn.setGraphic(imageView);
            btn.setContentDisplay(ContentDisplay.TOP);
            anomaliesAnimalbuttons.get(animal).setText(animal);
            anomaliesAnimalbuttons.get(animal).setOnAction(e -> execute(animal));
        }


        for (int i = 0; i < animalfactory.createAnimals().length; i++) {
            this.addRow(0,animalbuttons.get(animalfactory.createAnimals()[i].animalName));
        }

        for (int i = 0; i < animalfactory.createAnomalies().length; i++) {
            this.addRow(0,anomaliesAnimalbuttons.get(animalfactory.createAnomalies()[i].animalName));
        }

        this.addRow(0,checkAnswer);

    }

    private void executeScore() {
        Functions.getInstance().updateScore();
    }

    private void execute(String animal) {
        Functions.getInstance().switchVisibility(animal);
    }


    private void menuBackground() {
        ColumnConstraints c = new ColumnConstraints();
        c.setHgrow(Priority.ALWAYS);
        // this.getColumnConstraints().addAll(c, c, c, c);
        this.setPadding(new Insets(5,10,5,10));
        // this.setAlignment(Pos.BASELINE_CENTER);
        this.setVgap(10);
        this.setHgap(10);

        // Image image = new Image(App.class.getResource("images/menu_bg1.png").toExternalForm());
        // BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
        // BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        // this.setBackground(new Background(bgImage));
    }

    @Override
    public void updateVisible(ArrayList<String> animalVisible) {

        for (String animal : animalbuttons.keySet()) {
            String text = "";
            if (animalVisible.contains(animal)) {
                text = "Remove " + animal;
            } else {
                text = "Add " + animal;
            }
            animalbuttons.get(animal).setText(text);
        }

        for (String animal : anomaliesAnimalbuttons.keySet()) {
            String text = "";
            if (animalVisible.contains(animal)) {
                text = "Remove " + animal;
            } else {
                text = "Add " + animal;
            }
            anomaliesAnimalbuttons.get(animal).setText(text);
        }
        
    }


    public HashMap<String, buttonLayerAdapter> getanimalbuttons(){
        return animalbuttons;
    }

    @Override
    public void updateScore() {
    }

    
}
