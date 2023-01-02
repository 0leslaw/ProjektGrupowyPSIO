package PakietProjektowy;

import PakietKursy.Kursy;

import java.util.ArrayList;

public class Pracownik extends Uzytkownik{
    //pracownik musi posiadac kurs a kurs ocene bo kilka kursow moze miec jednego prowadzacego
    //a w przypadku gdy chcemy miec mozliwosc oceny kazdego kursu

    String wydzial;
    String tytul_naukowy;
    String katedra;
    ArrayList<Kursy> kursy = new ArrayList<>();

    public Pracownik(String imie, String drugie_imie, String nazwisko, String email, String login, String haslo,
                     String wydzial, String tytul_naukowy, String katedra) {
        super(imie, drugie_imie, nazwisko, email, login, haslo);
        this.wydzial = wydzial;
        this.tytul_naukowy = tytul_naukowy;
        this.katedra = katedra;
    }

    public String getWydzial() {
        return wydzial;
    }

    public void setWydzial(String wydzial) {
        this.wydzial = wydzial;
    }

    public String getTytul_naukowy() {
        return tytul_naukowy;
    }

    public void setTytul_naukowy(String tytul_naukowy) {
        this.tytul_naukowy = tytul_naukowy;
    }

    public String getKatedra() {
        return katedra;
    }

    public void setKatedra(String katedra) {
        this.katedra = katedra;
    }

    public ArrayList<Kursy> getKursy() {
        return kursy;
    }

    public void setKursy(ArrayList<Kursy> kursy) {
        this.kursy = kursy;
    }
}
