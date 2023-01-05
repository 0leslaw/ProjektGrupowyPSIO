package com.example.demo1;

import Dane.Dane;
import PakietProjektowy.Uzytkownik;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class studentLoginController {
    @FXML
    private Button loginButton;

    @FXML
    private TextField loginTF;

    @FXML
    private PasswordField passwordTF;

    @FXML
    private Label label;

    @FXML
    public void loginButtonAction() {

        for(Uzytkownik uzytkownik: Dane.stworz_uzytkownikow()){
            if(loginTF.getText().equals(uzytkownik.getLogin()) && passwordTF.getText().equals(uzytkownik.getHaslo())){
                try {
                    Parent root1 = FXMLLoader.load(getClass().getResource("main-panel-student.fxml"));
                    Stage stage = (Stage) loginButton.getScene().getWindow();

                    String login = loginTF.getText();
                    String password = passwordTF.getText();

                    System.out.println(login);
                    System.out.println(password);

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