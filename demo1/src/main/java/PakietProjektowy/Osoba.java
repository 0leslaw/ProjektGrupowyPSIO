package PakietProjektowy;

import java.io.Serializable;

public abstract class Osoba implements Serializable {
    protected String imie;
    protected String drugie_imie;
    protected String nazwisko;
    protected String email;

    public Osoba(String imie, String drugie_imie, String nazwisko, String email) {
        this.imie = imie;
        this.drugie_imie = drugie_imie;
        this.nazwisko = nazwisko;
        this.email = email;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getDrugie_imie() {
        return drugie_imie;
    }

    public void setDrugie_imie(String drugie_imie) {
        this.drugie_imie = drugie_imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", drugie_imie='" + drugie_imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
