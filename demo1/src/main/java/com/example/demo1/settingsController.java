package com.example.demo1;

import Dane.*;
import Serializacja.SerializacjaObiektow;
import Uzytkownicy.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class settingsController implements Initializable {

    @FXML
    private Button potwierdz;
    @FXML
    private TextField filtrTF;
    @FXML
    private CheckBox filtrCB;
    @FXML
    private Button returnButton;

    @FXML
    public void Settings(Button cafeteriaButton)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("student-settings.fxml"));
            Stage stage = (Stage) cafeteriaButton.getScene().getWindow();
            stage.setTitle("Ustawienia");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Nie można załadować panelu ustawień");
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
        filtrTF.setText(studenci.get(PrzekazywanieStudenta.getIndeksStudentaLista()).getSzukane());
        if(!studenci.get(PrzekazywanieStudenta.getIndeksStudentaLista()).isPowiadomienia()){
            filtrCB.setSelected(false);
        }else{
            filtrCB.setSelected(true);
        }
    }

    @FXML
    public void returnToMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("main-panel-student.fxml"));
            Stage stage = (Stage) returnButton.getScene().getWindow();

            stage.setTitle("Menu");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie moża załadować panelu głównego");
        }
    }

    @FXML
    public void potwierdzAction() throws IOException, ClassNotFoundException {
        ArrayList<Student> studenci = SerializacjaObiektow.odczytStudentow();
        studenci.get(PrzekazywanieStudenta.getIndeksStudentaLista()).setSzukane(filtrTF.getText());
        if(filtrCB.isSelected()){
            studenci.get(PrzekazywanieStudenta.getIndeksStudentaLista()).setPowiadomienia(true);
        }else{
            studenci.get(PrzekazywanieStudenta.getIndeksStudentaLista()).setPowiadomienia(false);
        }
        SerializacjaObiektow.zapisStudentow(studenci, "PlikStudentow.ser");
    }
}
