package com.example.app;


import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.geometry.Pos;

import java.io.IOException;

import com.example.App;
import com.example.Log.Logger;
import com.example.Log.LoggerFactory;
import com.example.Log.LoggerTestFactory;
import com.example.layout.Jungle;
import com.example.layout.GridPaneLayout;
import com.example.layout.MainSceneController;
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

    public void start() throws IOException  {     
        logger.log("---------------Game Start-----------------------");

        // State design pattern 
        Jungle jungle = new Jungle(stage,scene1,scene2);
        jungle.changeScene();

        
        // Parent root = FXMLLoader.load(App.class.getResource("javafxenv.fxml"));

        // Scene scene = new Scene(root);
        
        // stage.setTitle("Jungle");
        // stage.setScene(scene);
        // stage.show();
        
    }

    

    
}
