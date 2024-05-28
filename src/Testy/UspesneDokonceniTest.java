package Testy;
import Logika.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UspesneDokonceniTest {
    private Hra hra;

    @Before
    public void setUp() {
        hra = new Hra();
    }

    @Test
    public void testUspesneDokonceniHry() {
        hra.zpracujPrikaz("seber kastrol");
        hra.zpracujPrikaz("seber olivovy_olej");
        hra.zpracujPrikaz("seber pepr");

        hra.zpracujPrikaz("jdi ulice");
        hra.zpracujPrikaz("seber cibule");
        hra.zpracujPrikaz("seber cesnek");

        hra.zpracujPrikaz("jdi trziste");
        hra.zpracujPrikaz("seber paprika");
        hra.zpracujPrikaz("seber cuketa");

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

        assertEquals("Gratuluji, vyhrál(a) jsi! Všechny potřebné suroviny jsi našel.", hra.zpracujPrikaz("uvar"));
        assertTrue(hra.isHraSkoncila());
        assertTrue(hra.getHerniSvet().isVyhra());
        assertFalse(hra.getHerniSvet().isProhra());

    }

    @Test
    public void testUspesneDokonceniHryBonus() {
        hra.zpracujPrikaz("seber kastrol");
        hra.zpracujPrikaz("seber olivovy_olej");
        hra.zpracujPrikaz("seber pepr");

        hra.zpracujPrikaz("jdi ulice");
        hra.zpracujPrikaz("seber cibule");
        hra.zpracujPrikaz("seber cesnek");

        hra.zpracujPrikaz("jdi trziste");
        hra.zpracujPrikaz("seber paprika");
        hra.zpracujPrikaz("seber cuketa");

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

        hra.zpracujPrikaz("jdi vinoteka");
        hra.zpracujPrikaz("seber vino");

        hra.zpracujPrikaz("jdi zahrada");
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
        hra.zpracujPrikaz("poloz vino");


        assertEquals("Gratuluji, vyhrál(a) jsi! Koukám, že jsi našel i víno. Získáváš pro tedy i bonusové body.", hra.zpracujPrikaz("uvar"));
        assertTrue(hra.isHraSkoncila());
        assertTrue(hra.getHerniSvet().isVyhra());
        assertFalse(hra.getHerniSvet().isProhra());

    }

}
