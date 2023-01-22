package Uzytkownicy;

import PakietKursy.Kursy;
import java.util.ArrayList;

public class Student extends Uzytkownik{
    private int semestr;
    private ArrayList<Kursy> lista_kursow = new ArrayList<>();
    private String nr_indeksu;
    private String kierunek;
    private int liczba_nowych_ogloszen;
    private int liczba_nowych_wydarzen;
    private boolean powiadomienia = true;

    public Student(){
        super();
        semestr = 0;
        nr_indeksu = "";
        kierunek = "";
    }
    public Student(String imie, String drugie_imie, String nazwisko, String email, String login, String haslo, int semestr, String nr_indeksu, String kierunek) {
        super(imie, drugie_imie, nazwisko, email, login, haslo);
        this.semestr = semestr;
        this.nr_indeksu = nr_indeksu;
        this.kierunek = kierunek;
    }

    public int getSemestr() {
        return semestr;
    }

    public void setSemestr(int semestr) {
        this.semestr = semestr;
    }

    public ArrayList<Kursy> getLista_kursow() {
        return lista_kursow;
    }

    public void setLista_kursow(ArrayList<Kursy> lista_kursow) {
        this.lista_kursow = lista_kursow;
    }

    public String getNr_indeksu() {
        return nr_indeksu;
    }

    public void setNr_indeksu(String nr_indeksu) {
        this.nr_indeksu = nr_indeksu;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public int getLiczba_nowych_ogloszen() {
        return liczba_nowych_ogloszen;
    }

    public void setLiczba_nowych_ogloszen(int liczba_nowych_ogloszen) {
        this.liczba_nowych_ogloszen = liczba_nowych_ogloszen;
    }

    @Override
    public String toString() {
        return "Student{" +
                "semestr=" + semestr +
                ", lista_kursow=" + lista_kursow +
                ", nr_indeksu='" + nr_indeksu + '\'' +
                ", kierunek='" + kierunek + '\'' +
                ", liczba_nowych_powiadomien=" + liczba_nowych_ogloszen +
                ", login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                ", imie='" + imie + '\'' +
                ", drugie_imie='" + drugie_imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getLiczba_nowych_wydarzen() {
        return liczba_nowych_wydarzen;
    }

    public void setLiczba_nowych_wydarzen(int liczba_nowych_wydarzen) {
        this.liczba_nowych_wydarzen = liczba_nowych_wydarzen;
    }

    public boolean isPowiadomienia() {
        return powiadomienia;
    }

    public void setPowiadomienia(boolean powiadomienia) {
        this.powiadomienia = powiadomienia;
    }
}
