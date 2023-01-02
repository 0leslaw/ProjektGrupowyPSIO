package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    public void loginButtonAction() {
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
}