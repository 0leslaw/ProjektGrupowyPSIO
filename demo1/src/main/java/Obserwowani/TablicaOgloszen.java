package Obserwowani;

import Obseratorzy.Obserwator;
import Ogłoszenia.Ogloszenie;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class TablicaOgloszen implements Obserwowany, Serializable {

    ArrayList<Obserwator> lista_obserwatorow = new ArrayList<>();
    ArrayList<Ogloszenie> ogloszenia = new ArrayList<>();

    public TablicaOgloszen(ArrayList<Ogloszenie> ogloszenia){
        this.ogloszenia = ogloszenia;
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
            lista_obserwatorow.get(i).uaktualnijOgloszenia();
        }
    }

    public void dodajOgloszenieDoTablicy(Ogloszenie ogloszenie) throws IOException, ClassNotFoundException {
        ogloszenia.add(ogloszenie);
        powiadomObserwatorow();
    }

    public ArrayList<Ogloszenie> getOgloszenia(){
        return ogloszenia;
    }
}
