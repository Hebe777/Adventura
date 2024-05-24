package start;

import Logika.Hra;
import UI.TextUI;


public class Main {
    public static void main(String[] args) {
        Hra h = new Hra();
        TextUI ui = new TextUI(h);

        ui.hraj();
    }
}