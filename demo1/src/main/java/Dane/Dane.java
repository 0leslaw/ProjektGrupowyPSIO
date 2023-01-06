package Dane;

import Menu.Danie;
import Menu.Menu;
import Obserwowani.Kalendarz;
import Ogłoszenia.Ogloszenie;
import PakietProjektowy.Pracownik;
import PakietProjektowy.Samorzad;
import PakietProjektowy.Student;
import PakietProjektowy.Uzytkownik;
import PakietWydarzenie.Wydarzenie;

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
        uzytkownicy.add(new Student("Zlatan", "Robert", "Lewandowski", "goat", "zlatan", "thegoat", 1, "357537", "Informatyka", 0 ));
        uzytkownicy.add(new Samorzad("Szymon", "Piotr", "Marciniak", "goatref", "szymek", "colina"));
        uzytkownicy.add(new Pracownik("Krzysztof", "Janusz", "Jodlowiec", "alga", "krzysiu", "macierz", "W4", "Doktor", "Matematyki"));
        return uzytkownicy;
    }

    public static PriorityQueue<Ogloszenie> stworzOgloszenia(){
        PriorityQueue<Ogloszenie> ogloszenia = new PriorityQueue<>();
        ogloszenia.add(new Ogloszenie("Zlatan Lewandowski", "I am the goat", "Zgodnie z rozmową na ostatnich zajęciach, w związku z moją nieobecnością, zajęcia 29.11.2022 oraz 06.12.2022 są odwołane i zostaną odrobione w ustalonym terminie. W związku z tym, kolokwium I z Logiki dla Informatyków (ćw.) odbędzie się na kolejnych zajęciach 13.12.2022.", LocalDateTime.now()));
        ogloszenia.add(new Ogloszenie("Robert Ibra", "I am the goat", "Szanowni Państwo" + "\n" + "w dniu 30.11.2022 (środa) z powodu wyjazdu służbowego nie będę mógł poprowadzić wykładu z Organizacji Systemów Komputerowych, który planowo powinien się odbyć o godzinie 11:15 - 13:00. Wykład ten zostanie odrobiony w dniu 13.12.2022 r. o godz. 9:15 - 11:00 w sali 329 A-1.", LocalDateTime.now().plusHours(2)));
        ogloszenia.add(new Ogloszenie("Leo Nazario", "I am the goat", "informuję, że z dniem 28 listopada 2022 r. Biblioteka PWr uruchomiła nowy system biblioteczny. System ALMA pozyskaliśmy w ramach organizowanego przez Bibliotekę Narodową konkursu: \"Narodowy Program Rozwoju Czytelnictwa 2.0 na lata 2021-2025\", zajmując pierwsze miejsce rankingowe. ALMA to jeden z najnowocześniejszych na świecie systemów chmurowych do zarządzania biblioteką i jej zasobami, wykorzystywany przez większość uczelni sieci Unite!, a także przez University of Cambridge, Harvard University, Boston College czy Princeton University Library. Życzę Państwu owocnego korzystania z usług Biblioteki!", LocalDateTime.now().minusHours(2)));
        return ogloszenia;
    }

    public static ArrayList<Wydarzenie> stworzWydarzenia(LocalDateTime dzien, int przesuniecie){
        Wydarzenie wydarzenie = new Wydarzenie("Skok z wieży widokowej", LocalDateTime.of(2023,1,1,17,0),new Pracownik("Ronaldo", "", "Nazario", "", "", "", "", "", ""),"no opis oppis opis opi sisko i tak dalej no skok z wierzy widokowej");
        Wydarzenie wydarzenie2 = new Wydarzenie("Skok z wieży w bukowcu", LocalDateTime.of(2023,1,1,15,0),new Pracownik("Abedi", "", "Pele", "", "", "", "", "", ""),"no bedzie sie dzialo");
        ArrayList<Wydarzenie> wydarzenia = new ArrayList<>();
        wydarzenia.add(wydarzenie);
        wydarzenia.add(wydarzenie2);
        Kalendarz kalendarz = new Kalendarz(wydarzenia);
        return kalendarz.stworzListeWydarzenNaDzien(kalendarz.zwracaDateNajbUbieglegoPoniedzialku(dzien).plusDays(przesuniecie), dzien.getDayOfWeek().getValue()-1);
    }
}
