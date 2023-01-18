package Obseratorzy;
import Obserwowani.Obserwowany;
import PakietWydarzenie.Wydarzenie;

import java.io.IOException;

public interface Obserwator {
    public void uaktualnijWydarzenia() throws IOException, ClassNotFoundException;

    public void uaktualnijOgloszenia() throws IOException, ClassNotFoundException;
}
