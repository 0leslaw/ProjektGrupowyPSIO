//package PakietTestowy;
//
//import Obseratorzy.Powiadomienie;
//import Obserwowani.Kalendarz;
//import PakietProjektowy.Osoba;
//import PakietProjektowy.Pracownik;
//import PakietProjektowy.Student;
//import PakietWydarzenie.Wydarzenie;
//import Serializacja.SerializacjaObiektow;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Random;
//
//public class TestKalendarzaiPowiadomien {
//    public static void Test1() throws IOException, ClassNotFoundException {
//        Student student = new Student("Macius","Piotr","Kowalski","d","dw","dw",
//                3,"dd","cdd",0);
//        Student student2 = new Student("Amadeusz","Pawel","Nowak","d","dw","dw",
//                3,"dd","cdd",0);
//        ArrayList<Osoba> students = new ArrayList<>();
//        students.add(student);
//        students.add(student2);
//
////        Serializacja.SerializacjaObiektow.zapisOsob(students,"PlikStudentow.ser");
//
//        Pracownik pracownik1 = new Pracownik("ciur","","dupa","d","dw","dw",
//                "cd","dd","cdd");
//        Pracownik pracownik2 = new Pracownik("ngoc","Ibrahimovic","Nguyen","d","dw","dw",
//                "cd","dd","cdd");
//
////        Kalendarz kalendarz = new Kalendarz();
//
//        Wydarzenie wydarzenie = new Wydarzenie("Skok z wieży widokowej",
//                LocalDateTime.of(2023,1,1,17,0),pracownik1,"no opis oppis opis opi" +
//                "sisko i tak dalej no skok z wierzy widokowej");
//        Wydarzenie wydarzenie2 = new Wydarzenie("Skok z wieży w bukowcu",
//                LocalDateTime.of(2023,1,1,15,0),pracownik2,"no bedzie sie dzialo");
//

//        Powiadomienie powiadomienie = new Powiadomienie(kalendarz);


//        kalendarz.dodajWydarzenieDoKalendarza(wydarzenie);
//        kalendarz.dodajWydarzenieDoKalendarza(wydarzenie2);
//
//
//        LocalDateTime poniedzialek_szukanego_tygodnia = kalendarz.zwracaDateNajbUbieglegoPoniedzialku();
//        poniedzialek_szukanego_tygodnia = poniedzialek_szukanego_tygodnia.plusWeeks(0);
//
//        for(int i=0;i<7;i++) {
//            System.out.println("dodane dni: "+i);
//            for (int j = 0; j < kalendarz.stworzListeWydarzenNaDzien(poniedzialek_szukanego_tygodnia, i).size(); j++)
//                if (kalendarz.stworzListeWydarzenNaDzien(poniedzialek_szukanego_tygodnia, i).size() != 0)
//                    System.out.println(kalendarz.stworzListeWydarzenNaDzien(poniedzialek_szukanego_tygodnia, i).get(j));
//        }
//
//    }
//    public static void dodajRandomStudenta() throws IOException, ClassNotFoundException {
//        ArrayList<Student> studenci = SerializacjaObiektow.odczytStudentow("PlikStudentow.ser");
//        Random random = new Random();
//        Student student = new Student( Integer.toString(random.nextInt(400))+" imie","aoskd","asd","sad",
//                Integer.toString(random.nextInt(10000)), Integer.toString(random.nextInt(10000)),random.nextInt(6),
//                Integer.toString(random.nextInt(10000)),"kierunek",0);
//        studenci.add(student);
//        SerializacjaObiektow.zapisStudentow(studenci,"PlikStudentow.ser");
//    }
//}
