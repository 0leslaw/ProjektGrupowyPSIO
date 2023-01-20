package com.example.demo1;

import Serializacja.SerializacjaObiektow;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Dane.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class usunStudentaController implements Initializable {

    @FXML
    private Button returnButton;
    @FXML
    private TextField szukanyIndeks;
    @FXML
    private TextField szukaneImie;
    @FXML
    private TextField szukaneNazwisko;
    @FXML
    private Label uwaga;
    @FXML
    private VBox studenciBox;
    @FXML
    private Button szukaj;

    public void usunStudenta(Button usuwanie)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("usun_studenta.fxml"));
            Stage stage = (Stage) usuwanie.getScene().getWindow();
            stage.setTitle("Usuwanie studenta");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        szukaneImie.setText(usuwaniePomoc.getImie());
        szukaneNazwisko.setText(usuwaniePomoc.getNazwisko());
        szukanyIndeks.setText(usuwaniePomoc.getIndeks());
        int i = 0;
        ArrayList<Student> studenci = null;
        try {
            studenci = SerializacjaObiektow.odczytStudentow();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (studenci == null) {
            System.out.println("Nie udało się załadować studentów");
        }else {
            for(Student student: studenci) {
                if(student.getImie().contains(szukaneImie.getText()) && student.getNazwisko().contains(szukaneNazwisko.getText()) && student.getNr_indeksu().contains(szukanyIndeks.getText())) {
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
                    usuwanie.setId(String.valueOf(i));
                    i++;
                    usuwanie.setOnAction(actionEvent -> {
                        try {
                            usunStudentaAction(actionEvent);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    hBox.getChildren().add(imie);
                    hBox.getChildren().add(nazwisko);
                    hBox.getChildren().add(indeks);
                    hBox.getChildren().add(usuwanie);
                    hBox.setMaxHeight(35);
                    hBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1.0))));
                    studenciBox.getChildren().add(hBox);
                }
            }
        }
    }

    public void usunStudentaAction(Event e) throws IOException, ClassNotFoundException {
        ArrayList<Student> studenci = SerializacjaObiektow.odczytStudentow();
        Button button = (Button) e.getTarget();
        int id = Integer.parseInt(button.getId());
        studenci.remove(id);
        SerializacjaObiektow.zapisStudentow(studenci, "PlikStudentow.ser");
        usunStudenta(returnButton);
    }

    public void szukajAction(){
        usuwaniePomoc.setImie(szukaneImie.getText());
        usuwaniePomoc.setNazwisko(szukaneNazwisko.getText());
        usuwaniePomoc.setIndeks(szukanyIndeks.getText());
        usunStudenta(returnButton);
    }
}
