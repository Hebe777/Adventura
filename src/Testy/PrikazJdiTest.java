package Testy;

import Logika.Hra;
import Logika.Lokace;
import Logika.PrikazJdi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Třída PrikazJdiTest testuje funkčnost třídy PrikazJdi.
 *
 * Testuje se provedení příkazu "jdi" za různých podmínek, jako je chybějící parametr,
 * neplatný směr a platný směr.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazJdiTest {
    private Hra hra;
    private Lokace l1;
    private Lokace l2;
    private PrikazJdi prikazJdi;

    /**
     * Nastavení výchozího stavu před každým testem.
     * Inicializuje hru, lokace a příkaz "jdi".
     */
    @BeforeEach
    public void setUp() {
        hra = new Hra();
        l1 = new Lokace("ulice", "rušná ulice");
        l2 = new Lokace("kuchyn", "kuchyn");

        l1.pridejVychod(l2);
        l2.pridejVychod(l1);
        hra.getHerniSvet().setAktualniLokace(l1);

        prikazJdi = new PrikazJdi(hra);
    }

    /**
     * Testuje provedení příkazu "jdi" bez parametru.
     * Ověřuje, že pokud není zadán žádný parametr, vrátí se správná chybová zpráva.
     */
    @Test
    public void testProvedBezParametru() {
        String vysledek = prikazJdi.proved(new String[]{});
        assertEquals("Musiš mi říct, kam mám jít.", vysledek);
    }

    /**
     * Testuje provedení příkazu "jdi" s neplatným směrem.
     * Ověřuje, že pokud je zadán neplatný směr, vrátí se správná chybová zpráva.
     */
    @Test
    public void testProvedNeznamySmer() {
        String vysledek = prikazJdi.proved(new String[]{"neznámo"});
        assertEquals("Do lokace 'neznámo' se odsud nedá jít", vysledek);
    }

    /**
     * Testuje provedení příkazu "jdi" s platným směrem.
     * Ověřuje, že pokud je zadán platný směr, hráč se přesune do cílové lokace.
     */
    @Test
    public void testProvedPlatnySmer() {
        prikazJdi.proved(new String[]{"kuchyn"});
        assertEquals(l2, hra.getHerniSvet().getAktualniLokace());
    }

    /**
     * Testuje opakované provedení příkazu "jdi".
     * Ověřuje, že hráč se může pohybovat mezi lokacemi opakovaně.
     */
    @Test
    public void testProvedOpetovne() {
        prikazJdi.proved(new String[]{"ulice"});
        assertEquals(l1.getNazev(), hra.getHerniSvet().getAktualniLokace().getNazev());

        prikazJdi.proved(new String[]{"kuchyn"});
        assertEquals(l2.getNazev(), hra.getHerniSvet().getAktualniLokace().getNazev());

        prikazJdi.proved(new String[]{"ulice"});
        assertEquals(l1.getNazev(), hra.getHerniSvet().getAktualniLokace().getNazev());
    }
}