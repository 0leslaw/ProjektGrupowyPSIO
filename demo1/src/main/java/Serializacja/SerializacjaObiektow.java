package Serializacja;

import Obserwowani.Kalendarz;
import Obserwowani.TablicaOgloszen;
import PakietKursy.Kursy;
import Uzytkownicy.Administrator;
import Uzytkownicy.Pracownik;
import Uzytkownicy.Samorzad;
import Uzytkownicy.Student;
import java.io.*;
import java.util.ArrayList;

public class SerializacjaObiektow {

    //Odczyt i zapis arraylist

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

    public static void zapisKalendarza(Kalendarz kalendarz, String nazwapliku)throws IOException {
        ObjectOutputStream pl=null;
        try{
            pl=new ObjectOutputStream(new FileOutputStream(nazwapliku));
            pl.writeObject(kalendarz);
            pl.flush();
        }
        finally{
            if(pl!=null)
                pl.close();
        }
    }

    public static Kalendarz odczytKalendarz()throws IOException,ClassNotFoundException {

        ObjectInputStream pl2 = null;
        Kalendarz kalendarz = null;
        try {
            if (new File("Kalendarz.ser").length() > 0) {
                pl2 = new ObjectInputStream(new FileInputStream("Kalendarz.ser"));
                kalendarz = (Kalendarz) pl2.readObject();
            }

        } catch (EOFException ex) {
        } finally {
            if (pl2 != null)
                pl2.close();
        }
        return kalendarz;
    }

    public static void zapisTablicyOgloszen(TablicaOgloszen tablica, String nazwapliku)throws IOException {
        ObjectOutputStream pl=null;
        try{
            pl=new ObjectOutputStream(new FileOutputStream(nazwapliku));
            pl.writeObject(tablica);
            pl.flush();
        }
        finally{
            if(pl!=null)
                pl.close();
        }
    }

    public static TablicaOgloszen odczytTablicyOgloszen()throws IOException,ClassNotFoundException {

        ObjectInputStream pl2 = null;
        TablicaOgloszen tablica = null;
        try {
            if (new File("TablicaOgloszen.ser").length() > 0) {
                pl2 = new ObjectInputStream(new FileInputStream("TablicaOgloszen.ser"));
                tablica = (TablicaOgloszen) pl2.readObject();
            }

        } catch (EOFException ex) {
        } finally {
            if (pl2 != null)
                pl2.close();
        }
        return tablica;
    }
    public static void zapisSamorzad(ArrayList<Samorzad> lista_osob, String nazwapliku)throws IOException {
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

    public static ArrayList<Samorzad> odczytSamorzad()throws IOException,ClassNotFoundException{

        ObjectInputStream pl2 = null;
        ArrayList<Samorzad> lista_osob = new ArrayList<>();
        try{
            if(new File("PlikSamorzadu.ser").length() >0) {
                pl2 = new ObjectInputStream(new FileInputStream("PlikSamorzadu.ser"));
                lista_osob.addAll((ArrayList<Samorzad>) pl2.readObject());
            }
        } catch (EOFException ex) {}

        finally{
            if(pl2!=null)
                pl2.close();
        }
        return lista_osob;
    }

    public static void zapisProwadzacych(ArrayList<Pracownik> lista_osob, String nazwapliku)throws IOException {
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

    public static ArrayList<Pracownik> odczytProwadzacych()throws IOException,ClassNotFoundException{

        ObjectInputStream pl2 = null;
        ArrayList<Pracownik> lista_osob = new ArrayList<>();
        try{
            if(new File("PlikPracownikow.ser").length() >0) {
                pl2 = new ObjectInputStream(new FileInputStream("PlikPracownikow.ser"));
                lista_osob.addAll((ArrayList<Pracownik>) pl2.readObject());
            }
        } catch (EOFException ex) {}

        finally{
            if(pl2!=null)
                pl2.close();
        }
        return lista_osob;
    }

    public static void zapisAdminow(ArrayList<Administrator> lista_osob, String nazwapliku)throws IOException {
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

    public static ArrayList<Administrator> odczytAdminow()throws IOException,ClassNotFoundException{

        ObjectInputStream pl2 = null;
        ArrayList<Administrator> lista_osob = new ArrayList<>();
        try{
            if(new File("PlikAdminow.ser").length() >0) {
                pl2 = new ObjectInputStream(new FileInputStream("PlikAdminow.ser"));
                lista_osob.addAll((ArrayList<Administrator>) pl2.readObject());
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
}
