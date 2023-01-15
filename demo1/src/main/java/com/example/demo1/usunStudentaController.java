package com.example.demo1;

import Uzytkownicy.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Dane.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class usunStudentaController {

    @FXML
    private Button returnButton;
    @FXML
    private Button usuwanieStudenta;
    @FXML
    private TextField usunietyIndeks;
    @FXML
    private Label uwaga;

    public void usunStudenta(Button usuwanie)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("usun_studenta.fxml"));
            Stage stage = (Stage) usuwanie.getScene().getWindow();
            stage.setTitle("Dodawanie studenta");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Nie można załadować usuwania studentów");
        }
    }

    public void returnButtonAction(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("main-panel-admin.fxml"));
            Stage stage = (Stage) returnButton.getScene().getWindow();

            stage.setTitle("Login Choice");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie moża załadować panelu głównego");
        }
    }

    public void usunStudenta() throws IOException, ClassNotFoundException{
        uwaga.setVisible(false);
        ArrayList<Student> listaStudentow = Dane.odczytStudentow();
        int dlugosc = listaStudentow.size();
        for(int i = 0; i<listaStudentow.size(); i++){
            if(listaStudentow.get(i).getNr_indeksu().equals(usunietyIndeks.getText())){
                listaStudentow.remove(i);
                uwaga.setText("Pomyślnie usunięto studenta");
                uwaga.setVisible(true);
                usunietyIndeks.clear();
            }
        }
        if(listaStudentow.size() == dlugosc){
            uwaga.setText("Podano błedny indeks");
            uwaga.setVisible(true);
        }
        Dane.zapisStudentow(listaStudentow);
    }
}
