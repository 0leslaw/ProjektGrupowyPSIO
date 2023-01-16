package Serializacja;

import Ogłoszenia.Ogloszenie;
import PakietKursy.Kursy;
import PakietWydarzenie.Wydarzenie;
import Uzytkownicy.Osoba;
import Uzytkownicy.Student;
import Uzytkownicy.Uzytkownik;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class SerializacjaObiektow {

    //Odczyt i zapis arraylist

    public static ArrayList<Ogloszenie> odczytOgloszen()throws IOException,ClassNotFoundException{

        ObjectInputStream pl2 = null;
        ArrayList<Ogloszenie> lista_ogloszen = new ArrayList<>();
        try{
            if(new File("PlikOgloszen.ser").length() >0) {
                pl2 = new ObjectInputStream(new FileInputStream("PlikOgloszen.ser"));
                lista_ogloszen.addAll((ArrayList<Ogloszenie>) pl2.readObject());
            }

        } catch (EOFException ex) {}

        finally{
            if(pl2!=null)
                pl2.close();
        }
        return lista_ogloszen;
    }
    public static void zapisOgloszenia(ArrayList<Ogloszenie> lista_ogloszen, String nazwapliku)throws IOException {
        ObjectOutputStream pl=null;
        try{
            pl=new ObjectOutputStream(new FileOutputStream(nazwapliku));
            pl.writeObject(lista_ogloszen);
            pl.flush();
        }
        finally{
            if(pl!=null)
                pl.close();
        }
    }

    public static ArrayList<Wydarzenie> odczytWydarzen()throws IOException,ClassNotFoundException{

        ObjectInputStream pl2 = null;
        ArrayList<Wydarzenie> lista_wydarzen = new ArrayList<>();
        try{
            if(new File("PlikWydarzen.ser").length() >0) {
                pl2 = new ObjectInputStream(new FileInputStream("PlikWydarzen.ser"));
                lista_wydarzen.addAll((ArrayList<Wydarzenie>) pl2.readObject());
            }

        } catch (EOFException ex) {}

        finally{
            if(pl2!=null)
                pl2.close();
        }
        return lista_wydarzen;
    }

    public static void zapisWydarzen(ArrayList<Wydarzenie> lista_wydarzen, String nazwapliku)throws IOException {
        ObjectOutputStream pl=null;
        try{
            pl=new ObjectOutputStream(new FileOutputStream(nazwapliku));
            pl.writeObject(lista_wydarzen);
            pl.flush();
        }
        finally{
            if(pl!=null)
                pl.close();
        }
    }

    public static <T> ArrayList<T> odczytDowolnejArrayListy(String nazwapliku) throws IOException, ClassNotFoundException {
        ObjectInputStream pl2=null;
        ArrayList<T> lista_T = null;
        try{
            pl2=new ObjectInputStream(new FileInputStream(nazwapliku));
            lista_T=(ArrayList<T>) pl2.readObject();

        } catch (EOFException ex) {
//            System.out.println("Koniec pliku");
        }

        finally{
            if(pl2!=null)
                pl2.close();
        }
        return lista_T;
    }

    public static <T> void zapisDowolnejArrayListy(ArrayList<T> lista_T, String nazwapliku)throws IOException {
        ObjectOutputStream pl=null;
        try{
            pl=new ObjectOutputStream(new FileOutputStream(nazwapliku));
            pl.writeObject(lista_T);
            pl.flush();
        }
        finally{
            if(pl!=null)
                pl.close();
        }
    }

    public static void zapisUzytkownikow(ArrayList<Uzytkownik> lista_osob, String nazwapliku)throws IOException {
        ObjectOutputStream pl=null;
        try{
            pl=new ObjectOutputStream(new FileOutputStream(nazwapliku));
            pl.writeObject(lista_osob);
            pl.flush();
        }
        finally{
            if(pl!=null)
                pl.close();
        }
    }

    public static ArrayList<Uzytkownik> odczytUzytkownikow(String nazwaPl)throws IOException,ClassNotFoundException{

        ObjectInputStream pl2=null;
        ArrayList<Uzytkownik> lista_osob = null;
        try{
            pl2=new ObjectInputStream(new FileInputStream(nazwaPl));
            lista_osob=(ArrayList<Uzytkownik>) pl2.readObject();



        } catch (EOFException ex) {
//            System.out.println("Koniec pliku");
        }

        finally{
            if(pl2!=null)
                pl2.close();
        }
        return lista_osob;
    }

    public static void zapisStudentow(ArrayList<Student> lista_osob, String nazwapliku)throws IOException {
        ObjectOutputStream pl = null;
        try{
            pl=new ObjectOutputStream(new FileOutputStream(nazwapliku));
            pl.writeObject(lista_osob);
            pl.flush();
        }
        finally{
            if(pl!=null)
                pl.close();
        }
    }

    public static ArrayList<Student> odczytStudentow()throws IOException,ClassNotFoundException{

        ObjectInputStream pl2 = null;
        ArrayList<Student> lista_osob = new ArrayList<>();
        try{
            if(new File("PlikStudentow.ser").length() >0) {
                pl2 = new ObjectInputStream(new FileInputStream("PlikStudentow.ser"));
                lista_osob.addAll((ArrayList<Student>) pl2.readObject());
            }

        } catch (EOFException ex) {}

        finally{
            if(pl2!=null)
                pl2.close();
        }
        return lista_osob;
    }

    //kursow
    public static void zapisKursow(ArrayList<Kursy> lista_kursow, String nazwapliku)throws IOException {
        ObjectOutputStream pl=null;
        try{
            pl=new ObjectOutputStream(new FileOutputStream(nazwapliku));
            pl.writeObject(lista_kursow);
            pl.flush();
        }
        finally{
            if(pl!=null)
                pl.close();
        }
    }

    public static ArrayList<Kursy> odczytKursow(String nazwaPl)throws IOException,ClassNotFoundException{

        ObjectInputStream pl2 = null;
        ArrayList<Kursy> lista_kursy = null;
        try{
            pl2 = new ObjectInputStream(new FileInputStream(nazwaPl));
            lista_kursy=(ArrayList<Kursy>) pl2.readObject();



        } catch (EOFException ex) {
//            System.out.println("Koniec pliku");
        }

        finally{
            if(pl2!=null)
                pl2.close();
        }
        return lista_kursy;
    }

    public static int znajdzIndeksObiektuWLiscie(ArrayList<Object> lista_obiektow, Object objekt){
        int temp = -1;
        for (int i = 0; i < lista_obiektow.size(); i++) {
            if(lista_obiektow.get(i).equals(objekt))
                temp = i;
        }
        return temp;
    }

    public static void wypiszOsobyZlisty(ArrayList<Osoba> lista_osob){

        for(int i=0;i< lista_osob.size();i++)
            System.out.println(lista_osob.get(i).toString()+"\n");
    }

    public static void wypiszStudentowZlisty(ArrayList<Student> lista_osob){

        for(int i=0;i< lista_osob.size();i++)
            System.out.println(lista_osob.get(i).toString()+"\n");
    }

}
