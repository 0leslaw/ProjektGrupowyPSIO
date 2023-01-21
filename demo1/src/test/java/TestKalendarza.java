import Obserwowani.Kalendarz;
import PakietWydarzenie.Wydarzenie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestKalendarza {

    @Test
    public void stworzListeWydarzenNaDzien(){

        //dane
        Kalendarz kalendarz = new Kalendarz(new ArrayList<Wydarzenie>());
        //dla pustej listy
        //ma zajsc
        for(int i = 0;i < 7;i++)
        Assertions.assertEquals(0,kalendarz.stworzListeWydarzenNaDzien(
                Kalendarz.zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime.now()),i).size());

        //for(int i=0;i<10;i++)
        //kalendarz.dodajWydarzenieDoKalendarza(new Wydarzenie());
    }

}
