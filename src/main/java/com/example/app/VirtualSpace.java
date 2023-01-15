package com.example.app;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.App;
import com.example.Log.Logger;
import com.example.Log.LoggerFactory;
import com.example.Log.LoggerTestFactory;
import com.example.layout.GridPaneLayout;
import com.example.layout.StackPaneLayout;


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

    public void start()  {     
        logger.log("---------------Game Start-----------------------");

        // Screen screen = Screen.getPrimary();
        // Rectangle2D screenBounds =  screen.getBounds();
        // stage.setWidth(screenBounds.getWidth());
        // stage.setHeight(screenBounds.getHeight());


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
