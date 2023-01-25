package Obseratorzy;
import Obserwowani.Obserwowany;
import PakietWydarzenie.Wydarzenie;

import java.io.IOException;

public interface Obserwator {
    public void uaktualnijWydarzenia(String s) throws IOException, ClassNotFoundException;

    public void uaktualnijOgloszenia(String s) throws IOException, ClassNotFoundException;
}
