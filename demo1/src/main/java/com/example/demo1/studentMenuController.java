package com.example.demo1;

import Dane.*;
import Menu.Menu;
import Serializacja.SerializacjaObiektow;
import Uzytkownicy.Student;
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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class studentMenuController implements Initializable{

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
    private Label wydarzeniaNowe;
    @FXML
    private Label ogloszeniaNowe;


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Student> studenci = null;
        try {
            studenci = SerializacjaObiektow.odczytStudentow();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(studenci != null){
            if(studenci.get(PrzekazywanieStudenta.getIndeksStudentaLista()).isPowiadomienia()){
                ogloszeniaNowe.setText("Nowe ogłoszenia: " + studenci.get(PrzekazywanieStudenta.getIndeksStudentaLista()).getLiczba_nowych_ogloszen());
                ogloszeniaNowe.setVisible(true);
                wydarzeniaNowe.setText("Nowe wydarzenia: " + studenci.get(PrzekazywanieStudenta.getIndeksStudentaLista()).getLiczba_nowych_wydarzen());
                wydarzeniaNowe.setVisible(true);
            }
        }
    }
}
