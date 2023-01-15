package com.example.demo1;

import Uzytkownicy.Student;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Dane.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.ResourceBundle;

public class usunStudentaController implements Initializable {

    @FXML
    private Button returnButton;
    @FXML
    private Button usuwanieStudenta;
    @FXML
    private TextField usunietyIndeks;
    @FXML
    private Label uwaga;
    @FXML
    private VBox studenciBox;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        int i = 0;
        ArrayList<Student> studenci = null;
        try {
            studenci = Dane.odczytStudentow();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (studenci == null) {
            System.out.println("Nie udało się załadować studentów");
        }else {
            for(Student student: studenci) {
                HBox hBox = new HBox();
                hBox.setPrefSize(35, 598);
                Text imie = new Text(student.getImie());
                HBox.setMargin(imie, new Insets(8, 0, 0, 10));
                imie.setWrappingWidth(113.21630859375);
                Text nazwisko = new Text(student.getNazwisko());
                nazwisko.setWrappingWidth(137.21630859375);
                HBox.setMargin(nazwisko, new Insets(8, 0, 0, 0));
                Text indeks = new Text(student.getNr_indeksu());
                indeks.setWrappingWidth(199.21630859375);
                HBox.setMargin(indeks, new Insets(8, 0, 0, 0));
                Button usuwanie = new Button("Usuń");
                usuwanie.setPrefSize(12, 109);
                usuwanie.setMinWidth(109);
                usuwanie.setMaxHeight(12);
                HBox.setMargin(usuwanie, new Insets(2, 0, 0, 0));
                usuwanie.setTextFill(Color.rgb(255, 255, 255));
                usuwanie.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 187), null, null)));
                usuwanie.setFont(new Font("Consolas", 14));
                hBox.getChildren().add(imie);
                hBox.getChildren().add(nazwisko);
                hBox.getChildren().add(indeks);
                hBox.getChildren().add(usuwanie);
                hBox.setMaxHeight(35);
                hBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null, new BorderWidths(1.0))));
                studenciBox.getChildren().add(hBox);
            }
        }


    }

    public void usunStudentaAction(){

    }
}
