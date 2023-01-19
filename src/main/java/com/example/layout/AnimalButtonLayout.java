package com.example.layout;

import java.util.*;

import com.example.App;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

public class AnimalButtonLayout extends GridPane {

    private HashMap<String, Button> animalbuttons;
    private HashMap<String, animalLayer> animalButtonsImage;
    // Button undobutton;
    // private Button soundBtn;
    
    public AnimalButtonLayout() {
        menuBackground();
        button(new JungleFactory());
    }

    private void button(AnimalFactory animalfactory) {
        Button tiger = new Button();
        Button lion = new Button();

        tiger.setMaxWidth(100);
        lion.setMaxWidth(100);

        animalButtonsImage = new HashMap<>();
        animalbuttons = new HashMap<>();

        animalButtonsImage.put(animalfactory.createTiger().animalName, new animalLayer(animalfactory.createTiger().pathImageButton));
        animalButtonsImage.put(animalfactory.createLion().animalName, new animalLayer(animalfactory.createLion().pathImageButton));
        animalbuttons.put(animalfactory.createTiger().animalName, tiger);
        animalbuttons.put(animalfactory.createLion().animalName, lion);


        for (String animal : animalbuttons.keySet()) {
            Button btn = animalbuttons.get(animal);
            ImageView imageView = animalButtonsImage.get(animal);
            imageView.setFitHeight(100);
            imageView.setPreserveRatio(true);
            btn.setGraphic(imageView);
            btn.setContentDisplay(ContentDisplay.TOP);
            btn.setText(animal);
            // decoBtn.setOnAction(e -> executeCommand(new
            // ToggleDecoVisibility(decoration)));
        }

        this.addRow(0, animalbuttons.get(animalfactory.createLion().animalName),animalbuttons.get(animalfactory.createTiger().animalName));

    }

    private void menuBackground() {
        ColumnConstraints c = new ColumnConstraints();
        c.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().addAll(c, c, c, c);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.setVgap(10);
        this.setHgap(10);

        Image image = new Image(App.class.getResource("images/menu_bg1.png").toExternalForm());
        BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(bgImage));
    }

    // private void button() {
    //     undobutton = new Button("Undo");

    //     Button tiger = new Button();
    //     Button lion = new Button();
    //     Button monkey = new Button();
    //     Button bird = new Button();
    //     Button giraffe = new Button();
    //     Button panda = new Button();

    //     tiger.setMaxWidth(100);
    //     lion.setMaxWidth(100);
    //     monkey.setMaxWidth(100);
    //     bird.setMaxWidth(100);
    //     giraffe.setMaxWidth(100);
    //     panda.setMaxWidth(100);

    //     // undoBtn.setOnAction(e -> undoCommand());
    //     // soundBtn = new MenuButton("Pause Music");
    //     // soundBtn.setOnAction(e -> executeCommand(new ToggleSound()));

    //     animalButtonsImage = new HashMap<>();
    //     animalButtonsImage.put(AnimalConstant.tiger, new animalLayer("images/tigerButton.png"));
    //     animalButtonsImage.put(AnimalConstant.lion, new animalLayer("images/tigerButton.png"));
    //     animalButtonsImage.put(AnimalConstant.monkey, new animalLayer("images/tigerButton.png"));
    //     animalButtonsImage.put(AnimalConstant.bird, new animalLayer("images/tigerButton.png"));
    //     animalButtonsImage.put(AnimalConstant.giraffe, new animalLayer("images/tigerButton.png"));
    //     animalButtonsImage.put(AnimalConstant.panda, new animalLayer("images/tigerButton.png"));

    //     animalbuttons = new HashMap<>();
    //     animalbuttons.put(AnimalConstant.tiger, tiger);
    //     animalbuttons.put(AnimalConstant.lion, lion);
    //     animalbuttons.put(AnimalConstant.monkey, monkey);
    //     animalbuttons.put(AnimalConstant.bird, bird);
    //     animalbuttons.put(AnimalConstant.giraffe, giraffe);
    //     animalbuttons.put(AnimalConstant.panda, panda);

    //     for (AnimalConstant animal : animalbuttons.keySet()) {
    //         Button btn = animalbuttons.get(animal);
    //         ImageView imageView = animalButtonsImage.get(animal);
    //         imageView.setFitHeight(100);
    //         imageView.setPreserveRatio(true);
    //         btn.setGraphic(imageView);
    //         btn.setContentDisplay(ContentDisplay.TOP);
    //         btn.setText(animal.name());
    //         // decoBtn.setOnAction(e -> executeCommand(new
    //         // ToggleDecoVisibility(decoration)));
    //     }

    //     this.addRow(0, animalbuttons.get(AnimalConstant.tiger), animalbuttons.get(AnimalConstant.lion), animalbuttons.get(AnimalConstant.monkey));
    //     this.addRow(1, animalbuttons.get(AnimalConstant.bird), animalbuttons.get(AnimalConstant.giraffe), animalbuttons.get(AnimalConstant.panda));
    //     this.addRow(2, undobutton);
    // }

    
}