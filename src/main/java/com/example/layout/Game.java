package com.example.layout;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game {
    State changeSceneState;

    State state;

    Stage stage;
    Scene scene1;
    Scene scene2;

    public Game(Stage stage,Scene scene1,Scene scene2){
        changeSceneState = new changeSceneState(this,stage,scene1,scene2);
        state = changeSceneState;
    }

    public void changeScene(){
        state.changeScene();
    }

    public void setState(State state){
        this.state = state;
    }
}
