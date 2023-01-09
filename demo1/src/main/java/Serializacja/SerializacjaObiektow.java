package Serializacja;

import PakietKursy.Kursy;
import Uzytkownicy.Osoba;
import Uzytkownicy.Student;
import Uzytkownicy.Uzytkownik;

import java.io.*;
import java.util.ArrayList;

public class SerializacjaObiektow {
//Odczyt i zapis arraylist

    //osob
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

    public static ArrayList<Student> odczytStudentow(String nazwaPl)throws IOException,ClassNotFoundException{

        ObjectInputStream pl2 = null;
        ArrayList<Student> lista_osob = null;
        try{
            pl2 = new ObjectInputStream(new FileInputStream(nazwaPl));
            lista_osob = (ArrayList<Student>) pl2.readObject();



        } catch (EOFException ex) {
//            System.out.println("Koniec pliku");
        }

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
//logowanie
    public static boolean sprawdzPoprawnoscLoginu(String nazwa_pliku,String login) throws IOException, ClassNotFoundException {

        ArrayList<Uzytkownik> lista_osob = odczytUzytkownikow(nazwa_pliku);

        boolean czy_poprawny_login = false;
        for (int i = 0; i < lista_osob.size(); i++) {
            if ((lista_osob.get(i).getLogin()).equals(login))
                czy_poprawny_login = true;
        }
        return czy_poprawny_login;
    }

    public static boolean sprawdzPoprawnoscHasla(String nazwa_pliku,String haslo) throws IOException, ClassNotFoundException {

        ArrayList<Uzytkownik> lista_osob = odczytUzytkownikow(nazwa_pliku);

        boolean czy_poprawne_haslo = false;
        for(int i=0; i<lista_osob.size(); i++)
            if((lista_osob.get(i).getHaslo()).equals(haslo))
                czy_poprawne_haslo = true;

        return czy_poprawne_haslo;
    }



}
