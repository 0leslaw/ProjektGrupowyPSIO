package Ocena;

import PakietProjektowy.Student;

public class Ocena {
    private Student student;
    private double ocena;
    private String opinia;

    public Ocena(Student student, double ocena, String opinia)
    {
        this.student = student;
        this.ocena = ocena;
        this.opinia = opinia;
    }
}
