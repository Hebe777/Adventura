package Testy;

import Logika.Hra;
import Logika.PrikazUvar;
import Logika.Predmet;
import Logika.Lokace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Třída PrikazUvarTest testuje funkčnost třídy PrikazUvar.
 *
 * Testuje se provedení příkazu "uvar" za různých podmínek, jako je nepřítomnost v kuchyni,
 * chybějící kastrol, úspěšné uvaření s potřebnými ingrediencemi, úspěšné uvaření s bonusovou
 * ingrediencí, neúspěšné uvaření kvůli nedostatku ingrediencí a neúspěšné uvaření kvůli
 * nesprávným ingrediencím.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazUvarTest {
    private Hra hra;
    private PrikazUvar prikazUvar;
    private Lokace kuchyne;
    private Predmet kastrol;

    /**
     * Nastavení výchozího stavu před každým testem.
     * Inicializuje hru, příkaz "uvar", lokace a kastrol.
     */
    @BeforeEach
    public void setUp() {
        hra = new Hra();
        prikazUvar = new PrikazUvar(hra);
        kuchyne = new Lokace("kuchyn", "Jste v kuchyni");
        kastrol = new Predmet("kastrol", true);
        kuchyne.pridejPredmet(kastrol);
    }

    /**
     * Testuje provedení příkazu "uvar", když hráč není v kuchyni.
     * Ověřuje, že pokud hráč není v kuchyni, vrátí se správná chybová zpráva.
     */
    @Test
    public void testNejsiVKuchyni() {
        String vysledek = prikazUvar.proved(new String[]{});
        assertEquals("Aby jsi mohl vařit musiš být v kuchyni!", vysledek);
    }

    /**
     * Testuje provedení příkazu "uvar", když chybí kastrol.
     * Ověřuje, že pokud kastrol není v kuchyni, vrátí se správná chybová zpráva.
     */
    @Test
    public void testChybiKastrol() {
        hra.getHerniSvet().setAktualniLokace(kuchyne);
        kuchyne.odeberPredmet(kastrol);
        String vysledek = prikazUvar.proved(new String[]{});
        assertEquals("Collete: Aby jsi se mnou mohl mluvit musíš nejdříve najít kastrol.", vysledek);
    }

    /**
     * Testuje úspěšné dokončení hry s potřebnými ingrediencemi.
     * Ověřuje, že pokud jsou v kastrolu všechny potřebné ingredience, hra je úspěšně dokončena.
     */
    @Test
    public void testVyhra() {
        hra.getHerniSvet().setAktualniLokace(kuchyne);

        kastrol.vlozPredmetDoKastrolu(new Predmet("cibule", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("cesnek", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("paprika", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("cuketa", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("lilek", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("rajce", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("olivovyOlej", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("bylinky", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("sul", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("pepr", true));

        String vysledek = prikazUvar.proved(new String[]{});
        assertEquals("Gratuluji, vyhrál(a) jsi! Všechny potřebné suroviny jsi našel.", vysledek);
        assertTrue(hra.isHraSkoncila());
        assertTrue(hra.getHerniSvet().isVyhra());
        assertFalse(hra.getHerniSvet().isProhra());
    }

    /**
     * Testuje úspěšné dokončení hry s bonusovou ingrediencí.
     * Ověřuje, že pokud jsou v kastrolu všechny potřebné ingredience a bonusová ingredience,
     * hra je úspěšně dokončena s bonusem.
     */
    @Test
    public void testVyhraBonus() {
        hra.getHerniSvet().setAktualniLokace(kuchyne);

        kastrol.vlozPredmetDoKastrolu(new Predmet("cibule", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("cesnek", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("paprika", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("cuketa", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("lilek", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("rajce", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("olivovyOlej", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("bylinky", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("sul", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("pepr", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("vino", true));

        String vysledek = prikazUvar.proved(new String[]{});
        assertEquals("Gratuluji, vyhrál(a) jsi! Koukám, že jsi našel i víno. Získáváš pro tedy i bonusové body.", vysledek);
        assertTrue(hra.isHraSkoncila());
        assertTrue(hra.getHerniSvet().isVyhra());
        assertFalse(hra.getHerniSvet().isProhra());
    }

    /**
     * Testuje neúspěšné dokončení hry kvůli nedostatku ingrediencí.
     * Ověřuje, že pokud v kastrolu chybí některé potřebné ingredience, hra je neúspěšně dokončena.
     */
    @Test
    public void testProhraMaloIngredienci() {
        hra.getHerniSvet().setAktualniLokace(kuchyne);

        kastrol.vlozPredmetDoKastrolu(new Predmet("cibule", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("cesnek", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("paprika", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("cuketa", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("lilek", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("rajce", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("olivovyOlej", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("bylinky", true));

        StringBuilder builder = new StringBuilder();
        List<String> recept = new ArrayList<>(Arrays.asList("cibule","cesnek","paprika","cuketa","lilek","rajce","olivovyOlej","bylinky","sul","pepr"));
        for(String s : kastrol.getPredmety().keySet()){
            recept.remove(s);
        }
        for (String r : recept){
            builder.append(r).append(" ");
        }

        String vysledek = prikazUvar.proved(new String[]{});
        assertEquals("Bohužel jsi prohrál(a). Chyběli ti tyto ingerdience: " + recept, vysledek);
        assertTrue(hra.isHraSkoncila());
        assertTrue(hra.getHerniSvet().isProhra());
        assertFalse(hra.getHerniSvet().isVyhra());
    }

    /**
     * Testuje neúspěšné dokončení hry kvůli nesprávným ingrediencím.
     * Ověřuje, že pokud v kastrolu jsou nesprávné ingredience, hra je neúspěšně dokončena.
     */
    @Test
    public void testProhraSpatneIngredience(){
        hra.getHerniSvet().setAktualniLokace(kuchyne);

        kastrol.vlozPredmetDoKastrolu(new Predmet("banan", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("jablko", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("paprika", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("cuketa", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("hruska", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("rajce", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("olivovyOlej", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("bylinky", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("sul", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("pepr", true));
        kastrol.vlozPredmetDoKastrolu(new Predmet("vino", true));

        String vysledek = prikazUvar.proved(new String[]{});
        assertEquals("Bohužel jsi prohrál(a). Použil jsi špatné ingredience.", vysledek);
        assertTrue(hra.isHraSkoncila());
        assertTrue(hra.getHerniSvet().isProhra());
        assertFalse(hra.getHerniSvet().isVyhra());
    }
}