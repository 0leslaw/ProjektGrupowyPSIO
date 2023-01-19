package com.example.demo1;

import Serializacja.SerializacjaObiektow;
import Uzytkownicy.Administrator;
import Uzytkownicy.Samorzad;
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

public class stworzAdminaController implements Initializable {
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
    private Button dodajAdminaButton;
    @FXML
    private Label uwaga;

    @FXML
    public void stworzAdmina(Button samorzadButton)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dodaj-admina.fxml"));
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


    public void dodajAdminaButtonOnAction() throws IOException, ClassNotFoundException {
        uwaga.setVisible(false);
        if(!imie.getText().isEmpty() && !nazwisko.getText().isEmpty() && !email.getText().isEmpty() && !login.getText().isEmpty() && !haslo.getText().isEmpty()) {
            Administrator admin = new Administrator(imie.getText(), drugie_imie.getText(), nazwisko.getText(), email.getText(), login.getText(), haslo.getText());
            ArrayList<Administrator> lista_adminow = SerializacjaObiektow.odczytAdminow();
            lista_adminow.add(admin);
            SerializacjaObiektow.zapisAdminow(lista_adminow, "PlikAdminow.ser");
            imie.clear();
            nazwisko.clear();
            drugie_imie.clear();
            email.clear();
            login.clear();
            haslo.clear();
            uwaga.setText("Poprawnie dodano Admina");
            uwaga.setVisible(true);
        }else{
            uwaga.setText("Brak wszystkich danych");
            uwaga.setVisible(true);
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
