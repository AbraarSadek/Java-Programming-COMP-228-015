package com.example.abraar_final;

//Import
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    //Start Method
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 700);
        stage.setTitle("Abraar Sadek - XXXXXXXXX - Java Programming - COMP 228 - 015 - Final Exam!");
        stage.setScene(scene);
        stage.show();
    } //End of Start Method

    //Main Method
    public static void main(String[] args) {
        launch(); //Call Method
    } //End of Main Method
}