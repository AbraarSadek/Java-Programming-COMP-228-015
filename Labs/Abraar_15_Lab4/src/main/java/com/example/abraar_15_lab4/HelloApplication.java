package com.example.abraar_15_lab4;

//Import
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

//Class HelloApplication Extending Application
public class HelloApplication extends Application {

    //Start Method
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 775);
        stage.setTitle("Abraar Sadek - XXXXXXXXX - Java Programming - COMP 228 - 015 - Lab 4!"); //Set Stage Title
        stage.setScene(scene); //Set Scene "scene" To Stage
        stage.show(); //Set Stage To Method "show"

    } //End of Start Method

    //Main Method
    public static void main(String[] args) {
        launch(); //Call Method
    } //End of Main Method

}