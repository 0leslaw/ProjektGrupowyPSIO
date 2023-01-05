package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class calendarController implements Initializable
{
    @FXML
    private Button returnButton;

    @FXML
    private GridPane grid;
    @FXML
    public void Calendar(Button calendarButton) {
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
            System.out.println(dniTyg.get(i).toString());
        }
        grid.getChildren().clear();
        System.out.println("2");
        for(int i = 0; i < 7; i++) {
            grid.add(dniTyg.get(i), i, 0);
            System.out.println("3");
        }

    }
}
