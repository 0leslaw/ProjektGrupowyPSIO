package Menu;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Menu {

    private ArrayList<Danie> menu;

    public Menu(ArrayList<Danie> menu) {
        this.menu = menu;
    }

    public Danie jakieDanie() {
        if(LocalDateTime.now().getDayOfWeek().getValue()<6)
        {
            return this.menu.get(LocalDateTime.now().getDayOfWeek().getValue()-1);
        }else{
            return null;
        }
    }
}
