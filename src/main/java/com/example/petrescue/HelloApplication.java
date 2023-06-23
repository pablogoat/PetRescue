package com.example.petrescue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.petrescue.scene.*;
import com.example.petrescue.service.*;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        // Ustawienie sceny i wyświetlenie okna
        /*stage.setScene(SceneConfig.setScene());
        stage.show();*/
    }

    public static void main(String[] args) {
        launch();
    }
}