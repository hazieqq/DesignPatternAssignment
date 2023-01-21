package com.example.layout;


import java.util.ArrayList;

import com.example.App;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class changeSceneState implements State,Subscriber {

    Jungle firstscene;

    Stage stage;
    Scene scene1,scene2,scene3;
    Button play,playAgain,soundoff,home;
    AnimalLayout sp;
    AnimalButtonLayout gp;

    public changeSceneState(Jungle firstscene,Stage stage,Scene scene1,Scene scene2){
        this.firstscene = firstscene;
        this.stage = stage;
        this.scene1 = scene1;
        this.scene2 = scene2;
    }

    @Override
    public void changeScene() {

        // Layout 2
        BorderPane bPane2 = new BorderPane();

        Functions function = Functions.getInstance();
        
        sp = new AnimalLayout();
        
        gp = new AnimalButtonLayout();

        function.registerSubscriber(sp);
        function.registerSubscriber(gp);
        function.registerSubscriber(this);

        bPane2.setTop(sp);
        bPane2.setCenter(gp);


        scene2 = new Scene(bPane2, 1200, 1000);
        stage.setScene(scene2);
        
        
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

    @Override
    public void updateVisible(ArrayList<String> animalVisible) {
    }

    @Override
    public void updateScore() {

        System.out.println("Score : "+sp.getScore());
        

        playAgain = new Button("Play Again");
        home = new Button("Home");
        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(playAgain,home);
        vBox.setAlignment(Pos.CENTER);

        // Layout 3
        StackPane layout3 = new StackPane();
        scene3 = new Scene(layout3, 1200, 800);  
        layout3.getChildren().addAll(changeBackground("images/WelcomePage1.png"), vBox);

        // defines dimensions of vbox so button and label can be centered
        layout3.prefWidthProperty().bind(stage.widthProperty());
        layout3.prefHeightProperty().bind(stage.heightProperty());

        playAgain.setOnAction(event -> stage.setScene(scene2));

        home.setOnAction(event -> stage.setScene(scene1));

                
        //Creating a scene object 
        
        //Setting title to the Stage 
        stage.setTitle("Sample Application"); 
            
        //Adding scene to the stage 
        stage.setScene(scene3); 
            
        //Displaying the contents of the stage 
        // stage.show(); 
        
    }

    
    
}
