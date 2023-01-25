package com.example.demo1;

import Obseratorzy.Obserwator;
import Obseratorzy.Powiadomienie;
import Obserwowani.Kalendarz;
import Obserwowani.TablicaOgloszen;
import Serializacja.SerializacjaObiektow;
import Uzytkownicy.Administrator;
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
//        SerializacjaObiektow.zapisProwadzacych(new ArrayList<>(), "PlikPracownikow.ser");
//        SerializacjaObiektow.zapisSamorzad(new ArrayList<>(), "PlikSamorzadu.ser");
//        ArrayList<Administrator> admin = new ArrayList<>();
//        admin.add(new Administrator("admin", "admin","admin","admin","admin","admin"));
//        SerializacjaObiektow.zapisAdminow(admin, "PlikAdminow.ser");
        launch();
    }
}