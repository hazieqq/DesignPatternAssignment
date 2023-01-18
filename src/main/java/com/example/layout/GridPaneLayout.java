package com.example.layout;

import java.util.*;

import com.example.App;
import com.example.animal.Animal;

import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

public class GridPaneLayout extends GridPane {

    private HashMap<Animal, Button> animalbuttons;
    Button undoBtn;
    // private Button soundBtn;
    
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
        BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(bgImage));
    }

    private void button() {
        // undoBtn = new Button("Undo");

        // BorderPane border = new BorderPane();
        // border.setPadding(new Insets(20, 20, 20, 20));

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

        // VBox vbuttons = new VBox();
        // vbuttons.setSpacing(5);
        // vbuttons.setPadding(new Insets(10, 10, 10, 10));
        // vbuttons.getChildren().addAll(tiger, lion, monkey, bird, giraffe, panda);

        // undoBtn.setOnAction(e -> undoCommand());
        // soundBtn = new MenuButton("Pause Music");
        // soundBtn.setOnAction(e -> executeCommand(new ToggleSound()));

        animalbuttons = new HashMap<>();
        animalbuttons.put(Animal.tiger, tiger);
        animalbuttons.put(Animal.lion, lion);
        animalbuttons.put(Animal.monkey, monkey);
        animalbuttons.put(Animal.bird, bird);
        animalbuttons.put(Animal.giraffe, giraffe);
        animalbuttons.put(Animal.panda, panda);
        for (Animal animal : animalbuttons.keySet()) {
            Button decoBtn = animalbuttons.get(animal);
            decoBtn.setText(animal.name());
            // decoBtn.setOnAction(e -> executeCommand(new
            // ToggleDecoVisibility(decoration)));
        }

        this.addRow(0, animalbuttons.get(Animal.tiger), animalbuttons.get(Animal.lion), animalbuttons.get(Animal.monkey));
        this.addRow(1, animalbuttons.get(Animal.bird), animalbuttons.get(Animal.giraffe), animalbuttons.get(Animal.panda));
    }
}
