package com.example;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.Log.LoggerTestFactory;
import com.example.app.VirtualSpace;

/**
 * JavaFX App
 */
public class App extends Application {

    VirtualSpace vs;
    LoggerTestFactory loggerTestFactory;

    @Override
    public void start(Stage stage) throws IOException {
        // facade design pattern
        vs = new VirtualSpace(stage);
        vs.start();

    }

    public static void main(String[] args) {
        launch();
    }

}