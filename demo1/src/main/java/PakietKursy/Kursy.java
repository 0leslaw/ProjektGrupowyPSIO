package PakietKursy;

import Uzytkownicy.Pracownik;
import Ocena.*;
import java.util.ArrayList;

public class Kursy {

    //admin tworzacy kurs wywoluje funkcje deserializujaca liste prowadzacych ktora wyswietla sie mu do wyboru do przydzielenia
    //dla tego kursu
    String nazwa_kursu;
    Pracownik prowadzacy;
    int ocena_prowadzacego_na_kursie;

    ArrayList<Ocena> oceny;
//    ArrayList<String> dni_tygodnia_i_godziny;

    public Kursy(String nazwa_kursu, Pracownik prowadzacy, int ocena_prowadzacego_na_kursie) {
        this.nazwa_kursu = nazwa_kursu;
        this.prowadzacy = prowadzacy;
        this.ocena_prowadzacego_na_kursie = ocena_prowadzacego_na_kursie;
    }
}
