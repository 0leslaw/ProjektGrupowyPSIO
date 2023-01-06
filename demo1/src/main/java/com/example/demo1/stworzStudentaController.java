package com.example.demo1;

import Dane.Dane;
import PakietProjektowy.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class stworzStudentaController implements Initializable {

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
    private TextField semestr;

    @FXML
    private TextField numer_indeksu;

    @FXML
    private TextField kierunek;

    @FXML
    private Button dodajStudentaButton;

    @FXML
    public void stworzStudenta(Button studentButton)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dodaj-studenta.fxml"));
            Stage stage = (Stage) studentButton.getScene().getWindow();
            stage.setTitle("Dodawanie studenta");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Nie można załadować dodawania studentow");
        }
    }

    // trzeba dodac kursy w osobnym stag'u/fxmlu oraz zapisac je do pliku
    public void dodajStudentaButtonOnAction(){ // chyba ze przydzielamy studentowi jakos losowo kursy z pliku
        Student student = new Student(imie.getText(), drugie_imie.getText(), nazwisko.getText(), email.getText(), login.getText(), haslo.getText(), Integer.parseInt(semestr.getText()), numer_indeksu.getText(), kierunek.getText(), 0);
        // dodawanie kursow
        // serializacja studenta
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
}
