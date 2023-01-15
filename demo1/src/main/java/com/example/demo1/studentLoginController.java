package com.example.demo1;

import Dane.Dane;
import Uzytkownicy.Student;
import Uzytkownicy.Uzytkownik;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.util.ArrayList;

public class studentLoginController {
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
    public void loginButtonAction() throws IOException, ClassNotFoundException {
        ArrayList<Student> listaStudentow = new ArrayList<Student>();
        listaStudentow.addAll(Dane.odczytStudentow());
        for(Uzytkownik uzytkownik: listaStudentow){
            if(loginTF.getText().equals(uzytkownik.getLogin()) && passwordTF.getText().equals(uzytkownik.getHaslo())){
                try {
                    Parent root1 = FXMLLoader.load(getClass().getResource("main-panel-student.fxml"));
                    Stage stage = (Stage) loginButton.getScene().getWindow();

                    stage.setTitle("Main Panel");
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch(Exception e) {
//                    System.out.println("Nie można załadować panelu głównego");
                }
             }
            else label.setVisible(true);
            }
        }
    @FXML
    public void returnButtonAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login-choice.fxml"));
            Stage stage = (Stage) returnButton.getScene().getWindow();

            stage.setTitle("Login Choice");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie można załadować panelu głównego");
        }
    }
}