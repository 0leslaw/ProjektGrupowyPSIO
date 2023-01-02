package Obserwowani;

import Obseratorzy.Obserwator;

import java.io.IOException;

public interface Obserwowany {
    public void zarejestrujObserwatora(Obserwator obserwator);
    public void usunObserwatora(Obserwator obserwator);
    public void powiadomObserwatorow() throws IOException, ClassNotFoundException;
}
