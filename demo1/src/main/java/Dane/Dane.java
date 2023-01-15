package Dane;

import Menu.Danie;
import Menu.Menu;
import Obserwowani.Kalendarz;
import Ogłoszenia.Ogloszenie;
import Serializacja.SerializacjaObiektow;
import Uzytkownicy.Pracownik;
import Uzytkownicy.Samorzad;
import Uzytkownicy.Student;
import Uzytkownicy.Uzytkownik;
import PakietWydarzenie.Wydarzenie;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.PriorityQueue;

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

    public static PriorityQueue<Ogloszenie> stworzOgloszenia(){
        PriorityQueue<Ogloszenie> ogloszenia = new PriorityQueue<>();
        ogloszenia.add(new Ogloszenie("Samorząd", "Odrabianie", "Zgodnie z rozmową na ostatnich zajęciach, w związku z moją nieobecnością, zajęcia 29.11.2022 oraz 06.12.2022 są odwołane i zostaną odrobione w ustalonym terminie. W związku z tym, kolokwium I z Logiki dla Informatyków (ćw.) odbędzie się na kolejnych zajęciach 13.12.2022.", LocalDateTime.now()));
        ogloszenia.add(new Ogloszenie("Jan Kowalski", "Nieobecność", "Szanowni Państwo" + "\n" + "w dniu 30.11.2022 (środa) z powodu wyjazdu służbowego nie będę mógł poprowadzić wykładu z Organizacji Systemów Komputerowych, który planowo powinien się odbyć o godzinie 11:15 - 13:00. Wykład ten zostanie odrobiony w dniu 13.12.2022 r. o godz. 9:15 - 11:00 w sali 329 A-1.", LocalDateTime.now().plusHours(2)));
        ogloszenia.add(new Ogloszenie("Marcin Nowak", "Biblioteka", "informuję, że z dniem 28 listopada 2022 r. Biblioteka PWr uruchomiła nowy system biblioteczny. System ALMA pozyskaliśmy w ramach organizowanego przez Bibliotekę Narodową konkursu: \"Narodowy Program Rozwoju Czytelnictwa 2.0 na lata 2021-2025\", zajmując pierwsze miejsce rankingowe. ALMA to jeden z najnowocześniejszych na świecie systemów chmurowych do zarządzania biblioteką i jej zasobami, wykorzystywany przez większość uczelni sieci Unite!, a także przez University of Cambridge, Harvard University, Boston College czy Princeton University Library. Życzę Państwu owocnego korzystania z usług Biblioteki!", LocalDateTime.now().minusHours(2)));
        ogloszenia.add(new Ogloszenie("Marcin Kowalski", "Biblioteka II", "informuję, że z dniem 28 listopada 2022 r. Biblioteka PWr uruchomiła nowy system biblioteczny. System ALMA pozyskaliśmy w ramach organizowanego przez Bibliotekę Narodową konkursu: \"Narodowy Program Rozwoju Czytelnictwa 2.0 na lata 2021-2025\", zajmując pierwsze miejsce rankingowe. ALMA to jeden z najnowocześniejszych na świecie systemów chmurowych do zarządzania biblioteką i jej zasobami, wykorzystywany przez większość uczelni sieci Unite!, a także przez University of Cambridge, Harvard University, Boston College czy Princeton University Library. Życzę Państwu owocnego korzystania z usług Biblioteki!", LocalDateTime.now().minusHours(3)));
        return ogloszenia;
    }

    public static ArrayList<Wydarzenie> stworzWydarzenia(LocalDateTime dzien, int przesuniecie, int od_pon){
        Wydarzenie wydarzenie = new Wydarzenie("wydarzenie1", LocalDateTime.of(2023,1,1,17,0),new Pracownik("Ronaldo", "", "Nazario", "", "", "", "", "", ""),"no opis oppis opis opi sisko i tak dalej");
        Wydarzenie wydarzenie2 = new Wydarzenie("wydarzenie2", LocalDateTime.of(2023,1,1,15,0),new Pracownik("Abedi", "", "Pele", "", "", "", "", "", ""),"no bedzie sie dzialo");
        Wydarzenie wydarzenie3 = new Wydarzenie("wydarzenie3", LocalDateTime.now(), new Pracownik("Abedi", "", "Pele", "", "", "", "", "", ""), "no bedzie sie dzialo");
        Wydarzenie wydarzenie4 = new Wydarzenie("wydarzenie4", LocalDateTime.now().plusDays(9), new Pracownik("Abedi", "", "Pele", "", "", "", "", "", ""), "no bedzie sie dzialo");
        ArrayList<Wydarzenie> wydarzenia = new ArrayList<>();
        wydarzenia.add(wydarzenie);
        wydarzenia.add(wydarzenie2);
        wydarzenia.add(wydarzenie3);
        wydarzenia.add(wydarzenie4);
        Kalendarz kalendarz = new Kalendarz(wydarzenia);
        return kalendarz.stworzListeWydarzenNaDzien(dzien.plusDays(7*przesuniecie), od_pon);
    }

    public static ArrayList<Student> odczytStudentow()throws IOException,ClassNotFoundException{

        ObjectInputStream pl2 = null;
        ArrayList<Student> lista_osob = new ArrayList<>();
        try{
            pl2 = new ObjectInputStream(new FileInputStream("PlikStudentow.ser"));
            lista_osob.addAll((ArrayList<Student>) pl2.readObject());
        } catch (EOFException ex) {}
        finally{
            if(pl2!=null)
                pl2.close();
        }
        return lista_osob;
    }

    public static void zapisStudentow(ArrayList<Student> lista_osob) throws IOException{
        ObjectOutputStream pl = null;
        try{
            pl=new ObjectOutputStream(new FileOutputStream("PlikStudentow.ser"));
            pl.writeObject(lista_osob);
            pl.flush();
        }
        finally{
            if(pl!=null)
                pl.close();
        }
    }

    public static void czystka_Studentow() throws IOException, ClassNotFoundException, URISyntaxException {
        odczytStudentow();
        zapisStudentow(new ArrayList<Student>());
    }

}
