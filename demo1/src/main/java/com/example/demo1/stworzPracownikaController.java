package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class stworzPracownikaController implements Initializable {

    private Button returnButton;

    @FXML
    public void stworzPracownika(Button cafeteriaButton)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dodaj-pracownika.fxml"));
            Stage stage = (Stage) cafeteriaButton.getScene().getWindow();
            stage.setTitle("Dodawanie studenta");
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
}
