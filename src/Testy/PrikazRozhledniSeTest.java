package Testy;

import Logika.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Třída PrikazRozhledniSeTest testuje funkčnost třídy PrikazRozhledniSe.
 *
 * Testuje se provedení příkazu "rozhledni_se" a ověřuje, že se správně vypíše popis aktuální lokace.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazRozhledniSeTest {
    private Hra hra;
    private PrikazRozhledniSe prikazRozhledniSe;
    private Lokace kuchyne;
    private Lokace zahrada;
    private Predmet jablko;
    private Postava postava;

    /**
     * Nastavení výchozího stavu před každým testem.
     * Inicializuje hru, příkaz "rozhledni_se", lokace, předmět a postavu.
     */
    @BeforeEach
    public void setUp() {
        hra = new Hra();
        prikazRozhledniSe = new PrikazRozhledniSe(hra);
        kuchyne = new Lokace("kuchyn", "Jste v kuchyni");
        zahrada = new Lokace("zahrada", "Jste v zahrade");
        jablko = new Predmet("jablko", true);
        postava = new Postava("Karel", "Ahoj, jsem Karel");
        hra.getHerniSvet().setAktualniLokace(kuchyne);
        kuchyne.pridejPredmet(jablko);
        kuchyne.pridejVychod(zahrada);
        kuchyne.pridejPostavu(postava);
    }

    /**
     * Testuje provedení příkazu "rozhledni_se".
     * Ověřuje, že příkaz vrátí správný popis aktuální lokace.
     */
    @Test
    public void testProved() {
        String vysledek = prikazRozhledniSe.proved(new String[]{});
        assertEquals(hra.getHerniSvet().getAktualniLokace().getPopis(), vysledek);
    }
}