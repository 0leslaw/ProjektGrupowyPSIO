package com.example.demo1;

import Obserwowani.Kalendarz;
import PakietWydarzenie.Wydarzenie;
import Serializacja.SerializacjaObiektow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class dodajWydarzenieController implements Initializable {
    @FXML
    private Button returnButton;
    @FXML
    private TextField autor;
    @FXML
    private TextField tytul;
    @FXML
    private TextField tresc;
    @FXML
    private TextField data;
    @FXML
    private Button dodajButton;
    @FXML
    private Label brakDanych;

    @FXML
    public void wydarzenieController(Button wydarzenieButton){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dodaj-wydarzenie.fxml"));
            Stage stage = (Stage) wydarzenieButton.getScene().getWindow();
            stage.setTitle("Dodaj wydarzenia");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Nie można załadować panelu wydarzen");
        }
    }

    @FXML
    public void dodajButtonAction() throws IOException, ClassNotFoundException {
        brakDanych.setVisible(false);
        Kalendarz kalendarz;
        kalendarz = SerializacjaObiektow.odczytKalendarz();
        if(autor.getText() != "" && data.getText() != "" && tytul.getText() != "" && tresc.getText() != ""){
            kalendarz.dodajWydarzenieDoKalendarza(new Wydarzenie(tytul.getText(), LocalDateTime.parse(data.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")), autor.getText(), tresc.getText()));
        }else{
            brakDanych.setVisible(true);
        }
        SerializacjaObiektow.zapisKalendarza(kalendarz, "Kalendarz.ser");
        autor.setText("");
        tresc.setText("");
        data.setText("");
        tytul.setText("");
    }

    @FXML
    public void returnButtonAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("main-panel-gov.fxml"));
            Stage stage = (Stage) returnButton.getScene().getWindow();

            stage.setTitle("Menu");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie moża załadować panelu głównego");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
