package com.example.demo1;

import Uzytkownicy.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

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

        Random rand = new Random();

        for(int j = 0; j < 1000; j++){
            Student st = new Student();
            st.setLogin(rand.ints(97, 123).filter(i -> (i<=57 || i>=65) && (i<=90 || i>= 97)).limit(6).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
            st.setHaslo("duda");
            Assertions.assertEquals(false, SLC.isLoginAndPasswordCorrect(st, "duda", "duda"));
        }
        for(int j = 0; j < 1000; j++){
            Student st = new Student();
            st.setLogin("duda");
            st.setHaslo(rand.ints(97, 123).filter(i -> (i<=57 || i>=65) && (i<=90 || i>= 97)).limit(6).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
            Assertions.assertEquals(false, SLC.isLoginAndPasswordCorrect(st, "duda", "duda"));
        }
        for(int j = 0; j < 1000; j++){
            Student st = new Student();
            st.setLogin(rand.ints(97, 123).filter(i -> (i<=57 || i>=65) && (i<=90 || i>= 97)).limit(6).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
            st.setHaslo(rand.ints(97, 123).filter(i -> (i<=57 || i>=65) && (i<=90 || i>= 97)).limit(6).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
            Assertions.assertEquals(false, SLC.isLoginAndPasswordCorrect(st, "duda", "duda"));
        }
        for(int j = 0; j < 1000; j++){
            Student st = new Student();
            String login = rand.ints(97, 123).filter(i -> (i<=57 || i>=65) && (i<=90 || i>= 97)).limit(6).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
            String haslo = rand.ints(97, 123).filter(i -> (i<=57 || i>=65) && (i<=90 || i>= 97)).limit(6).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
            st.setLogin(login);
            st.setHaslo(haslo);
            Assertions.assertEquals(true, SLC.isLoginAndPasswordCorrect(st, login, haslo));
        }
    }
}