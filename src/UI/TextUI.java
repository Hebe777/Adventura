
package UI;

import java.util.*;
import Logika.*;

public class TextUI
{
    private Scanner scanner;
    private Hra hra;

    public TextUI(Hra hra) {
        this.hra = hra;
        this.scanner = new Scanner(System.in);
    }

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
