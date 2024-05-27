package Testy;
import Logika.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UspesneDokonceni {
    private Hra hra;

    @Before
    public void setUp() {
        hra = new Hra();
    }

    @Test
    public void testUspesneDokonceniHry() {
        // Jdi do jednotlivých místností a seber všechny potřebné ingredience
        hra.zpracujPrikaz("jdi ulice");
        hra.zpracujPrikaz("seber cibule");
        hra.zpracujPrikaz("seber cesnek");

        hra.zpracujPrikaz("jdi trziste");
        hra.zpracujPrikaz("seber paprika");
        hra.zpracujPrikaz("seber cuketa");

        hra.zpracujPrikaz("jdi zahrada");
        hra.zpracujPrikaz("seber lilek");
        hra.zpracujPrikaz("seber rajce");

        hra.zpracujPrikaz("jdi pekarstvi");
        hra.zpracujPrikaz("seber olivovy_olej");
        hra.zpracujPrikaz("seber sul");

        hra.zpracujPrikaz("jdi zadni_ulicky");
        hra.zpracujPrikaz("seber bylinky");
        hra.zpracujPrikaz("seber pepr");

        // Jdi do kuchyně
        hra.zpracujPrikaz("jdi trziste");
        hra.zpracujPrikaz("jdi farmarsky_trh");
        hra.zpracujPrikaz("jdi kuchyn");

        // Vlož všechny ingredience do kastrolu
        hra.zpracujPrikaz("poloz cibule");
        hra.zpracujPrikaz("poloz cesnek");
        hra.zpracujPrikaz("poloz paprika");
        hra.zpracujPrikaz("poloz cuketa");
        hra.zpracujPrikaz("poloz lilek");
        hra.zpracujPrikaz("poloz rajce");
        hra.zpracujPrikaz("poloz olivovy_olej");
        hra.zpracujPrikaz("poloz bylinky");
        hra.zpracujPrikaz("poloz sul");
        hra.zpracujPrikaz("poloz pepr");

        // Uvař ratatouille
        String vysledek = hra.zpracujPrikaz("uvar");

        // Ověření výsledku
        assertTrue(hra.isHraSkoncila());
        assertTrue(hra.getHerniSvet().isVyhra());
        assertFalse(hra.getHerniSvet().isProhra());
        assertEquals("Gratuluji, vyhrál(a) jsi! Všechny potřebné suroviny jsi našel(a).", vysledek);
    }
}
