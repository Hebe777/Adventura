package Testy;

import Logika.Hra;
import Logika.PrikazSeber;
import Logika.Predmet;
import Logika.Lokace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Třída PrikazSeberTest testuje funkčnost třídy PrikazSeber.
 *
 * Testuje se provedení příkazu "seber" za různých podmínek, jako je chybějící parametr,
 * neznámý předmět, známý předmět a opakované sebrání známého předmětu.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazSeberTest {
    private Hra hra;
    private PrikazSeber prikazSeber;
    private Lokace kuchyne;
    private Predmet jablko;

    /**
     * Nastavení výchozího stavu před každým testem.
     * Inicializuje hru, příkaz "seber", lokace a předmět.
     */
    @BeforeEach
    public void setUp() {
        hra = new Hra();
        prikazSeber = new PrikazSeber(hra);
        kuchyne = new Lokace("kuchyn", "Jste v kuchyni");
        jablko = new Predmet("jablko", true);
        hra.getHerniSvet().setAktualniLokace(kuchyne);
        kuchyne.pridejPredmet(jablko);
    }

    /**
     * Testuje provedení příkazu "seber" bez parametru.
     * Ověřuje, že pokud není zadán žádný parametr, vrátí se správná chybová zpráva.
     */
    @Test
    public void testProvedBezParametru() {
        String vysledek = prikazSeber.proved(new String[]{});
        assertEquals("Musíš mi říct, co mám sebrat.", vysledek);
    }

    /**
     * Testuje provedení příkazu "seber" s neznámým předmětem.
     * Ověřuje, že pokud je zadán neznámý předmět, vrátí se správná chybová zpráva.
     */
    @Test
    public void testProvedNeznamyPredmet() {
        String nazevPredmetu = "neznámo";
        String vysledek = prikazSeber.proved(new String[]{nazevPredmetu});
        assertEquals("Předmět '" + nazevPredmetu + "' se v místnosti '" +
                hra.getHerniSvet().getAktualniLokace().getNazev() + "' nenachází.", vysledek);
    }

    /**
     * Testuje provedení příkazu "seber" se známým předmětem.
     * Ověřuje, že pokud je zadán známý předmět, předmět je správně přidán do inventáře.
     */
    @Test
    public void testProvedZnamyPredmet() {
        String nazevPredmetu = "jablko";
        String vysledek = prikazSeber.proved(new String[]{nazevPredmetu});
        assertEquals("Sebral jsi předmět '" + nazevPredmetu + "' a vložil ho do inventáře.", vysledek);
    }

    /**
     * Testuje opakované provedení příkazu "seber" se známým předmětem.
     * Ověřuje, že předmět lze sebrat pouze jednou a při opakovaném pokusu se vrátí správná chybová zpráva.
     */
    @Test
    public void testProvedZnamyPredmetVicekrat() {
        String nazevPredmetu = "jablko";
        String vysledek = prikazSeber.proved(new String[]{nazevPredmetu});
        assertEquals("Sebral jsi předmět '" + nazevPredmetu + "' a vložil ho do inventáře.", vysledek);

        String vysledek2 = prikazSeber.proved(new String[]{nazevPredmetu});
        assertEquals("Předmět '" + nazevPredmetu + "' se v místnosti '" +
                hra.getHerniSvet().getAktualniLokace().getNazev() + "' nenachází.", vysledek2);
    }
}