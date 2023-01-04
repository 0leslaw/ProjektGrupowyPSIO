package com.example.demo1;

import Mapa.Main;
import Mapa.Wezel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class mapController implements Initializable {

    @FXML
    private Button returnButton;
    @FXML
    private Button route;
    @FXML
    private Circle circle;
    @FXML
    private ImageView mapView;
    @FXML
    private Path mapPath;
    @FXML
    private TextField start;
    @FXML
    private TextField cel;
    @FXML
    private Label bladMapa;

    @FXML
    public void Map(Button mapButton){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("map.fxml"));
            Stage stage = (Stage) mapButton.getScene().getWindow();
            stage.setTitle("Mapa");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie można załadować map");
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

    public void wyswietlDroge(){
        mapPath.getElements().clear();
        circle.setVisible(false);
        mapPath.setVisible(false);
        ArrayList<Wezel> droga = new ArrayList<>();
        Main tmp = new Main();
        droga.addAll(tmp.znajdzDroge(start.getText(), cel.getText()));
        if(droga.size()>0) {
            bladMapa.setOpacity(0.0);
            mapPath.getElements().add(new MoveTo(droga.get(0).getPosX(), droga.get(0).getPosY()));
            for(int i = 1; i< droga.size(); i++)
            {
                mapPath.getElements().add(new LineTo(droga.get(i).getPosX(), droga.get(i).getPosY()));
            }
            circle.setLayoutX(droga.get(droga.size()-1).getPosX());
            circle.setLayoutY(droga.get(droga.size()-1).getPosY());
            mapPath.setVisible(true);
            circle.setVisible(true);
        }else{
            bladMapa.setOpacity(1.0);
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        mapPath.setVisible(false);
        circle.setVisible(false);
    }
}
