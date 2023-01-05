package com.example.demo1;

import Dane.Dane;
import PakietProjektowy.Uzytkownik;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class adminLoginController {

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginTF;

    @FXML
    private PasswordField passwordTF;
    public void loginButtonAction() {
                try {
                    Parent root1 = FXMLLoader.load(getClass().getResource("main-panel-admin.fxml"));
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    stage.setTitle("Main Panel");
                    stage.setScene(new Scene(root1));
                    stage.show();

                } catch(Exception e) {
                    System.out.println("Nie można załadować panelu głównego");
                }
            }
}
