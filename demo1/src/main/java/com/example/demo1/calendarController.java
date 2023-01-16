package com.example.demo1;

import Obserwowani.Kalendarz;
import PakietWydarzenie.Wydarzenie;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import Dane.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            e.printStackTrace();
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
        try {
            fillGrid(8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void NextWeek(){
        przesuniecie++;
        try {
            fillGrid(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void LastWeek(){
        przesuniecie--;
        try {
            fillGrid(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void fillGrid(int tmp) throws IOException, ClassNotFoundException {
        ArrayList<Node> dniTyg = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            dniTyg.add(grid.getChildren().get(i*tmp));
        }
        grid.getChildren().clear();
        for (int i = 0; i < 7; i++) {
            grid.add(dniTyg.get(i), i, 1);
        }
        for (int i = przesuniecie * 7; i < przesuniecie * 7 + 7; i++) {
            VBox box = new VBox();
            box.setPrefSize(32, 94);
            Text l = new Text(Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()).plusDays(i).toLocalDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            l.setTextAlignment(TextAlignment.CENTER);
            box.getChildren().add(l);
            VBox.setMargin(l, new Insets(0, 0, 0, 12));
            grid.add(box, i - przesuniecie * 7, 0);
        }
        for (int i = 0; i < 7; i++) {
            ArrayList<Wydarzenie> wydarzenia = Dane.stworzWydarzenia(Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()), przesuniecie, i);
            for (int j = 0; j < wydarzenia.size(); j++) {
                VBox box = new VBox();
                Text godzina = new Text(wydarzenia.get(j).getGodzina());
                godzina.setFont(Font.font(8));
                Label tytul = new Label(wydarzenia.get(j).getNazwa_wydarzenia());
                tytul.setFont(Font.font(8));
                tytul.setAlignment(Pos.CENTER_RIGHT);
                tytul.setTextAlignment(TextAlignment.CENTER);
                tytul.setMinWidth(91);
                tytul.setMaxWidth(92);
                box.getChildren().add(godzina);
                box.getChildren().add(tytul);
                grid.add(box, i, j + 2);
            }
        }
    }
}
