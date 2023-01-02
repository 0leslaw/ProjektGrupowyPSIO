package Mapa;

import org.w3c.dom.Node;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Wezel implements Comparable<Wezel>, Serializable
{
    private String nazwa;
    private ArrayList<Integer> odleglosci;
    private ArrayList<Wezel> sasiednie_wezly;
    private int odleglosc_od_zrodla;
    private ArrayList<Wezel> odwiedzone_wezly;

    public Wezel(String nazwa){
        this.nazwa = nazwa;
        this.odleglosci = new ArrayList<Integer>();
        this.sasiednie_wezly = new ArrayList<Wezel>();
        this.odwiedzone_wezly = new ArrayList<Wezel>();
    }

    public void dodaj_sasiada(Wezel dodany_wezel, int odleglosc){ // w druga strone dodajemy recznie
        odleglosci.add(odleglosc);
        sasiednie_wezly.add(dodany_wezel);
        if(!dodany_wezel.getSasiednie_wezly().contains(this))
        {
            dodany_wezel.dodaj_sasiada(this, odleglosc);
        }
    }

    public void usun_sasiada(Wezel usuniety_wezel){
       int indeks =sasiednie_wezly.indexOf(usuniety_wezel);
        sasiednie_wezly.remove(usuniety_wezel);
        odleglosci.remove(odleglosci.get(indeks));
    }

    public void dodaj_odwiedzony(Wezel odwiedzony_wezel){
        if(!odwiedzone_wezly.contains(odwiedzony_wezel)) {
            odwiedzone_wezly.add(odwiedzony_wezel);
        }
    }

    public void usun_odwiedzony(Wezel odwiedzony_wezel)
    {
        odwiedzone_wezly.remove(odwiedzony_wezel);
    }

    public int compareTo(Wezel wezel1){
        if(wezel1.getOdleglosc_od_zrodla() > this.getOdleglosc_od_zrodla())
            return -1;

        if(wezel1.getOdleglosc_od_zrodla() < this.getOdleglosc_od_zrodla())
            return 1;

        return 0;
    }
    public int getOdleglosc_od_zrodla() {
        return odleglosc_od_zrodla;
    }

    public void setOdleglosc_od_zrodla(int odleglosc_od_zrodla) {
        this.odleglosc_od_zrodla = odleglosc_od_zrodla;
    }

    public void wyzerojOdwiedzone(){
        this.odwiedzone_wezly.clear();
    }
    public String getNazwa() {
        return nazwa;
    }

    public ArrayList<Integer> getOdleglosci() {
        return odleglosci;
    }

    public void setOdleglosci(ArrayList<Integer> odleglosci) {
        this.odleglosci = odleglosci;
    }

    public ArrayList<Wezel> getSasiednie_wezly() {
        return sasiednie_wezly;
    }

    public void setSasiednie_wezly(ArrayList<Wezel> sasiednie_wezly) {
        this.sasiednie_wezly = sasiednie_wezly;
    }

    public ArrayList<Wezel> getOdwiedzone_wezly() {
        return odwiedzone_wezly;
    }

    public void setOdwiedzone_wezly(ArrayList<Wezel> odwiedzone_wezly) {
        this.odwiedzone_wezly = odwiedzone_wezly;
    }
}
