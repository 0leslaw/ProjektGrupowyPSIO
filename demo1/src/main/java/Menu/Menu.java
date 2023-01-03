package Menu;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Menu {

    private ArrayList<Danie> menu;

    public Menu(ArrayList<Danie> menu) {
        this.menu = menu;
    }

    public String jakieDanie() {
        if(LocalDateTime.now().getDayOfWeek().getValue()<6)
        {
            return this.menu.get(LocalDateTime.now().getDayOfWeek().getValue()-1).toString();
        }else{
            return "Stołówka nieczynna";
        }
    }
}
