package Obseratorzy;

import Obserwowani.Obserwowany;
import Uzytkownicy.Student;
import Serializacja.SerializacjaObiektow;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Powiadomienie implements Obserwator, Serializable {

    private Obserwowany kalendarz;

    public Powiadomienie(Obserwowany kalendarz){
        this.kalendarz = kalendarz;
        this.kalendarz.zarejestrujObserwatora(this);
    }
//    @Override
//    public void uaktualnijDane(Wydarzenie nowe_wydarzenie) throws IOException, ClassNotFoundException {
//        this.nowe_wydarzenie = nowe_wydarzenie;
//        wyslijPowiadomienie();
//    }
//    public void wyslijPowiadomienie() throws IOException, ClassNotFoundException {
//        // napisac metode wysylajaca powiadomienie
//        ArrayList<Student> lista_studentow = null;
//        lista_studentow = SerializacjaObiektow.odczytStudentow();
//
//        for(int i = 0; i< lista_studentow.size(); i++) {
//            wyslijEmail(lista_studentow.get(i).getEmail());
//            Student student = lista_studentow.get(i);
//            student.setLiczba_nowych_powiadomien(lista_studentow.get(i).getLiczba_nowych_powiadomien()+1);
//            lista_studentow.set(i,student);
//        }
//        SerializacjaObiektow.zapisStudentow(lista_studentow,"PlikStudentow.ser");
//    }
    public void wyslijEmail(String adresat){

    }

    public void uaktualnijWydarzenia() throws IOException, ClassNotFoundException {
        ArrayList<Student> studenci = SerializacjaObiektow.odczytStudentow();
        for(Student student: studenci){
            if(student.isPowiadomienia()){
                student.setLiczba_nowych_wydarzen(student.getLiczba_nowych_wydarzen()+1);
            }
        }
        SerializacjaObiektow.zapisStudentow(studenci, "PlikStudentow.ser");
    }

    @Override
    public void uaktualnijOgloszenia() throws IOException, ClassNotFoundException {
        ArrayList<Student> studenci = SerializacjaObiektow.odczytStudentow();
        for(Student student: studenci){
            if(student.isPowiadomienia()){
                student.setLiczba_nowych_ogloszen(student.getLiczba_nowych_ogloszen()+1);
            }
        }
        SerializacjaObiektow.zapisStudentow(studenci, "PlikStudentow.ser");
    }
}
