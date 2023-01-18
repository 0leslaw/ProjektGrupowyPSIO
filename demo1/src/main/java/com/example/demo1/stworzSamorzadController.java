package com.example.demo1;

import Serializacja.SerializacjaObiektow;
import Uzytkownicy.Samorzad;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class stworzSamorzadController implements Initializable {

    @FXML
    private Button returnButton;

    @FXML
    private TextField imie;

    @FXML
    private TextField drugie_imie;

    @FXML
    private TextField nazwisko;

    @FXML
    private TextField email;

    @FXML
    private TextField login;

    @FXML
    private TextField haslo;

    @FXML
    private Button dodajSamorzadButton;

    @FXML
    public void stworzSamorzad(Button samorzadButton)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dodaj-samorzad.fxml"));
            Stage stage = (Stage) samorzadButton.getScene().getWindow();
            stage.setTitle("Dodawanie studenta");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Nie można załadować dodawania studentow");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void dodajSamorzadButtonOnAction() throws IOException, ClassNotFoundException {
        if(imie.getText() != "" && nazwisko.getText() != "" && email.getText() != "" && login.getText() != "" &&haslo.getText() != "") {
            Samorzad samorzad = new Samorzad(imie.getText(), drugie_imie.getText(), nazwisko.getText(), email.getText(), login.getText(), haslo.getText());
            ArrayList<Samorzad> lista_samorzad = SerializacjaObiektow.odczytSamorzad();
            lista_samorzad.add(samorzad);
            SerializacjaObiektow.zapisSamorzad(lista_samorzad, "PlikSamorzadu.ser");
            imie.clear();
            nazwisko.clear();
            drugie_imie.clear();
            email.clear();
            login.clear();
            haslo.clear();
        }

    }

    @FXML
    public void returnToMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("main-panel-admin.fxml"));
            Stage stage = (Stage) returnButton.getScene().getWindow();

            stage.setTitle("Menu");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie moża załadować panelu głównego");
        }
    }
}
