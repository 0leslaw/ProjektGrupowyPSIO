package com.example.demo1;

import Uzytkownicy.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import Dane.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class stworzStudentaController implements Initializable {

    @FXML
    private Button returnButton;

    @FXML
    private TextField imie;

    @FXML
    private TextField drugie_imie;

    @FXML
    private TextField nazwisko;

    @FXML
    private TextField email;

    @FXML
    private TextField login;

    @FXML
    private TextField haslo;

    @FXML
    private TextField semestr;

    @FXML
    private TextField numer_indeksu;

    @FXML
    private TextField kierunek;

    @FXML
    private Button dodajStudentaButton;

    @FXML
    private Label uwaga;

    @FXML
    public void stworzStudenta(Button studentButton)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("dodaj-studenta.fxml"));
            Stage stage = (Stage) studentButton.getScene().getWindow();
            stage.setTitle("Dodawanie studenta");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Nie można załadować dodawania studentow");
        }
    }

    // trzeba dodac kursy w osobnym stag'u/fxmlu oraz zapisac je do pliku
    public void dodajStudentaButtonOnAction() throws IOException, ClassNotFoundException{ // chyba ze przydzielamy studentowi jakos losowo kursy z pliku
        if(imie.getText().length() != 0 && nazwisko.getText().length() != 0 && email.getText().length() != 0 && login.getText().length() != 0 && haslo.getText().length() != 0 && semestr.getText().length() != 0 && numer_indeksu.getText().length() != 0 && kierunek.getText().length() != 0) {
            ArrayList<Student> listaStudentow = Dane.odczytStudentow();
            Student student = new Student(imie.getText(), drugie_imie.getText(), nazwisko.getText(), email.getText(), login.getText(), haslo.getText(), Integer.parseInt(semestr.getText()), numer_indeksu.getText(), kierunek.getText());
            listaStudentow.add(student);
            Dane.zapisStudentow(listaStudentow);
            imie.setText("");
            drugie_imie.setText("");
            nazwisko.setText("");
            email.setText("");
            login.setText("");
            haslo.setText("");
            semestr.setText("");
            numer_indeksu.setText("");
            kierunek.setText("");
            uwaga.setText("Pomyślnie dodano studenta");
            uwaga.setAlignment(Pos.CENTER);
            uwaga.setTextAlignment(TextAlignment.CENTER);
            uwaga.setVisible(true);
        }else{
            uwaga.setText("Należy podać wszystkie dane");
            uwaga.setAlignment(Pos.CENTER);
            uwaga.setTextAlignment(TextAlignment.CENTER);
            uwaga.setVisible(true);
        }
        // dodawanie kursow

        // serializacja studenta
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void returnToMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("main-panel-admin.fxml"));
            Stage stage = (Stage) returnButton.getScene().getWindow();

            stage.setTitle("Menu");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie moża załadować panelu głównego");
        }
    }
}
