package com.example.demo1;

import Uzytkownicy.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class adminMenuController {

    @FXML
    private Button dodajStudenta;
    @FXML
    private Button dodajPracownika;
    @FXML
    private Button dodajSamorzad;
    @FXML
    private Button returnButton;

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

    public void toDodajStudenta(){
        stworzStudentaController controller = new stworzStudentaController();
        controller.stworzStudenta(dodajStudenta);
    }

    public void toDodajPracownika(){
        stworzPracownikaController controller = new stworzPracownikaController();
        controller.stworzPracownika(dodajPracownika);
    }

    public void toDodajSamorzad(){
        stworzSamorzadController controller = new stworzSamorzadController();
        controller.stworzSamorzad(dodajSamorzad);
    }
}
