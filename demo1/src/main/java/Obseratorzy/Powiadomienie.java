package Obseratorzy;

import Obserwowani.Obserwowany;
import Uzytkownicy.Student;
import PakietWydarzenie.Wydarzenie;
import Serializacja.SerializacjaObiektow;

import java.io.IOException;
import java.util.ArrayList;

public class Powiadomienie implements Obserwator{
    private Wydarzenie nowe_wydarzenie;
    private Obserwowany kalendarz;

    public Powiadomienie(Obserwowany kalendarz){
        this.kalendarz = kalendarz;
        this.kalendarz.zarejestrujObserwatora(this);
    }
    @Override
    public void uaktualnijDane(Wydarzenie nowe_wydarzenie) throws IOException, ClassNotFoundException {
        this.nowe_wydarzenie = nowe_wydarzenie;
        wyslijPowiadomienie();
    }
    public void wyslijPowiadomienie() throws IOException, ClassNotFoundException {
        // napisac metode wysylajaca powiadomienie
        ArrayList<Student> lista_studentow = null;
        lista_studentow = SerializacjaObiektow.odczytStudentow("plikStudentow.ser");

        for(int i = 0; i< lista_studentow.size(); i++) {
            wyslijEmail(lista_studentow.get(i).getEmail());
            Student student = lista_studentow.get(i);
            student.setLiczba_nowych_powiadomien(lista_studentow.get(i).getLiczba_nowych_powiadomien()+1);
            lista_studentow.set(i,student);
        }
        SerializacjaObiektow.zapisStudentow(lista_studentow,"PlikStudentow.ser");
    }
    public void wyslijEmail(String adresat){

    }
}
