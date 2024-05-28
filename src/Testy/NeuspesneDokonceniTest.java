package Testy;

import Logika.Hra;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NeuspesneDokonceniTest {
    private Hra hra;

    @Before
    public void setUp() {
        hra = new Hra();
    }

    @Test
    public void testNeuspesneDokonceniHrySpatneIngredience() {
        // Jdi do jednotlivých místností a seber všechny potřebné ingredience
        hra.zpracujPrikaz("seber kastrol");
        hra.zpracujPrikaz("seber olivovy_olej");
        hra.zpracujPrikaz("seber pepr");

        hra.zpracujPrikaz("jdi ulice");
        hra.zpracujPrikaz("seber cibule");
        hra.zpracujPrikaz("seber cesnek");

        hra.zpracujPrikaz("jdi trziste");
        hra.zpracujPrikaz("seber paprika");

        hra.zpracujPrikaz("jdi farmarsky_trh");
        hra.zpracujPrikaz("jdi kuchyn");
        hra.zpracujPrikaz("poloz kastrol");
        hra.zpracujPrikaz("poloz pepr");
        hra.zpracujPrikaz("poloz olivovy_olej");
        hra.zpracujPrikaz("poloz cibule");
        hra.zpracujPrikaz("poloz cesnek");
        hra.zpracujPrikaz("poloz cuketa");
        hra.zpracujPrikaz("poloz paprika");
        hra.zpracujPrikaz("jdi farmarsky_trh");
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
        hra.zpracujPrikaz("jdi zadni_ulicky");
        hra.zpracujPrikaz("seber bylinky");

        hra.zpracujPrikaz("jdi trziste");
        hra.zpracujPrikaz("jdi farmarsky_trh");
        hra.zpracujPrikaz("jdi kuchyn");

        hra.zpracujPrikaz("poloz lilek");
        hra.zpracujPrikaz("poloz rajce");
        hra.zpracujPrikaz("poloz bylinky");
        hra.zpracujPrikaz("poloz sul");

        String vysledek = hra.zpracujPrikaz("uvar");

        assertTrue(hra.isHraSkoncila());
        assertFalse(hra.getHerniSvet().isVyhra());
        assertTrue(hra.getHerniSvet().isProhra());
        assertEquals("Bohužel jsi prohrál(a). Buďto ti nějaké ingredience chybí a nebo jsi přidal nějaké špatné ingredience.", vysledek);
    }

    @Test
    public void ProhraLimitPruchoduTest(){
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
