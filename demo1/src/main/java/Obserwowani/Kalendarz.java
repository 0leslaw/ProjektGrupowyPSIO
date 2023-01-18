package Obserwowani;

import Obseratorzy.Obserwator;
import PakietWydarzenie.Wydarzenie;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Kalendarz  implements Obserwowany, Serializable {

    // lista obserwatorow
    ArrayList<Obserwator> lista_obserwatorow = new ArrayList<>();

    // stan obiektu obserwowanego
    private ArrayList<Wydarzenie> lista_wydarzen = new ArrayList<>();

    public Kalendarz(ArrayList<Wydarzenie> lista_wydarzen) {
        this.lista_wydarzen = lista_wydarzen;
    }
    @Override
    public void zarejestrujObserwatora(Obserwator obserwator) {
        lista_obserwatorow.add(obserwator);
    }

    @Override
    public void usunObserwatora(Obserwator obserwator) {
        lista_obserwatorow.remove(obserwator);
    }

    @Override
    public void powiadomObserwatorow() throws IOException, ClassNotFoundException {
        for(int i = 0; i<lista_obserwatorow.size(); i++){
            lista_obserwatorow.get(i).uaktualnijWydarzenia();
        }
    }

    public void dodajWydarzenieDoKalendarza(Wydarzenie nowe_wydarzenie) throws IOException, ClassNotFoundException{
        lista_wydarzen.add(nowe_wydarzenie);
        powiadomObserwatorow();
    }

    public ArrayList<Wydarzenie> stworzListeWydarzenNaDzien(LocalDateTime pierwszy_dzien_szukanego_tygodnia, int przesuniecie_od_poniedzialku) {

        ArrayList<Wydarzenie> lista_wydarzen_na_dzien = new ArrayList<>();

        for(int i = 0;i < lista_wydarzen.size();i++) {
            if (lista_wydarzen.get(i).getData_wydarzenia().toLocalDate().isEqual(pierwszy_dzien_szukanego_tygodnia.toLocalDate().plusDays(przesuniecie_od_poniedzialku))) {
                lista_wydarzen_na_dzien.add(lista_wydarzen.get(i));
            }
        }

        //sortowanie
        if(lista_wydarzen_na_dzien.size()>1) {
            Wydarzenie temp;
            boolean czypos = false;
            while (!czypos) {
                czypos = true;
                for (int i = 0; i < lista_wydarzen_na_dzien.size() - 1; i++) {
                    if (lista_wydarzen_na_dzien.get(i).getData_wydarzenia().isAfter(lista_wydarzen_na_dzien.get(i + 1).getData_wydarzenia())) {
                        temp = lista_wydarzen_na_dzien.get(i);
                        lista_wydarzen_na_dzien.set(i, lista_wydarzen_na_dzien.get(i + 1));
                        lista_wydarzen_na_dzien.set(i + 1, temp);
                        czypos = false;
                    }
                }
            }
        }
        return lista_wydarzen_na_dzien;
    }

    public static LocalDateTime zwracaDateNajbUbieglegoPoniedzialku(LocalDateTime dzien){

        LocalDateTime data_najb_ubieglego_poniedzialku = LocalDateTime.now();
        data_najb_ubieglego_poniedzialku = data_najb_ubieglego_poniedzialku.minusDays(data_najb_ubieglego_poniedzialku.getDayOfWeek().getValue()-1);

        return data_najb_ubieglego_poniedzialku;
    }

    public ArrayList<Wydarzenie> getLista_wydarzen(){
        return this.lista_wydarzen;
    }

}
