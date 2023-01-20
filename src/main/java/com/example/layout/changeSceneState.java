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
    Button play;
    Button soundoff;

    public changeSceneState(Jungle firstscene,Stage stage,Scene scene1,Scene scene2){
        this.firstscene = firstscene;
        this.stage = stage;
        this.scene1 = scene1;
        this.scene2 = scene2;
    }

    @Override
    public void changeScene() {

        play = new Button("PLay Game Jungle");
        // soundoff = new Button("PLay Game Jungle");
        soundoff = new Button("SOUND OFF");
        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(play,soundoff);
        vBox.setAlignment(Pos.CENTER);

        // Layout 1
        StackPane layout1 = new StackPane();
        scene1 = new Scene(layout1, 700, 620);
        layout1.getChildren().addAll(changeBackground("images/firstJungle.png"), vBox);

        // defines dimensions of vbox so button and label can be centered
        layout1.prefWidthProperty().bind(stage.widthProperty());
        layout1.prefHeightProperty().bind(stage.heightProperty());

        play.setOnAction(event -> stage.setScene(scene2));

        // Layout 2
        BorderPane bPane2 = new BorderPane();

        Functions function = Functions.getInstance();
        
        AnimalLayout sp = new AnimalLayout();
        

        AnimalButtonLayout gp = new AnimalButtonLayout();
        function.registerSubscriber(sp);
        function.registerSubscriber(gp);

        bPane2.setTop(sp);
        bPane2.setCenter(gp);


        //layout 3
        scene2 = new Scene(bPane2, 700, 800);

        stage.setScene(scene1);
        stage.setTitle("Scramblo");
        stage.setResizable(false);
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
