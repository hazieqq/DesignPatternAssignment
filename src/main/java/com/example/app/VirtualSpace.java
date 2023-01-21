package com.example.app;


import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.App;
import com.example.Log.Logger;
import com.example.Log.LoggerFactory;
import com.example.Log.LoggerTestFactory;
import com.example.layout.Jungle;


public class VirtualSpace  {

    private static Scene scene1,scene2;
    private Stage stage;
    private LoggerTestFactory loggerTestFactory;
    public Logger logger;

    public VirtualSpace(Stage stage) throws IOException {
        // simple factory design pattern for logging
        loggerTestFactory = new LoggerTestFactory(new LoggerFactory());
        logger = LoggerTestFactory.getLogger();
        this.stage = stage;
    }

    public void start() throws IOException  {     
        logger.log("---------------Game Start-----------------------");


        Button play = new Button("PLay Game");
        Button soundoff = new Button("SOUND OFF");
        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(play,soundoff);
        vBox.setAlignment(Pos.CENTER);

        // Layout 1
        StackPane layout1 = new StackPane();
        scene1 = new Scene(layout1, 1200, 800);
        scene1.getStylesheets().add(App.class.getResource("style/button.css").toExternalForm());
        layout1.getChildren().addAll(changeBackground("images/WelcomePage1.png"), vBox);

        // defines dimensions of vbox so button and label can be centered
        layout1.prefWidthProperty().bind(stage.widthProperty());
        layout1.prefHeightProperty().bind(stage.heightProperty());

        // State design pattern 
        Jungle jungle = new Jungle(stage,scene1,scene2);
        


        play.setOnAction(e->jungle.changeScene());

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
