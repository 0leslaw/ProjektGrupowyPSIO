package Uzytkownicy;

public abstract class Uzytkownik extends Osoba {

    protected String login;
    protected String haslo;

    public Uzytkownik(String imie, String drugie_imie, String nazwisko, String email, String login, String haslo) {
        super(imie, drugie_imie, nazwisko, email);
        this.login = login;
        this.haslo = haslo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    @Override
    public String toString() {
        return "Uzytkownik{" +
                "haslo='" + haslo + '\'' +
                ", imie='" + imie + '\'' +
                ", drugie_imie='" + drugie_imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
