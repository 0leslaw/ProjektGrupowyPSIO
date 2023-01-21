package Mapa;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
    public ArrayList<Wezel> getWezly() {
        return wezly;
    }

    public void setWezly(ArrayList<Wezel> wezly) {
        this.wezly = wezly;
    }

    private ArrayList<Wezel> wezly;
    private Wezel zrodlo;
    private Wezel cel;
    private PriorityQueue<Wezel> pq;

    private Wezel wezelPom = new Wezel("Pom", 0, 0);

    private ArrayList<Wezel> listPom;

    public Dijkstra(ArrayList<Wezel> wezly, Wezel zrodlo, Wezel cel) {
        this.wezly = new ArrayList<Wezel>();
        this.wezly = wezly;
        this.zrodlo = zrodlo;
        this.cel = cel;
        this.pq = new PriorityQueue<Wezel>();
        this.listPom = new ArrayList<Wezel>();
    }

    public void stanPoczatkowy() {
        for (Wezel wezel : wezly) {
            wezel.setOdleglosc_od_zrodla(Integer.MAX_VALUE);
            wezel.wyzerojOdwiedzone();
        }
        zrodlo.setOdleglosc_od_zrodla(0);
        zrodlo.wyzerojOdwiedzone();

        for (Wezel wezel : wezly) {
            pq.add(wezel);
        }

        for (Wezel wezel : wezly) {
            wezel.dodaj_odwiedzony(zrodlo);
        }
    }

    public void naprawPQ() {
        this.listPom.clear();
        for (Wezel wezel : pq) {
            listPom.add(wezel);
        }
        pq.clear();
        for (Wezel wezel : listPom) {
            pq.add(wezel);
        }
    }

    public void eksplorujWezel(Wezel eksplorowany_wezel) {
        for (Wezel sasiad : eksplorowany_wezel.getSasiednie_wezly()) {
            if (pq.contains(sasiad)) {
                if (eksplorowany_wezel.getOdleglosc_od_zrodla() + eksplorowany_wezel.getOdleglosci().get(eksplorowany_wezel.getSasiednie_wezly().indexOf(sasiad)) < sasiad.getOdleglosc_od_zrodla()) {
                    sasiad.setOdleglosc_od_zrodla(eksplorowany_wezel.getOdleglosc_od_zrodla() + eksplorowany_wezel.getOdleglosci().get(eksplorowany_wezel.getSasiednie_wezly().indexOf(sasiad)));
                    sasiad.wyzerojOdwiedzone();
                    for (Wezel wezel : eksplorowany_wezel.getOdwiedzone_wezly()) {
                        sasiad.dodaj_odwiedzony(wezel);
                    }
                    sasiad.dodaj_odwiedzony(eksplorowany_wezel);
                }
            }
        }
        if (eksplorowany_wezel == cel) {
            cel.dodaj_odwiedzony(cel);
        }
    }

    public ArrayList<Wezel> getDroga() {
        return cel.getOdwiedzone_wezly();
    }

    public void dijkstra_algo() {
        stanPoczatkowy();

        while (pq.contains(cel)) {
            wezelPom = pq.poll();
            eksplorujWezel(wezelPom);
            naprawPQ();
        }
    }

    public Wezel getCel() {
        return cel;
    }

    public PriorityQueue<Wezel> getPq() {
        return pq;
    }
}

