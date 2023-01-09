package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-choice.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("Login Choice");
        stage.setScene(scene);
        stage.show();
    }

    //można wykorzystać strategie do wyszukiwania ocen po prowadzących lub kursach
    //dodać przycisk wyloguj cofania przy logowaniu
    //dodać przycisk wyloguj w main panelu
    
    public static void main(String[] args) {
        launch();
    }
}