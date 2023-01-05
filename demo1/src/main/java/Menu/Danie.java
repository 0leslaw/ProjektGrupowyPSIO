package Menu;

public class Danie {

    private String nazwa;
    private double cena;

    public Danie(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String toString() {
        return "Dzisiejsze danie: " + this.nazwa + "\t" + "cena: " + this.cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
