package com.example.demo1;

import Dane.Dane;
import Uzytkownicy.Uzytkownik;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class govLoginController {
    @FXML
    private Button loginButton;
    @FXML
    private Button returnButton;

    @FXML
    private TextField loginTF;

    @FXML
    private PasswordField passwordTF;

    @FXML
    private Label label;

    @FXML
    public void returnButtonAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login-choice.fxml"));
            Stage stage = (Stage) returnButton.getScene().getWindow();

            stage.setTitle("Login Choice");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie moża załadować panelu głównego");
        }
    }

    @FXML
    public void loginButtonAction() {

        for(Uzytkownik uzytkownik: Dane.stworz_uzytkownikow()){
            if(loginTF.getText().equals(uzytkownik.getLogin()) && passwordTF.getText().equals(uzytkownik.getHaslo())){
                try {
                    Parent root1 = FXMLLoader.load(getClass().getResource("main-panel-gov.fxml"));
                    Stage stage = (Stage) loginButton.getScene().getWindow();

                    stage.setTitle("Main Panel");
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch(Exception e) {
                    System.out.println("Nie można załadować panelu głównego");
                }
            }
            else label.setVisible(true);

        }
    }
}