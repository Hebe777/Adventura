package start;

import Logika.Hra;
import UI.TextUI;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Hra h = new Hra();
        TextUI ui = new TextUI(h);

        ui.hraj();
    }
}