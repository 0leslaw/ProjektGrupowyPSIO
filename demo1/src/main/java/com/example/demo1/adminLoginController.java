package com.example.demo1;
import Dane.PrzekazywaniePracownika;
import Serializacja.SerializacjaObiektow;
import Uzytkownicy.Administrator;
import Uzytkownicy.Uzytkownik;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class adminLoginController {

    @FXML
    private Button loginButton;
    @FXML
    private TextField loginTF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private Button returnButton;
    @FXML
    private Label label;
    @FXML
    public void returnButtonAction() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login-choice.fxml"));
            Stage stage = (Stage) returnButton.getScene().getWindow();
            stage.setResizable(false);
            stage.setTitle("Login Choice");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            System.out.println("Nie moża załadować panelu głównego");
        }
    }
    public void loginButtonAction() throws IOException, ClassNotFoundException {
        ArrayList<Administrator> listaAdministracja = new ArrayList<>();
        listaAdministracja.addAll(SerializacjaObiektow.odczytAdminow());
        for (Uzytkownik uzytkownik : listaAdministracja) {
            if (loginTF.getText().equals(uzytkownik.getLogin()) && passwordTF.getText().equals(uzytkownik.getHaslo())) {
                PrzekazywaniePracownika.setIndeksPracownika(listaAdministracja.indexOf(uzytkownik));
                try {
                    Parent root1 = FXMLLoader.load(getClass().getResource("main-panel-admin.fxml"));
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    stage.setTitle("Main Panel");
                    stage.setScene(new Scene(root1));
                    stage.show();

                } catch (Exception e) {
                    System.out.println("Nie można załadować panelu głównego");
                }
            }else {
                label.setVisible(true);
            }
        }
    }
}

