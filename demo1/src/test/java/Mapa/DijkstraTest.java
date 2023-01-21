package Mapa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {
    @Test
    public void znajdzDroge(){
        ArrayList<Wezel> wlist = new ArrayList<>();
        Wezel[][] wTab = new Wezel[10][10];
        Wezel roboczy;
        for(int i =0;i<10;i++)
            for(int j =0;j<10;j++) {
                wlist.add(new Wezel(Integer.toString(i) + "x" + Integer.toString(j), j * 10, i * 10));
                wTab[i][j] = wlist.get(wlist.size()-1);
            }

        for(int i =0;i<10;i++)
            for(int j =0;j<10;j++){

            }

    }

    @Test
    void TestZawo() {
        ArrayList<Wezel> wezly = new ArrayList<Wezel>();

        Wezel A1 = new Wezel("A1", 0, 0);
        Wezel A2 = new Wezel("A2", 30, 0);
        Wezel A3 = new Wezel("A3", 0, 40);
        Wezel A4 = new Wezel("A4", 60, 0);
        Wezel A5 = new Wezel("A5", -30, 0);
        Wezel A6 = new Wezel("A6", 60, -40);

        A1.dodaj_sasiada(A2, 30);
        A1.dodaj_sasiada(A3, 40);
        A1.dodaj_sasiada(A5, 30);
        A2.dodaj_sasiada(A4, 30);
        A2.dodaj_sasiada(A3, 50);
        A4.dodaj_sasiada(A6, 40);
        A2.dodaj_sasiada(A6, 50);
        A1.dodaj_sasiada(A6, 72);

        wezly.add(A1);
        wezly.add(A2);
        wezly.add(A3);
        wezly.add(A4);
        wezly.add(A5);
        wezly.add(A6);

        TestZawo1(wezly, A5, A3, 70);
        TestZawo1(wezly, A5, A6, 102);
        TestZawo1(wezly, A6, A3, 100);
        TestZawo1(wezly, A3, A6, 100);
        TestZawo1(wezly, A3, A4, 80);
    }
    //lol
    public void TestZawo1(ArrayList<Wezel> wezly, Wezel A1, Wezel A2, int val){
        Dijkstra DJ = new Dijkstra(wezly, A1, A2);
        DJ.setWezly(wezly);
        DJ.dijkstra_algo();
        Assertions.assertEquals(val, A2.getOdleglosc_od_zrodla());
        System.out.println("expected: "+val+", score: "+A2.getOdleglosc_od_zrodla());
    }
}