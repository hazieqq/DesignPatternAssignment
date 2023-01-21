package com.example.layout;

import java.util.*;

import com.example.App;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

public class AnimalButtonLayout extends GridPane implements Subscriber {

    private HashMap<String, buttonLayerAdapter> animalbuttons;
    private HashMap<String, animalLayerAdapter> animalButtonsImage;
    public AnimalLayout animallayout;
    // Button undobutton;
    // private Button soundBtn;
    
    public AnimalButtonLayout() {
        menuBackground();
        button(new JungleFactory());
    }

    private void button(AnimalFactory animalfactory) {


        Button checkAnswer = new Button("Check Answer");
        checkAnswer.setOnAction(e -> executeScore());

        animalButtonsImage = new HashMap<>();
        animalbuttons = new HashMap<>();


        animalButtonsImage.put(animalfactory.createTiger().animalName, new animalLayerAdapter(animalfactory.createTiger().pathImageButton));
        animalButtonsImage.put(animalfactory.createLion().animalName, new animalLayerAdapter(animalfactory.createLion().pathImageButton));
        animalButtonsImage.put(animalfactory.createDeer().animalName, new animalLayerAdapter(animalfactory.createLion().pathImageButton));
        animalButtonsImage.put(animalfactory.createDoll().animalName, new animalLayerAdapter(animalfactory.createLion().pathImageButton));
        animalButtonsImage.put(animalfactory.createGorilla().animalName, new animalLayerAdapter(animalfactory.createLion().pathImageButton));
        animalButtonsImage.put(animalfactory.createLight().animalName, new animalLayerAdapter(animalfactory.createLion().pathImageButton));
        animalButtonsImage.put(animalfactory.createMonitor().animalName, new animalLayerAdapter(animalfactory.createLion().pathImageButton));
        animalButtonsImage.put(animalfactory.createParrot().animalName, new animalLayerAdapter(animalfactory.createLion().pathImageButton));
        animalButtonsImage.put(animalfactory.createRafflesia().animalName, new animalLayerAdapter(animalfactory.createLion().pathImageButton));
        animalButtonsImage.put(animalfactory.createTrash().animalName, new animalLayerAdapter(animalfactory.createLion().pathImageButton));
        animalButtonsImage.put(animalfactory.createWhale().animalName, new animalLayerAdapter(animalfactory.createLion().pathImageButton));

        animalbuttons.put(animalfactory.createTiger().animalName, new buttonLayerAdapter());
        animalbuttons.put(animalfactory.createLion().animalName, new buttonLayerAdapter());
        animalbuttons.put(animalfactory.createDeer().animalName, new buttonLayerAdapter());
        animalbuttons.put(animalfactory.createDoll().animalName, new buttonLayerAdapter());
        animalbuttons.put(animalfactory.createGorilla().animalName, new buttonLayerAdapter());
        animalbuttons.put(animalfactory.createLight().animalName, new buttonLayerAdapter());
        animalbuttons.put(animalfactory.createMonitor().animalName, new buttonLayerAdapter());
        animalbuttons.put(animalfactory.createParrot().animalName, new buttonLayerAdapter());
        animalbuttons.put(animalfactory.createRafflesia().animalName, new buttonLayerAdapter());
        animalbuttons.put(animalfactory.createTrash().animalName, new buttonLayerAdapter());
        animalbuttons.put(animalfactory.createWhale().animalName, new buttonLayerAdapter());



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

        this.addRow(0, animalbuttons.get(animalfactory.createLion().animalName),animalbuttons.get(animalfactory.createTiger().animalName),animalbuttons.get(animalfactory.createDeer().animalName),
        animalbuttons.get(animalfactory.createDoll().animalName),animalbuttons.get(animalfactory.createGorilla().animalName),animalbuttons.get(animalfactory.createLight().animalName),
        animalbuttons.get(animalfactory.createMonitor().animalName));
        this.addRow(1, animalbuttons.get(animalfactory.createParrot().animalName),animalbuttons.get(animalfactory.createRafflesia().animalName),animalbuttons.get(animalfactory.createTrash().animalName),
        animalbuttons.get(animalfactory.createWhale().animalName),checkAnswer);

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
        
    }


    public HashMap<String, buttonLayerAdapter> getanimalbuttons(){
        return animalbuttons;
    }

    @Override
    public void updateScore() {
    }

    
}
