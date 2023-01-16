package Dane;

import Menu.Danie;
import Menu.Menu;
import Obserwowani.Kalendarz;
import Serializacja.SerializacjaObiektow;
import Uzytkownicy.Pracownik;
import Uzytkownicy.Samorzad;
import Uzytkownicy.Student;
import Uzytkownicy.Uzytkownik;
import PakietWydarzenie.Wydarzenie;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Dane {

    public static Menu stworzMenu()
    {
        ArrayList<Danie> dania = new ArrayList<>();
        dania.add(new Danie("schabowy", 30));
        dania.add(new Danie("pierogi", 40));
        dania.add(new Danie("kawa", 45));
        dania.add(new Danie("jabłko", 20));
        dania.add(new Danie("dobra ocena z PSiO", Integer.MAX_VALUE));
        Menu menu = new Menu(dania);
        return menu;
    }

    public static Danie danie()
    {
        Menu menu = Dane.stworzMenu();
        return menu.jakieDanie();
    }

    // testowo do zrobienia logowania
    public static ArrayList<Uzytkownik> stworz_uzytkownikow(){
        ArrayList<Uzytkownik> uzytkownicy = new ArrayList<>();
        uzytkownicy.add(new Student("Zlatan", "Robert", "Lewandowski", "goat", "zlatan", "thegoat", 1, "357537", "Informatyka"));
        uzytkownicy.add(new Samorzad("Szymon", "Piotr", "Marciniak", "goatref", "szymek", "colina"));
        uzytkownicy.add(new Pracownik("Krzysztof", "Janusz", "Jodlowiec", "alga", "krzysiu", "macierz", "W4", "Doktor", "Matematyki"));
        return uzytkownicy;
    }

    public static ArrayList<Wydarzenie> stworzWydarzenia(LocalDateTime dzien, int przesuniecie, int od_pon) throws IOException, ClassNotFoundException {
        ArrayList<Wydarzenie> wydarzenia = SerializacjaObiektow.odczytWydarzen();
        Kalendarz kalendarz = new Kalendarz(wydarzenia);
        return kalendarz.stworzListeWydarzenNaDzien(dzien.plusDays(7*przesuniecie), od_pon);
    }

}
