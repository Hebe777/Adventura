package Testy;

import Logika.Inventar;
import Logika.Predmet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Třída PredmetTest testuje funkčnost třídy Predmet a její interakci s třídou Inventar.
 *
 * Testuje se přidávání a odebírání předmětů z inventáře, kapacita inventáře a další funkce.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PredmetTest {
    private Inventar inventar;
    private Predmet predmet;
    private Predmet neprenositelnyPredmet;

    /**
     * Nastavení výchozího stavu před každým testem.
     * Inicializuje inventář a dva předměty - jeden přenositelný a jeden nepřenositelný.
     */
    @BeforeEach
    public void setUp() {
        inventar = new Inventar();
        predmet = new Predmet("Predmet", true);
        neprenositelnyPredmet = new Predmet("NeprenositelnyPredmet", false);
    }

    /**
     * Testuje přidání předmětů do inventáře.
     * Ověřuje, že přenositelný předmět lze přidat, zatímco nepřenositelný předmět ne.
     */
    @Test
    public void testVlozDoInventare() {
        assertTrue(inventar.vlozDoInventare(predmet));
        assertEquals(predmet, inventar.getObsahBatohu().get(predmet.getNazev()));

        assertFalse(inventar.vlozDoInventare(neprenositelnyPredmet));
        assertFalse(inventar.getObsahBatohu().containsKey(neprenositelnyPredmet.getNazev()));
    }

    /**
     * Testuje odebrání předmětů z inventáře.
     * Ověřuje, že předmět lze odebrat z inventáře.
     */
    @Test
    public void testOdeberZInventare() {
        inventar.vlozDoInventare(predmet);
        assertTrue(inventar.odeberZInventare(predmet));
        assertFalse(inventar.getObsahBatohu().containsKey(predmet.getNazev()));
    }

    /**
     * Testuje výběr předmětů z inventáře.
     * Ověřuje, že vybraný předmět je správně vrácen a následně odstraněn z inventáře.
     */
    @Test
    public void testVyberVecVBatohu() {
        inventar.vlozDoInventare(predmet);
        Predmet vybranyPredmet = inventar.vyberVecVBatohu(predmet.getNazev());
        assertEquals(predmet, vybranyPredmet);
        assertFalse(inventar.getObsahBatohu().containsKey(predmet.getNazev()));
    }

    /**
     * Testuje kapacitu inventáře.
     * Ověřuje, že inventář má maximální kapacitu 11 předmětů a nepřijme další předmět po dosažení této kapacity.
     */
    @Test
    public void testKapacitaInventare() {
        for (int i = 0; i < 11; i++) {
            assertTrue(inventar.vlozDoInventare(new Predmet("Predmet" + i,true)));
        }
        assertEquals(11, inventar.getObsahBatohu().size()) ;
        assertFalse(inventar.vlozDoInventare(new Predmet("ExtraPredmet", true)));
    }

    /**
     *  Testuje odebrání předmětu z prázdného inventáře.
     * Ověřuje, že z prázdného inventáře nelze odebrat žádný předmět.
     */
    @Test
    public void testOdeberZPrazdnehoInventare() {
        assertEquals(0, inventar.getObsahBatohu().size());
        assertFalse(inventar.odeberZInventare(predmet));
    }
}