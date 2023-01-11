package com.example.demo1;

import Dane.Dane;
import Serializacja.SerializacjaObiektow;
import Uzytkownicy.Student;
import Uzytkownicy.Uzytkownik;
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
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        launch();

    }
}