package com.example.layout;

import java.util.Hashtable;

import com.example.App;
import com.example.animalConstant.Animal;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

public class GridPaneLayout extends GridPane {

    private Hashtable<Animal, Button> decoButtons;
    Button undoBtn;
    private Button soundBtn;
    
    public GridPaneLayout() {
        menuBackground();
        button();
    }


    private void menuBackground() {
        ColumnConstraints c = new ColumnConstraints();
        c.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().addAll(c, c, c, c);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.setVgap(10);
        this.setHgap(10);

        Image image = new Image(App.class.getResource("images/menu_bg.png").toExternalForm());
        BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(bgImage));
    }

    private void button() {
        // undoBtn = new Button("Undo");

        Button tiger = new Button();
        Button lion = new Button();
        Button monkey = new Button();
        Button bird = new Button();
        Button giraffe = new Button();
        Button panda = new Button();

        tiger.setMaxWidth(100);
        lion.setMaxWidth(100);
        monkey.setMaxWidth(100);
        bird.setMaxWidth(100);
        giraffe.setMaxWidth(100);
        panda.setMaxWidth(100);

        // undoBtn.setOnAction(e -> undoCommand());
        // soundBtn = new MenuButton("Pause Music");
        // soundBtn.setOnAction(e -> executeCommand(new ToggleSound()));

        decoButtons = new Hashtable<>();
        decoButtons.put(Animal.tiger, tiger);
        decoButtons.put(Animal.lion, new Button());
        decoButtons.put(Animal.monkey, new Button());
        decoButtons.put(Animal.bird, new Button());
        decoButtons.put(Animal.giraffe, new Button());
        decoButtons.put(Animal.panda, new Button());
        for (Animal animal : decoButtons.keySet()) {
            Button decoBtn = decoButtons.get(animal);
            decoBtn.setText(animal.name());
            // decoBtn.setOnAction(e -> executeCommand(new ToggleDecoVisibility(decoration)));
        }

        this.addRow(0, decoButtons.get(Animal.tiger), decoButtons.get(Animal.lion), decoButtons.get(Animal.monkey));
        this.addRow(1, decoButtons.get(Animal.bird), decoButtons.get(Animal.giraffe), decoButtons.get(Animal.panda));
    }
}
