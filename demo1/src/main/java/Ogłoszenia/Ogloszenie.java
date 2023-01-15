package Ogłoszenia;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Ogloszenie implements Comparable<Ogloszenie>, Serializable{

    private String autor;

    private String tytul;

    private String text;

    private LocalDateTime dataDodania;

    public Ogloszenie(String autor, String tytul, String text, LocalDateTime dataDodania){
        this.autor = autor;
        this.tytul = tytul;
        this.text = text;
        this.dataDodania = dataDodania;
    }

    public String getAutor() {
        return autor;
    }

    public String getTytul() {
        return tytul;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDataDodania() {
        return dataDodania;
    }

    @Override
    public int compareTo(Ogloszenie o) {
        if(o.getDataDodania().isAfter(this.getDataDodania()))
            return 1;
        if(o.getDataDodania().isBefore(this.getDataDodania()))
            return -1;
        return 0;
    }
}
