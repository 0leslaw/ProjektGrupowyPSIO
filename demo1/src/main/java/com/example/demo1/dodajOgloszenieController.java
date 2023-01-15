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

public class dodajOgloszenieController implements Initializable {

    @FXML
    public void ogloszenieController(Button ogloszenieButton){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dodaj-ogloszenie.fxml"));
            Stage stage = (Stage) ogloszenieButton.getScene().getWindow();
            stage.setTitle("Dodaj ogloszenia");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Nie można załadować panelu ogloszen");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
