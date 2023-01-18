package com.example.layout;

import com.example.App;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class changeSceneState implements State {

    Jungle firstscene;

    Stage stage;
    Scene scene1;
    Scene scene2;

    public changeSceneState(Jungle firstscene,Stage stage,Scene scene1,Scene scene2){
        this.firstscene = firstscene;
        this.stage = stage;
        this.scene1 = scene1;
        this.scene2 = scene2;
    }

    @Override
    public void changeScene() {

        Button button1 = new Button("PLAY GAME");
        Button button2 = new Button("SOUND OFF");
        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(button1,button2);
        vBox.setAlignment(Pos.CENTER);

        // Layout 1
        StackPane layout1 = new StackPane();
        scene1 = new Scene(layout1, 700, 620);
        layout1.getChildren().addAll(changeBackground("images/firstJungle.png"), vBox);

        // defines dimensions of vbox so button and label can be centered
        layout1.prefWidthProperty().bind(stage.widthProperty());
        layout1.prefHeightProperty().bind(stage.heightProperty());

        button1.setOnAction(event -> stage.setScene(scene2));
        // firstscene.setState(firstscene.);

        // Layout 2
        BorderPane bPane = new BorderPane();
        StackPaneLayout sp = new StackPaneLayout();
        GridPaneLayout gp = new GridPaneLayout();

        bPane.setTop(sp);
        bPane.setCenter(gp);

        scene2 = new Scene(bPane, 700, 620);

        stage.setScene(scene1);
        stage.setTitle("Scramblo");
        stage.show();
        
    }

    public Node changeBackground(String imageFile) {
        ImageView iv = new ImageView();
        Image image = new Image(App.class.getResource(imageFile).toExternalForm());
        iv.setImage(image);
        iv.setFitHeight(stage.getHeight());
        iv.setFitHeight(stage.getWidth());
        iv.setPreserveRatio(true);
        return iv;
    }
    
}
