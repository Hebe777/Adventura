package Testy;

import Logika.Hra;
import Logika.PrikazObsahKastrolu;
import Logika.Predmet;
import Logika.Lokace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Třída PrikazObsahKastroluTest testuje funkčnost třídy PrikazObsahKastrolu.
 *
 * Testuje se zobrazení obsahu kastrolu v kuchyni za různých podmínek,
 * jako je prázdný kastrol, jeden předmět v kastrolu, více předmětů v kastrolu,
 * absence kastrolu v kuchyni a plný kastrol.
 *
 * @author  Dominik Hebelka
 * @version  2024-25-05
 */
public class PrikazObsahKastroluTest {
    private Hra hra;
    private PrikazObsahKastrolu prikazObsahKastrolu;
    private Predmet kastrol;
    private Lokace kuchyne;

    /**
     * Nastavení výchozího stavu před každým testem.
     * Inicializuje hru, příkaz "obsah_kastrolu", kastrol a kuchyni.
     */
    @BeforeEach
    public void setUp() {
        hra = new Hra();
        prikazObsahKastrolu = new PrikazObsahKastrolu(hra);
        kastrol = new Predmet("kastrol", true);
        kuchyne = new Lokace("kuchyn", "Jste v kuchyni");
        hra.getHerniSvet().setAktualniLokace(kuchyne);
    }

    /**
     * Testuje zobrazení obsahu prázdného kastrolu.
     * Ověřuje, že pokud je kastrol prázdný, vrátí se správná zpráva.
     */
    @Test
    public void testProvedPrazdnyKastrol() {
        hra.getHerniSvet().setAktualniLokace(kuchyne);
        kuchyne.pridejPredmet(kastrol);
        String vysledek = prikazObsahKastrolu.proved(new String[]{});
        assertEquals("Kastrol je prázdný.", vysledek);
    }

    /**
     * Testuje zobrazení obsahu kastrolu s jedním předmětem.
     * Ověřuje, že pokud je v kastrolu jeden předmět, vrátí se správná zpráva.
     */
    @Test
    public void testProvedJedenPredmetVKastrolu() {
        hra.getHerniSvet().setAktualniLokace(kuchyne);
        kuchyne.pridejPredmet(kastrol);
        kastrol.vlozPredmetDoKastrolu(new Predmet("Jablko", true));
        String vysledek = prikazObsahKastrolu.proved(new String[]{});
        assertEquals("V kastrolu je: Jablko ", vysledek);
    }

    /**
     * Testuje zobrazení obsahu kastrolu s více předměty.
     * Ověřuje, že pokud je v kastrolu více předmětů, vrátí se správná zpráva.
     */
    @Test
    public void testProvedVicePredmetuVKastrolu() {
        hra.getHerniSvet().setAktualniLokace(kuchyne);
        kuchyne.pridejPredmet(kastrol);
        kastrol.vlozPredmetDoKastrolu(new Predmet("Jablko",true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("Hruška",true));
        String vysledek = prikazObsahKastrolu.proved(new String[]{});
        assertEquals("V kastrolu je: Hruška Jablko ", vysledek);
    }

    /**
     * Testuje situaci, kdy kastrol není v kuchyni.
     * Ověřuje, že pokud kastrol není v kuchyni, vrátí se správná zpráva.
     */
    @Test
    public void testProvedKastrolNeniVKuchyni() {
        hra.getHerniSvet().setAktualniLokace(kuchyne);
        String vysledek = prikazObsahKastrolu.proved(new String[]{});
        assertEquals("Kastrol není v kuchyni.", vysledek);
    }

    /**
     * Testuje situaci, kdy je kastrol plný.
     * Ověřuje, že kastrol má maximální kapacitu a nelze do něj přidat více než 11 předmětů.
     */
    @Test
    public void testKastrolJePlny(){
        hra.getHerniSvet().setAktualniLokace(kuchyne);
        kuchyne.pridejPredmet(kastrol);

        for(int i = 0; i < 12; i++){
            kastrol.vlozPredmetDoKastrolu(new Predmet("Jablko" + i, true));
        }

        assertEquals(kastrol.getPredmety().size(), 11);
        assertFalse(kastrol.getPredmety().containsKey("Jablko11"));

        assertFalse(kastrol.vlozPredmetDoKastrolu(new Predmet("Jablkoo", true)));
        assertFalse(kastrol.getPredmety().containsKey("Jablkoo"));
        assertEquals(kastrol.getPredmety().size(), 11);
    }
}
