
package UI;

import java.util.*;
import Logika.*;

/**
 * Třída TextUI poskytuje textové uživatelské rozhraní pro hru.
 * Umožňuje hráči zadávat příkazy a zpracovává jejich výstupy.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class TextUI
{
    private Scanner scanner;
    private Hra hra;

    /**
     * Konstruktor třídy TextUI. Inicializuje textové uživatelské rozhraní s odkazem na aktuální hru.
     *
     * @param hra aktuální instance hry
     */
    public TextUI(Hra hra) {
        this.hra = hra;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Metoda pro spuštění hry. Zobrazuje prolog, zpracovává příkazy hráče a zobrazuje epilog po skončení hry.
     */
    public void hraj(){
        System.out.println(hra.getProlog());
        System.out.println();

        while(!hra.isHraSkoncila()) {
            System.out.print("> ");
            String radekTextu = scanner.nextLine();

            String vysledek = hra.zpracujPrikaz(radekTextu);

            System.out.println(vysledek);
            System.out.println();
        }

        System.out.println(hra.getEpilog());
    }
}
