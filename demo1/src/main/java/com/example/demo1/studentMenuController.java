package com.example.demo1;

import Dane.Dane;
import Menu.Menu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import Menu.*;

import java.net.URL;
import java.util.ResourceBundle;


public class studentMenuController{

    @FXML
    private Button announcementButton;

    @FXML
    private Button cafeteriaButton;

    @FXML
    private Button calendarButton;

    @FXML
    private Button mapButton;
    @FXML
    private Button returnButton;



    @FXML
    public void toAnnouncement() {
        announcementController controller = new announcementController();
        controller.Announcement(announcementButton);
    }

    @FXML
    public void toCalendar() {
        calendarController controller = new calendarController();
        controller.Calendar(calendarButton);
    }

    @FXML
    public void toCafeteria() {
        cafeteriaController controller = new cafeteriaController();
        controller.Cafeteria(cafeteriaButton);
    }

    @FXML
    public void toMap() {
        mapController controller = new mapController();
        controller.Map(mapButton);
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
            System.out.println("Nie moża załadować panelu głównego");
        }
    }
}
