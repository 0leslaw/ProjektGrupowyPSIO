package com.example.demo1;

import Obseratorzy.Obserwator;
import Obseratorzy.Powiadomienie;
import Obserwowani.TablicaOgloszen;
import Serializacja.SerializacjaObiektow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;


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

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        TablicaOgloszen tab = new TablicaOgloszen(new ArrayList<>());
//        Powiadomienie ob = new Powiadomienie(tab);
//        SerializacjaObiektow.zapisTablicyOgloszen(tab, "TablicaOgloszen.ser");
//        SerializacjaObiektow.zapisStudentow(new ArrayList<>(), "PlikStudentow");
//        SerializacjaObiektow.zapisProwadzacych(new ArrayList<>(), "PlikPracownikow.ser");
//        SerializacjaObiektow.zapisSamorzad(new ArrayList<>(), "PlikSamorzadu.ser");
        launch();
    }
}