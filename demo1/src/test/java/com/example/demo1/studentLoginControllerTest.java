package com.example.demo1;

import Uzytkownicy.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class studentLoginControllerTest {

    @Test
    void loginButtonAction() {
        studentLoginController SLC = new studentLoginController();
        Assertions.assertNotNull(SLC);
        Student student1 = new Student("barack", "obama", "jakie_on_ma_nazwisko?", "barack@obama.freebobux.ru", "barack", "obama", 3, "000001", "USA");
        Student student2 = new Student("andrzej", "krzysztof", "duda", "chesspresident@omlet.net", "duda", "duda", 7, "000002", "PL");

        Assertions.assertEquals(false, SLC.isLoginAndPasswordCorrect(student1, "duda", "duda"));
        Assertions.assertEquals(true, SLC.isLoginAndPasswordCorrect(student2, "duda", "duda"));
    }
}