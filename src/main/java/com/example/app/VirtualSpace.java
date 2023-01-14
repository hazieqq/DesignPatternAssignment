package com.example.app;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

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

        BorderPane bPane2 = new BorderPane();
        StackPaneLayout sp = new StackPaneLayout();
        GridPaneLayout gp = new GridPaneLayout();  

        bPane2.setTop(sp);
        bPane2.setCenter(gp);

        scene2 = new Scene(bPane2, 700, 620);

        stage.setTitle("Zoo Taiping");
        stage.setResizable(false);
        stage.setScene(scene2);
        stage.show();


        // Pane bPane1 = new Pane();
        // Pane bPane2 = new Pane();

        // scene1 = new Scene(bPane1, 700, 620);
        // scene2 = new Scene(bPane2, 700, 620);
        // Button button = new Button("Forward");
        // button.setOnAction(e -> stage.setScene(scene2));

        // Button button2 = new Button("Backwards");
        // button2.setOnAction(e -> stage.setScene(scene1));

        // Label label1 = new Label("This is the First Scene");
        // Label label2 = new Label("This is the Second Scene");

        // bPane1.getChildren().addAll(label1,button);
        // bPane2.getChildren().addAll(label2,button2);
         
        // stage.setTitle("CodersLegacy");
        // stage.setScene(scene1);   
        // stage.show();
        
    }

    
}
