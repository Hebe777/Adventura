package start;

import Logika.Hra;
import UI.TextUI;

/**
 * Třída Main obsahuje hlavní metodu pro spuštění hry.
 * Inicializuje hru a uživatelské rozhraní, poté spouští hru.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class Main {
    public static void main(String[] args) {
        Hra h = new Hra();
        TextUI ui = new TextUI(h);

        ui.hraj();
    }
}