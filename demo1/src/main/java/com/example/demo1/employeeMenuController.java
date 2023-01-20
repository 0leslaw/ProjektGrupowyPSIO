package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class employeeMenuController {
    @FXML
    private Button returnButton;
    @FXML
    private Button ogloszenieButton;
    @FXML
    private Button wydarzenieButton;

    public void ogloszenieButtonAction(){
        dodajOgloszenieController controller = new dodajOgloszenieController();
        controller.ogloszenieController(ogloszenieButton);
    }
    public void wydarzenieButtonAction(){
        dodajWydarzenieController controller = new dodajWydarzenieController();
        controller.wydarzenieController(wydarzenieButton);
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
//            System.out.println("Nie moża załadować panelu głównego");
        }
    }
}
