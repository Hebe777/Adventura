package Testy;

import Logika.Hra;
import Logika.PrikazPromluv;
import Logika.Postava;
import Logika.Lokace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Třída PrikazPromluvTest testuje funkčnost třídy PrikazPromluv.
 *
 * Testuje se interakce s postavami za různých podmínek, jako je chybějící parametr,
 * neznámá postava a známá postava.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazPromluvTest {
    private Hra hra;
    private PrikazPromluv prikazPromluv;
    private Lokace kuchyne;

    /**
     * Nastavení výchozího stavu před každým testem.
     * Inicializuje hru, příkaz "promluv" a kuchyni.
     */
    @BeforeEach
    public void setUp() {
        hra = new Hra();
        prikazPromluv = new PrikazPromluv(hra);
        kuchyne = new Lokace("kuchyn", "Jste v kuchyni");
        hra.getHerniSvet().setAktualniLokace(kuchyne);
    }

    /**
     * Testuje provedení příkazu "promluv" bez parametru.
     * Ověřuje, že pokud není zadán žádný parametr, vrátí se správná chybová zpráva.
     */
    @Test
    public void testProvedBezParametru() {
        String vysledek = prikazPromluv.proved(new String[]{});
        assertEquals("Nevím, s kým mám mluvit.", vysledek);
    }

    /**
     * Testuje provedení příkazu "promluv" s neznámou postavou.
     * Ověřuje, že pokud je zadána neznámá postava, vrátí se správná chybová zpráva.
     */
    @Test
    public void testProvedNeznamaPostava() {
        String vysledek = prikazPromluv.proved(new String[]{"Karel"});
        assertEquals("Tato postava se zde není", vysledek);
    }

    /**
     * Testuje provedení příkazu "promluv" se známou postavou.
     * Ověřuje, že pokud je zadána známá postava, vrátí se její správný proslov.
     * Bohužel nevím , jak testovat interakce
     */
    @Test
    public void testProvedZnamaPostava() {
        Postava skinner = new Postava("Skinner", "Dobrý den, jak se máte?");
        kuchyne.pridejPostavu(skinner);
        String vysledek = prikazPromluv.proved(new String[]{"Skinner"});
        assertEquals(skinner.getProslov(), vysledek);
    }
}