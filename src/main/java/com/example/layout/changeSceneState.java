package com.example.layout;

import java.util.ArrayList;


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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class changeSceneState implements State, Subscriber {

    Game firstscene;

    Stage stage;
    Scene scene1, scene2, scene3;
    Button play, playAgain, soundoff, home;
    AnimalLayout sp;
    AnimalButtonLayout gp;
    Functions function;
    private MediaPlayer mediaPlayer;
    MediaPlayer previousPlayer;

    public changeSceneState(Game firstscene, Stage stage, Scene scene1, Scene scene2, MediaPlayer mediaPlayer) {
        this.firstscene = firstscene;
        this.stage = stage;
        this.scene1 = scene1;
        this.scene2 = scene2;
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void changeScene() {

        Button jungleGame = new Button("Jungle");
        Button amazonGame = new Button("Sea");
        Button back = new Button("Back");
        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(jungleGame, amazonGame, back);
        vBox.setAlignment(Pos.CENTER);

        // Layout 1
        StackPane layout1 = new StackPane();
        scene2 = new Scene(layout1, 700, 620);
        scene2.getStylesheets().add(App.class.getResource("style/button.css").toExternalForm());
        layout1.getChildren().addAll(changeBackground("images/EnvironmentSelectionPage.png"), vBox);

        // defines dimensions of vbox so button and label can be centered
        layout1.prefWidthProperty().bind(stage.widthProperty());
        layout1.prefHeightProperty().bind(stage.heightProperty());

        jungleGame.setOnAction(e -> scene3());
        amazonGame.setOnAction(e -> scene4());
        back.setOnAction(e -> stage.setScene(scene1));

        stage.setScene(scene2);

    }

    public void scene3() {
        BorderPane bPane2 = new BorderPane();

        function = Functions.getInstance();

        sp = new AnimalLayout("scene3");

        gp = new AnimalButtonLayout("scene3");

        function.registerSubscriber(sp);
        function.registerSubscriber(gp);
        function.registerSubscriber(this);

        bPane2.setTop(sp);
        bPane2.setCenter(gp);

        scene3 = new Scene(bPane2, 700, 750);
        stage.setScene(scene3);
    }

    public void scene4() {
        BorderPane bPane2 = new BorderPane();

        function = Functions.getInstance();

        sp = new AnimalLayout("scene4");

        gp = new AnimalButtonLayout("scene4");

        function.registerSubscriber(sp);
        function.registerSubscriber(gp);
        function.registerSubscriber(this);

        bPane2.setTop(sp);
        bPane2.setCenter(gp);

        scene3 = new Scene(bPane2, 700, 750);
        stage.setScene(scene3);
    }

    @Override
    public void updateVisible(ArrayList<String> animalVisible) {
    }

    @Override
    public void updateScore() {

        playAgain = new Button("Play Again");

        Text t = new Text();
        t.setFont(Font.font("Comic Sans MS", 30));
        t.setLayoutX(100);
        t.setLayoutY(100);
        // home = new Button("Home");
        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(t, playAgain);
        vBox.setAlignment(Pos.CENTER);

        // Layout 3
        StackPane layout3 = new StackPane();
        scene3 = new Scene(layout3, 700, 620);
        scene3.getStylesheets().add(App.class.getResource("style/button.css").toExternalForm());

        int total;
        if (sp.getAnimalVisible() == null) {
            total = 0;
        } else {
            total = sp.getAnimalVisible().size();
        }

        System.out.println("Score : " + sp.getScore());
        if (sp.getScore() == 50) {
            previousPlayer = mediaPlayer;
            // add won music
            mediaPlayer = new MediaPlayer(new Media(App.class.getResource("music/won.mp3").toExternalForm()));
            mediaPlayer.setVolume(1);
            mediaPlayer.play();
            t.setText("\n\n\nSelected Images: "+total+" \nCorrect: " + totalCorrect() +  "\nIncorrect: "
                    + totalIncorrect());
            layout3.getChildren().addAll(changeBackground("images/WinnerPage.png"), vBox);
        } else {
            previousPlayer = mediaPlayer;
            // add lose music
            mediaPlayer = new MediaPlayer(new Media(App.class.getResource("music/lose.mp3").toExternalForm()));
            mediaPlayer.setVolume(1);
            mediaPlayer.play();

            t.setText("\n\n\nSelected Images: "+total+" \nCorrect: " + totalCorrect() +  "\nIncorrect: "
                    + totalIncorrect());
            // t.setText("Total Incorrect: " + sp.getScore());
            layout3.getChildren().addAll(changeBackground("images/LoserPage.png"), vBox);
        }

        // defines dimensions of vbox so button and label can be centered
        layout3.prefWidthProperty().bind(stage.widthProperty());
        layout3.prefHeightProperty().bind(stage.heightProperty());

        function.reset();

        playAgain.setOnAction(event -> changeScene());

        // home.setOnAction(event -> stage.setScene(scene1));

        // Creating a scene object

        // Setting title to the Stage
        stage.setTitle("Sample Application");

        // Adding scene to the stage
        stage.setScene(scene3);

        // Displaying the contents of the stage
        // stage.show();

    }

    public Node changeBackground(String imageFile) {
        ImageView iv = new ImageView();
        Image image = new Image(App.class.getResource(imageFile).toExternalForm());
        iv.setImage(image);
        // iv.setFitHeight(stage.getHeight());
        // iv.setFitHeight(stage.getWidth());
        // iv.setPreserveRatio(true);
        return iv;
    }

    public int totalCorrect() {
        int counter = 0;
        if (sp.getAnimalVisible() == null){
            return counter;
        }

        ArrayList<String> selectedAnswer = sp.getAnimalVisible();
        ArrayList<String> compareAnswer = new ArrayList<String>(sp.getAnimalImage());
        

        for (String s : selectedAnswer) {
            if (compareAnswer.contains(s)) {
                counter++;
            }
        }

        return counter;
    }

    public int totalIncorrect() {
        int counter = 0;
        if (sp.getAnimalVisible() == null){
            return counter;
        }

        ArrayList<String> selectedAnswer = sp.getAnimalVisible();
        ArrayList<String> compareAnswer = new ArrayList<String>(sp.getAnimalImageAnomalies());

        for (String s : selectedAnswer) {
            if (compareAnswer.contains(s)) {
                counter++;
            }
        }

        return counter;
    }


}
