package Obseratorzy;
import Obserwowani.Obserwowany;
import PakietWydarzenie.Wydarzenie;

import java.io.IOException;

public interface Obserwator {
    public void uaktualnijDane(Wydarzenie nowe_wydarzenie) throws IOException, ClassNotFoundException;
}
