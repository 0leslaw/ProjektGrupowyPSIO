package com.example.demo1;

import Dane.Dane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class cafeteriaController implements Initializable {
    @FXML
    private Label danieDzis;

    @FXML
    private Button returnButton;

    @FXML
    public void Cafeteria(Button cafeteriaButton)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("cafeteria.fxml"));
            Stage stage = (Stage) cafeteriaButton.getScene().getWindow();
            stage.setTitle("Stołówka");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Nie można załadować panelu stołówki");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(Dane.danie() != null) {
            danieDzis.setText(Dane.danie().toString());
        }else{
            danieDzis.setText("stołówka nieczynna");
        }
    }
    @FXML
    public void returnToMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("main-panel-student.fxml"));
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
