package com.example.demo1;

import Obserwowani.Kalendarz;
import PakietWydarzenie.Wydarzenie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import Dane.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class calendarController implements Initializable
{
    @FXML
    private Button returnButton;

    private int przesuniecie = 0;
    @FXML
    private GridPane grid;
    @FXML
    public void Calendar(Button calendarButton) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("calendar.fxml"));
            Stage stage = (Stage) calendarButton.getScene().getWindow();

            stage.setTitle("Kalendarz");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie można załadować kalendarza");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Node> dniTyg = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            dniTyg.add(grid.getChildren().get(i*8));
        }
        grid.getChildren().clear();
        for(int i = 0; i < 7; i++) {
            grid.add(dniTyg.get(i), i, 1);
        }
        for(int i = 0; i < 7; i++) {
            VBox box = new VBox();
            box.setPrefSize(32, 94);
            Text l = new Text(Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()).plusDays(i).toLocalDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            l.setTextAlignment(TextAlignment.CENTER);
            box.getChildren().add(l);
            VBox.setMargin(l, new Insets(0, 0, 0, 12));
            grid.add(box, i, 0);
        }
        for(int i =0; i<7; i++){
            ArrayList<Wydarzenie> wydarzenia = Dane.stworzWydarzenia(Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()), i);
            for(int j = 0; j< wydarzenia.size(); j++){
                grid.add(new Text(wydarzenia.get(j).getNazwa_wydarzenia()), i, j);
            }
        }
    }

    public void NextWeek(){
        ArrayList<Node> dniTyg = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            dniTyg.add(grid.getChildren().get(i));
        }
        grid.getChildren().clear();
        for(int i = 0; i < 7; i++) {
            grid.add(dniTyg.get(i), i, 1);
        }
        przesuniecie ++;
        for(int i = przesuniecie*7; i < przesuniecie*7+7; i++) {
            VBox box = new VBox();
            box.setPrefSize(32, 94);
            Text l = new Text(Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()).plusDays(i).toLocalDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            l.setTextAlignment(TextAlignment.CENTER);
            box.getChildren().add(l);
            VBox.setMargin(l, new Insets(0, 0, 0, 12));
            grid.add(box, i-przesuniecie*7, 0);
        }
        for(int i =0; i<7; i++){
            ArrayList<Wydarzenie> wydarzenia = Dane.stworzWydarzenia(Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()).plusDays(7*i), i);
            for(int j = 0; j< wydarzenia.size(); j++){
                grid.add(new Text(wydarzenia.get(j).getNazwa_wydarzenia()), i, j);
            }
        }
    }

    public void LastWeek(){
        ArrayList<Node> dniTyg = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            dniTyg.add(grid.getChildren().get(i));
        }
        grid.getChildren().clear();
        for(int i = 0; i < 7; i++) {
            grid.add(dniTyg.get(i), i, 1);
        }
        przesuniecie --;
        for(int i = przesuniecie*7; i < przesuniecie*7+7; i++) {
            VBox box = new VBox();
            box.setPrefSize(32, 94);
            Text l = new Text(Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()).plusDays(i).toLocalDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            l.setTextAlignment(TextAlignment.CENTER);
            box.getChildren().add(l);
            VBox.setMargin(l, new Insets(0, 0, 0, 12));
            grid.add(box, i-przesuniecie*7, 0);
        }
        for(int i =0; i<7; i++){
            ArrayList<Wydarzenie> wydarzenia = Dane.stworzWydarzenia(Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()).plusDays(7*przesuniecie), i);
            for(int j = 0; j< wydarzenia.size(); j++){
                grid.add(new Text(wydarzenia.get(j).getNazwa_wydarzenia()), i, j);
            }
        }
    }
}
