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
