package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class adminMenuController {

    @FXML
    private Button dodajStudenta;
    @FXML
    private Button dodajPracownika;
    @FXML
    private Button dodajSamorzad;

    public void toDodajStudenta(){
        stworzStudentaController controller = new stworzStudentaController();
        controller.stworzStudenta(dodajStudenta);
    }

    public void toDodajPracownika(){
        stworzPracownikaController controller = new stworzPracownikaController();
        controller.stworzPracownika(dodajPracownika);
    }

    public void toDodajSamorzad(){
        stworzSamorzadController controller = new stworzSamorzadController();
        controller.stworzSamorzad(dodajSamorzad);
    }
}
