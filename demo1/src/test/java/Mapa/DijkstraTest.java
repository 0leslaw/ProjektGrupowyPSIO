package Mapa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void TestZawo() {
        ArrayList<Wezel> wezly = new ArrayList<Wezel>();

        Wezel A1 = new Wezel("A1", 0, 0);
        Wezel A2 = new Wezel("A2", 30, 0);
        Wezel A3 = new Wezel("A3", 0, 40);
        Wezel A4 = new Wezel("A3", 60, 0);
        Wezel A5 = new Wezel("A3", -30, 0);

        A1.dodaj_sasiada(A2, 30);
        A1.dodaj_sasiada(A3, 40);
        A1.dodaj_sasiada(A5, 30);
        A2.dodaj_sasiada(A4, 30);
        A2.dodaj_sasiada(A3, 50);

        wezly.add(A1);
        wezly.add(A2);
        wezly.add(A3);
        wezly.add(A4);
        wezly.add(A5);

        Dijkstra DJ = new Dijkstra(wezly, A4, A5);
        Assertions.assertEquals(90, A5.getOdleglosc_od_zrodla());
    }
}