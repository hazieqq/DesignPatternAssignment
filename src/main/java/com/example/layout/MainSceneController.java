package com.example.layout;

import java.util.HashMap;

import com.example.App;
import com.example.Log.LoggerTestFactory;
import com.example.animal.Animal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;


public class MainSceneController {
   
    @FXML
    private Button tiger,ziraffe,lion,elephant,bear,rhino;

    @FXML
    private ImageView ziraffeLayer;

    private HashMap<Animal, ImageView> animallayers;


    @FXML
    void setAction(ActionEvent event) {
    }

    @FXML
    void setActionZiraffe(ActionEvent event) {

    }

    @FXML
    void showAnimal(MouseEvent event) {
        animalImage();
    }


    void animalImage() {
        System.out.print(ziraffeLayer.isVisible());
        ziraffeLayer.setVisible(false);
    }

}
