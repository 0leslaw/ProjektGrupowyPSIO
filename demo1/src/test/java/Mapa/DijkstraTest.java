package Mapa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    public void testOleslaw(){

        //sprawdzenie czy droga od przeciwleglych biegnie po przekątnej dla roznych gridow
        //przy okazji sprawdzamy czy przy skalowaniu tego samego ukladu zostaje ta sama droga
        ArrayList<Wezel> lista1;
        for (int i=2;i<10;i++) {
            lista1 = tworzyGridPolaczonychDookola(i, i);
            TestZawo1(lista1, lista1.get(0), lista1.get(lista1.size() - 1), 142 * (i-1)*i);
        }
        lista1 = tworzyGridPolaczonychDookola(1, 10);
        //sprawdzenie przykladowych scierzek
        TestZawo1(lista1,lista1.get(4),lista1.get(32),142*2+100);
        TestZawo1(lista1,lista1.get(59),lista1.get(37),142*2);
        TestZawo1(lista1,lista1.get(19),lista1.get(18),100);
        TestZawo1(lista1,lista1.get(8),lista1.get(72),142*6+100);
    }

    public ArrayList<Wezel> tworzyGridPolaczonychDookola(int mnoznik_dlugosci,int ilosc_w_k){

        ArrayList<Wezel> wlist = new ArrayList<>();
        Wezel[][] wTab = new Wezel[ilosc_w_k][ilosc_w_k];

        for(int i =0;i<ilosc_w_k;i++)
            for(int j =0;j<ilosc_w_k;j++)
                wTab[i][j] = new Wezel(Integer.toString(i) + "x" + Integer.toString(j), j * 10, i * 10);


        for(int i =1;i<ilosc_w_k-1;i++)
            for(int j =1;j<ilosc_w_k-1;j++){
                wTab[i][j].dodaj_sasiada(wTab[i-1][j],100*mnoznik_dlugosci);
                wTab[i][j].dodaj_sasiada(wTab[i+1][j],100*mnoznik_dlugosci);
                wTab[i][j].dodaj_sasiada(wTab[i][j-1],100*mnoznik_dlugosci);
                wTab[i][j].dodaj_sasiada(wTab[i][j+1],100*mnoznik_dlugosci);
                wTab[i][j].dodaj_sasiada(wTab[i-1][j-1],142*mnoznik_dlugosci);
                wTab[i][j].dodaj_sasiada(wTab[i+1][j-1],142*mnoznik_dlugosci);
                wTab[i][j].dodaj_sasiada(wTab[i-1][j+1],142*mnoznik_dlugosci);
                wTab[i][j].dodaj_sasiada(wTab[i+1][j+1],142*mnoznik_dlugosci);
            }
        for (int i =1;i<ilosc_w_k-1;i++){
            wTab[i][0].dodaj_sasiada(wTab[i][1],100*mnoznik_dlugosci);
            wTab[i][0].dodaj_sasiada(wTab[i-1][1],142*mnoznik_dlugosci);
            wTab[i][0].dodaj_sasiada(wTab[i+1][1],142*mnoznik_dlugosci);

            wTab[i][ilosc_w_k-1].dodaj_sasiada(wTab[i][ilosc_w_k-2],100*mnoznik_dlugosci);
            wTab[i][ilosc_w_k-1].dodaj_sasiada(wTab[i-1][ilosc_w_k-2],142*mnoznik_dlugosci);
            wTab[i][ilosc_w_k-1].dodaj_sasiada(wTab[i+1][ilosc_w_k-2],142*mnoznik_dlugosci);

            wTab[0][i].dodaj_sasiada(wTab[1][i],100*mnoznik_dlugosci);
            wTab[0][i].dodaj_sasiada(wTab[1][i-1],142*mnoznik_dlugosci);
            wTab[0][i].dodaj_sasiada(wTab[1][i+1],142*mnoznik_dlugosci);

            wTab[ilosc_w_k-1][i].dodaj_sasiada(wTab[ilosc_w_k-2][i],100*mnoznik_dlugosci);
            wTab[ilosc_w_k-1][i].dodaj_sasiada(wTab[ilosc_w_k-2][i-1],142*mnoznik_dlugosci);
            wTab[ilosc_w_k-1][i].dodaj_sasiada(wTab[ilosc_w_k-2][i+1],142*mnoznik_dlugosci);
        }
        wTab[0][0].dodaj_sasiada(wTab[1][0],100*mnoznik_dlugosci);
        wTab[0][0].dodaj_sasiada(wTab[0][1],100*mnoznik_dlugosci);
        wTab[0][0].dodaj_sasiada(wTab[1][1],142*mnoznik_dlugosci);

        wTab[ilosc_w_k-1][0].dodaj_sasiada(wTab[ilosc_w_k-2][0],100*mnoznik_dlugosci);
        wTab[ilosc_w_k-1][0].dodaj_sasiada(wTab[ilosc_w_k-1][1],100*mnoznik_dlugosci);
        wTab[ilosc_w_k-1][0].dodaj_sasiada(wTab[ilosc_w_k-2][1],142*mnoznik_dlugosci);

        wTab[0][ilosc_w_k-1].dodaj_sasiada(wTab[0][ilosc_w_k-2],100*mnoznik_dlugosci);
        wTab[0][ilosc_w_k-1].dodaj_sasiada(wTab[1][ilosc_w_k-1],100*mnoznik_dlugosci);
        wTab[0][ilosc_w_k-1].dodaj_sasiada(wTab[1][ilosc_w_k-2],142*mnoznik_dlugosci);

        wTab[ilosc_w_k-1][ilosc_w_k-1].dodaj_sasiada(wTab[ilosc_w_k-1][ilosc_w_k-2],100*mnoznik_dlugosci);
        wTab[ilosc_w_k-1][ilosc_w_k-1].dodaj_sasiada(wTab[ilosc_w_k-2][ilosc_w_k-1],100*mnoznik_dlugosci);
        wTab[ilosc_w_k-1][ilosc_w_k-1].dodaj_sasiada(wTab[ilosc_w_k-2][ilosc_w_k-2],142*mnoznik_dlugosci);

        for(int i =0;i<ilosc_w_k;i++)
            for(int j =0;j<ilosc_w_k;j++)
                wlist.add(wTab[i][j]);


        return wlist;
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
    public void TestZawo1(ArrayList<Wezel> wezly, Wezel A1, Wezel A2, int val){
        Dijkstra DJ = new Dijkstra(wezly, A1, A2);
        DJ.setWezly(wezly);
        DJ.dijkstra_algo();
        Assertions.assertEquals(val, A2.getOdleglosc_od_zrodla());
        System.out.println("expected: "+val+", score: "+A2.getOdleglosc_od_zrodla());
    }
}