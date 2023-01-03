package Dane;

import Menu.Danie;
import Menu.Menu;

import java.util.ArrayList;

public class Dane {

    public static Menu stworzMenu()
    {
        ArrayList<Danie> dania = new ArrayList<>();
        dania.add(new Danie("schabowy", 30));
        dania.add(new Danie("pierogi", 40));
        dania.add(new Danie("kawa", 45));
        dania.add(new Danie("jabłko", 20));
        dania.add(new Danie("dobra ocena z PSiO", Integer.MAX_VALUE));
        Menu menu = new Menu(dania);
        return menu;
    }
}
