package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class studentMenuController {
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
        try {
            Parent root = FXMLLoader.load(getClass().getResource("announcement.fxml"));
            Stage stage = (Stage) announcementButton.getScene().getWindow();

            stage.setTitle("Ogłoszenia");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie można załadować ogłoszeń");
        }
    }

    @FXML
    public void toCalendar() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("calendar.fxml"));
            Stage stage = (Stage) calendarButton.getScene().getWindow();

            stage.setTitle("Kalendarz");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie można załadować kalendarza");
        }
    }

    @FXML
    public void toCafeteria() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("cafeteria.fxml"));
            Stage stage = (Stage) cafeteriaButton.getScene().getWindow();

            stage.setTitle("Stołówka");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie można załadować panelu stołówki");
        }
    }

    @FXML
    public void toMap() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("map.fxml"));
            Stage stage = (Stage) mapButton.getScene().getWindow();

            stage.setTitle("Mapa");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie można załadować map");
        }
    }

    @FXML
    public void returnToMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("main-panel-student.fxml"));
            Stage stage = (Stage) returnButton.getScene().getWindow();

            stage.setTitle("Menu");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie moża załadować panelu głównego");
        }
    }
}
