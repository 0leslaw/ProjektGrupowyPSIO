import Obserwowani.Kalendarz;
import PakietWydarzenie.Wydarzenie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestKalendarza {

    @Test
    public void stworzListeWydarzenNaDzien() throws IOException, ClassNotFoundException {

        //dane
        Kalendarz kalendarz = new Kalendarz(new ArrayList<Wydarzenie>());
        //dla pustej listy
        //ma zajsc dla kazdego dnia pusta lista wydarzen na dzien
        for(int i = 0;i < 100;i++)
        Assertions.assertEquals(0,kalendarz.stworzListeWydarzenNaDzien(
                Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()),i).size());

        //for(int i=0;i<10;i++)
        //kalendarz.dodajWydarzenieDoKalendarza(new Wydarzenie());

        //dla niepustej listy i wydarzen z poniedzialku tego tygodnia
        for(int i=0;i<99;i++)
            kalendarz.dodajWydarzenieDoKalendarza(new Wydarzenie("test1",
                    Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()),"df","sdfd"));

        for(int i=7;i<20;i++)
            kalendarz.dodajWydarzenieDoKalendarza(new Wydarzenie("test1",
                    Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()).plusDays(i),"df","sdfd"));


        //ma zajsc dlugosc listy tegoż poniedzialku
        Assertions.assertEquals(99,kalendarz.stworzListeWydarzenNaDzien(
                Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()),0).size());

        //ma zajsc dlugosc listy dnia na srode nastepnego tygodnia rowna 1
        Assertions.assertEquals(1,kalendarz.stworzListeWydarzenNaDzien(
                Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()),7).size());

        //ma zajsc dlugosc listy dnia na wtorek nastepnego tygodnia rowna 2
        kalendarz.dodajWydarzenieDoKalendarza(new Wydarzenie("test1",
                Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()).plusDays(8),"df","sdfd"));
        Assertions.assertEquals(2,kalendarz.stworzListeWydarzenNaDzien(
                Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()),8).size());

        //ma zajsc pusta lista za 30 dni
        Assertions.assertEquals(0,kalendarz.stworzListeWydarzenNaDzien(
                Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()),30).size());
    }

}
