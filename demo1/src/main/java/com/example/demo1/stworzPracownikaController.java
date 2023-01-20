package com.example.demo1;

import Serializacja.SerializacjaObiektow;
import Uzytkownicy.Pracownik;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class stworzPracownikaController implements Initializable {

    @FXML
    private Button returnButton;
    @FXML
    private Label uwaga;
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
    private TextField wydzial;
    @FXML
    private TextField tytul;
    @FXML
    private TextField katedra;

    @FXML
    public void stworzPracownika(Button pracownikButton)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dodaj-pracownika.fxml"));
            Stage stage = (Stage) pracownikButton.getScene().getWindow();
            stage.setTitle("Dodawanie pracownika");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Nie można załadować dodawania pracownikow");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

    public void dodajPracownika() throws IOException, ClassNotFoundException {
        uwaga.setVisible(false);
        if (imie.getText().length() != 0 && nazwisko.getText().length() != 0 && email.getText().length() != 0 && login.getText().length() != 0 && haslo.getText().length() != 0 && wydzial.getText().length() != 0 && tytul.getText().length() != 0 && katedra.getText().length() != 0) {
            ArrayList<Pracownik> lista_pracownikow = SerializacjaObiektow.odczytProwadzacych();
            lista_pracownikow.add(new Pracownik(imie.getText(), drugie_imie.getText(), nazwisko.getText(), email.getText(), login.getText(), haslo.getText(), wydzial.getText(), tytul.getText(), katedra.getText()));
            SerializacjaObiektow.zapisProwadzacych(lista_pracownikow, "PlikPracownikow.ser");
            uwaga.setText("Poprawnie dodano Pracownika");
            uwaga.setVisible(true);
            imie.clear();
            drugie_imie.clear();
            nazwisko.clear();
            email.clear();
            login.clear();
            haslo.clear();
            wydzial.clear();
            tytul.clear();
            katedra.clear();
        } else{
            uwaga.setText("Brak wszystkich danych");
            uwaga.setVisible(true);
        }
    }
}
