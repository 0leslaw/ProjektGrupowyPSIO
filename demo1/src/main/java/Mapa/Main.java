package Mapa;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    private ArrayList<Wezel> zrodlo= new ArrayList<>();

    private ArrayList<Wezel> cel= new ArrayList<>();

    private ArrayList<Wezel> wezly = new ArrayList<>();

    private ArrayList<Wezel> droga = new ArrayList<>();

    private int dlugosc;

    public void droga() {
        this.wezly.clear();
        Wezel polinka = new Wezel("polinka", 426, 522);
        Wezel C13_wyspianskiego = new Wezel("C13", 504, 508);
        Wezel C13_patio_portiernia = new Wezel("C13", 501, 479);
        Wezel C13_patio = new Wezel("C13", 465, 405);
        Wezel C8 = new Wezel("C8", 429, 402);
        Wezel C13_schodki = new Wezel("C13_schodki", 596, 457);
        Wezel wysp_norwida = new Wezel("wysp_norwida", 667, 508);
        Wezel A1_glowne = new Wezel("A1", 741, 504);
        Wezel A2 = new Wezel("A2", 914, 512);
        Wezel B1_wysp = new Wezel("B1", 965, 523);
        Wezel B1_smol = new Wezel("B1", 1012, 429);
        Wezel B4 = new Wezel("B4", 1022, 392);
        Wezel A3 = new Wezel("A3", 940, 393);
        Wezel A5 = new Wezel("A5", 729, 279);
        Wezel A1_brama = new Wezel("A1", 701, 375);
        Wezel A4 = new Wezel("A4", 860, 398);
        Wezel SKS = new Wezel("SKS", 259, 277);
        Wezel C2_norwida = new Wezel("C2_norwida", 687, 298);
        Wezel C6 = new Wezel("C6", 633, 352);
        Wezel pomnik_ogrod = new Wezel("pomnik_ogrod", 620, 311);
        Wezel C6_przejscie = new Wezel("C6_przejscie", 534, 335);
        Wezel C15 = new Wezel("C15", 534, 297);
        Wezel C3 = new Wezel("C3", 600, 264);
        Wezel C1 = new Wezel("C1", 602, 229);
        Wezel C2 = new Wezel("C2", 633, 255);
        Wezel C11 = new Wezel("C11", 650, 200);
        Wezel C16_jan = new Wezel("C16", 516, 169);
        Wezel C16_kampus = new Wezel("C16", 506, 195);
        Wezel D20 = new Wezel("D20", 517, 60);
        Wezel C5 = new Wezel("C5", 452, 214);
        Wezel pomnik_prof = new Wezel("pomnik_prof", 449, 282);
        Wezel D1_droga = new Wezel("D1_droga", 430, 162);
        Wezel D21_droga = new Wezel("D21_droga", 364, 200);
        Wezel D1 = new Wezel("D1", 401, 123);
        Wezel D21 = new Wezel("D21", 355, 165);
        Wezel D2 = new Wezel("D2", 341, 133);

        B1_wysp.dodaj_sasiada(A2, 40);
        B1_wysp.dodaj_sasiada(B1_smol, 90);
        B1_smol.dodaj_sasiada(B4, 30);
        B1_smol.dodaj_sasiada(A2, 100);
        B1_smol.dodaj_sasiada(A3, 50);
        A2.dodaj_sasiada(A3, 120);
        A2.dodaj_sasiada(A1_glowne, 130);
        A1_glowne.dodaj_sasiada(wysp_norwida, 50);
        wysp_norwida.dodaj_sasiada(C13_wyspianskiego, 130);
        C13_wyspianskiego.dodaj_sasiada(polinka, 70);
        C13_patio_portiernia.dodaj_sasiada(C13_wyspianskiego, 20);
        C13_patio_portiernia.dodaj_sasiada(C13_schodki, 80);
        C13_schodki.dodaj_sasiada(wysp_norwida, 80);
        wysp_norwida.dodaj_sasiada(A1_brama, 100);
        A3.dodaj_sasiada(A5, 180);
        A5.dodaj_sasiada(A1_brama, 70);
        A1_brama.dodaj_sasiada(C13_schodki, 100);
        C13_schodki.dodaj_sasiada(C6, 100);
        wysp_norwida.dodaj_sasiada(C6, 140);
        A1_brama.dodaj_sasiada(C6, 50);
        polinka.dodaj_sasiada(C8, 120);
        C8.dodaj_sasiada(C13_patio, 60);
        C13_patio.dodaj_sasiada(C13_patio_portiernia, 60);
        C13_patio.dodaj_sasiada(C6_przejscie, 70);
        C6_przejscie.dodaj_sasiada(pomnik_ogrod, 70);
        C6_przejscie.dodaj_sasiada(C15, 40);
        C15.dodaj_sasiada(pomnik_ogrod, 70);
        pomnik_ogrod.dodaj_sasiada(C6, 40);
        pomnik_ogrod.dodaj_sasiada(C2_norwida, 60);
        C6.dodaj_sasiada(C2_norwida, 80);
        A5.dodaj_sasiada(C2_norwida, 30);
        C8.dodaj_sasiada(C6_przejscie, 120);
        C6_przejscie.dodaj_sasiada(pomnik_prof, 80);
        C8.dodaj_sasiada(pomnik_prof, 100);
        C13_patio.dodaj_sasiada(pomnik_prof, 100);
        A5.dodaj_sasiada(C11, 100);
        A5.dodaj_sasiada(C1, 120);
        C1.dodaj_sasiada(C11, 60);
        C1.dodaj_sasiada(C16_jan, 100);
        C16_jan.dodaj_sasiada(C11, 120);
        C1.dodaj_sasiada(C2, 30);
        C1.dodaj_sasiada(C3, 30);
        C3.dodaj_sasiada(C2_norwida, 70);
        C3.dodaj_sasiada(pomnik_ogrod, 40);
        C1.dodaj_sasiada(C16_kampus, 90);
        C3.dodaj_sasiada(C16_kampus, 90);
        C16_jan.dodaj_sasiada(D20, 90);
        C16_jan.dodaj_sasiada(D1_droga, 60);
        C16_kampus.dodaj_sasiada(D1_droga, 60);
        C16_kampus.dodaj_sasiada(C5, 50);
        D1_droga.dodaj_sasiada(D20, 100);
        D1_droga.dodaj_sasiada(D1, 50);
        D1_droga.dodaj_sasiada(C5, 30);
        pomnik_prof.dodaj_sasiada(C5, 50);
        pomnik_prof.dodaj_sasiada(D21_droga, 80);
        D21_droga.dodaj_sasiada(SKS, 100);
        D21_droga.dodaj_sasiada(C5, 70);
        C5.dodaj_sasiada(D21, 80);
        D21_droga.dodaj_sasiada(D21, 40);
        D21.dodaj_sasiada(D1_droga, 60);
        D21.dodaj_sasiada(D1, 50);
        D21.dodaj_sasiada(D2, 20);
        D1.dodaj_sasiada(D2, 40);


        this.wezly.add(polinka);
        this.wezly.add(C13_wyspianskiego);
        this.wezly.add(C13_patio);
        this.wezly.add(C13_schodki);
        this.wezly.add(C13_patio_portiernia);
        this.wezly.add(C8);
        this.wezly.add(wysp_norwida);
        this.wezly.add(A1_glowne);
        this.wezly.add(A2);
        this.wezly.add(B1_wysp);
        this.wezly.add(B1_smol);
        this.wezly.add(B4);
        this.wezly.add(A3);
        this.wezly.add(A5);
        this.wezly.add(A1_brama);
        this.wezly.add(A4);
        this.wezly.add(SKS);
        this.wezly.add(C2_norwida);
        this.wezly.add(C6);
        this.wezly.add(pomnik_ogrod);
        this.wezly.add(C6_przejscie);
        this.wezly.add(C15);
        this.wezly.add(C3);
        this.wezly.add(C1);
        this.wezly.add(C2);
        this.wezly.add(C11);
        this.wezly.add(C16_jan);
        this.wezly.add(C16_kampus);
        this.wezly.add(D20);
        this.wezly.add(C5);
        this.wezly.add(pomnik_prof);
        this.wezly.add(D1_droga);
        this.wezly.add(D21_droga);
        this.wezly.add(D1);
        this.wezly.add(D21);
        this.wezly.add(D2);
    }

    public ArrayList<Wezel> znajdzDroge(String poczatek, String cel)
    {
        Dijkstra dikstraPom = new Dijkstra(null, null, null);
        this.dlugosc = Integer.MAX_VALUE;
        this.droga();
        this.cel.clear();
        this.zrodlo.clear();
        for(Wezel wezel:this.wezly)
        {
            if(wezel.getNazwa().equals(poczatek)){
                this.zrodlo.add(wezel);
            }
            if(wezel.getNazwa().equals(cel)){
                this.cel.add(wezel);
            }
        }
        for(Wezel wezel:this.zrodlo){
            for (Wezel wezel1:this.cel){
                dikstraPom = new Dijkstra(this.wezly, wezel, wezel1);
                dikstraPom.dijkstra_algo();
                if(dikstraPom.getCel().getOdleglosc_od_zrodla()<this.dlugosc){
                    this.droga.clear();
                    this.dlugosc = dikstraPom.getCel().getOdleglosc_od_zrodla();
                    this.droga.addAll(dikstraPom.getDroga());
                }
            }
        }
        return this.droga;
    }
}