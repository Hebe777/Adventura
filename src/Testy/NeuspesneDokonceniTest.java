package Testy;

import Logika.Hra;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Třída NeuspesneDokonceniTest testuje neúspěšné dokončení hry.
 *
 * Testuje různé scénáře, ve kterých hráč nemůže úspěšně dokončit hru
 * z důvodu nedostatku ingrediencí, použití špatných ingrediencí nebo
 * překročení limitu průchodů mezi lokacemi.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class NeuspesneDokonceniTest {
    private Hra hra;

    /**
     * Nastavení výchozího stavu před každým testem.
     */
    @Before
    public void setUp() {
        hra = new Hra();
    }

    /**
     * Testuje neúspěšné dokončení hry z důvodu nedostatku ingrediencí.
     * Ověřuje, že hra končí prohrou, pokud nejsou všechny potřebné ingredience vloženy do kastrolu.
     */
    @Test
    public void testNeuspesneDokonceniHryMaloIngredienci() {
        hra.zpracujPrikaz("seber kastrol");
        hra.zpracujPrikaz("seber olivovyOlej");
        hra.zpracujPrikaz("seber pepr");

        hra.zpracujPrikaz("jdi ulice");
        hra.zpracujPrikaz("seber cibule");
        hra.zpracujPrikaz("seber cesnek");

        hra.zpracujPrikaz("jdi trziste");
        hra.zpracujPrikaz("seber paprika");

        hra.zpracujPrikaz("jdi farmarskyTrh");
        hra.zpracujPrikaz("jdi kuchyn");
        hra.zpracujPrikaz("poloz kastrol");
        hra.zpracujPrikaz("poloz pepr");
        hra.zpracujPrikaz("poloz olivovyOlej");
        hra.zpracujPrikaz("poloz cibule");
        hra.zpracujPrikaz("poloz cesnek");
        hra.zpracujPrikaz("poloz cuketa");
        hra.zpracujPrikaz("poloz paprika");
        hra.zpracujPrikaz("jdi farmarskyTrh");
        hra.zpracujPrikaz("jdi trziste");
        hra.zpracujPrikaz("jdi ulice");

        hra.zpracujPrikaz("jdi zahrada");
        hra.zpracujPrikaz("seber lilek");
        hra.zpracujPrikaz("seber rajce");

        hra.zpracujPrikaz("jdi ulice");
        hra.zpracujPrikaz("jdi pekarstvi");
        hra.zpracujPrikaz("seber sul");


        hra.zpracujPrikaz("jdi ulice");
        hra.zpracujPrikaz("jdi trziste");
        hra.zpracujPrikaz("jdi zadniUlicky");
        hra.zpracujPrikaz("seber bylinky");

        hra.zpracujPrikaz("jdi trziste");
        hra.zpracujPrikaz("jdi farmarskyTrh");
        hra.zpracujPrikaz("jdi kuchyn");

        hra.zpracujPrikaz("poloz lilek");
        hra.zpracujPrikaz("poloz rajce");
        hra.zpracujPrikaz("poloz bylinky");
        hra.zpracujPrikaz("poloz sul");

        String vysledek = hra.zpracujPrikaz("uvar");

        assertTrue(hra.isHraSkoncila());
        assertFalse(hra.getHerniSvet().isVyhra());
        assertTrue(hra.getHerniSvet().isProhra());
        assertEquals("Bohužel jsi prohrál(a). Chyběli ti tyto ingerdience: [cuketa]", vysledek);
    }

    /**
     * Testuje neúspěšné dokončení hry z důvodu použití špatných ingrediencí.
     * Ověřuje, že hra končí prohrou, pokud jsou použity nesprávné ingredience.
     */
    @Test
    public void testNeuspesneDokonceniHrySpatneIngredienci() {
        hra.zpracujPrikaz("seber kastrol");
        hra.zpracujPrikaz("seber olivovyOlej");
        hra.zpracujPrikaz("seber pepr");

        hra.zpracujPrikaz("jdi ulice");
        hra.zpracujPrikaz("seber cibule");
        hra.zpracujPrikaz("seber cesnek");

        hra.zpracujPrikaz("jdi trziste");
        hra.zpracujPrikaz("seber paprika");

        hra.zpracujPrikaz("jdi farmarskyTrh");
        hra.zpracujPrikaz("jdi kuchyn");
        hra.zpracujPrikaz("poloz kastrol");
        hra.zpracujPrikaz("poloz pepr");
        hra.zpracujPrikaz("poloz olivovyOlej");
        hra.zpracujPrikaz("poloz cibule");
        hra.zpracujPrikaz("poloz cesnek");
        hra.zpracujPrikaz("poloz cuketa");
        hra.zpracujPrikaz("poloz paprika");
        hra.zpracujPrikaz("jdi farmarskyTrh");
        hra.zpracujPrikaz("jdi trziste");
        hra.zpracujPrikaz("jdi ulice");

        hra.zpracujPrikaz("jdi zahrada");
        hra.zpracujPrikaz("seber lilek");
        hra.zpracujPrikaz("seber rajce");

        hra.zpracujPrikaz("jdi ulice");
        hra.zpracujPrikaz("jdi trziste");
        hra.zpracujPrikaz("jdi zadniUlicky");
        hra.zpracujPrikaz("seber bylinky");

        hra.zpracujPrikaz("jdi trziste");
        hra.zpracujPrikaz("jdi farmarskyTrh");
        hra.zpracujPrikaz("jdi kuchyn");
        hra.zpracujPrikaz("seber nuz");
        hra.zpracujPrikaz("seber vidlicka");

        hra.zpracujPrikaz("poloz nuz");
        hra.zpracujPrikaz("poloz vidlicka");
        hra.zpracujPrikaz("poloz lilek");
        hra.zpracujPrikaz("poloz rajce");
        hra.zpracujPrikaz("poloz bylinky");
        hra.zpracujPrikaz("poloz sul");

        String vysledek = hra.zpracujPrikaz("uvar");

        assertTrue(hra.isHraSkoncila());
        assertFalse(hra.getHerniSvet().isVyhra());
        assertTrue(hra.getHerniSvet().isProhra());
        assertEquals("Bohužel jsi prohrál(a). Použil jsi špatné ingredience.", vysledek);
    }

    /**
     * Testuje prohru z důvodu překročení limitu průchodů mezi lokacemi.
     * Ověřuje, že hra končí prohrou, pokud hráč překročí limit 30 průchodů.
     */
    @Test
    public void testProhraLimitPruchodu(){
        for (int i = 0; i <= 14; i++){
            hra.zpracujPrikaz("jdi ulice");
            hra.zpracujPrikaz("jdi strechy");
        }
        String vysledek = hra.zpracujPrikaz("jdi ulice");

        assertEquals("Počet průchodů byl překročen.", vysledek);
        assertTrue(hra.isHraSkoncila());
        assertFalse(hra.getHerniSvet().isVyhra());
        assertTrue(hra.getHerniSvet().isProhra());
    }
}
