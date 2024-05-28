package Testy;

import Logika.Lokace;
import Logika.Postava;
import Logika.Predmet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * Třída LokaceTest testuje funkčnost třídy Lokace.
 *
 * Testuje se správnost navigace mezi lokacemi, přítomnost předmětů a postav
 * v lokacích a správné chování prázdné lokace.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class LokaceTest {
    private Lokace les;
    private Lokace mytina;
    private Lokace jeskyne;
    private Predmet mec;
    private Predmet klic;
    private Postava rytir;
    private Postava drak;

    /**
     * Nastavení výchozího stavu před každým testem.
     * Inicializuje lokace, předměty a postavy a propojuje je.
     */
    @BeforeEach
    public void setUp() {
        les = new Lokace("les", "Hustý temný les");
        mytina = new Lokace("mytina", "Malá mýtina uprostřed lesa");
        jeskyne = new Lokace("jeskyne", "Tmavá vlhká jeskyně");
        mec = new Predmet("mec", true);
        klic = new Predmet("klic", true);
        rytir = new Postava("rytir", "Udatný rytíř");
        drak = new Postava("drak", "Nebezpečný drak");

        les.pridejVychod(mytina);
        mytina.pridejVychod(les);
        mytina.pridejVychod(jeskyne);
        jeskyne.pridejVychod(mytina);

        les.pridejPredmet(mec);
        mytina.pridejPredmet(klic);

        les.pridejPostavu(rytir);
        jeskyne.pridejPostavu(drak);
    }

    /**
     * Testuje navigaci mezi lokacemi.
     * Ověřuje, že každá lokace má správné východy.
     */
    @Test
    public void testNavigaceMeziLokacemi() {
        assertEquals(mytina, les.vratVychod("mytina"));
        assertEquals(les, mytina.vratVychod("les"));
        assertEquals(jeskyne, mytina.vratVychod("jeskyne"));
        assertEquals(mytina, jeskyne.vratVychod("mytina"));
    }

    /**
     * Testuje přítomnost předmětů v jednotlivých lokacích.
     * Ověřuje, že předměty jsou správně umístěny.
     */
    @Test
    public void testPredmetyVLokacich() {
        assertTrue(les.getPredmety().contains(mec));
        assertTrue(mytina.getPredmety().contains(klic));
        assertTrue(jeskyne.getPredmety().isEmpty());
    }

    /**
     * Testuje přítomnost postav v jednotlivých lokacích.
     * Ověřuje, že postavy jsou správně umístěny.
     */
    @Test
    public void testPostavyVLokacich() {
        assertTrue(les.getPostavy().contains(rytir));
        assertTrue(jeskyne.getPostavy().contains(drak));
        assertTrue(mytina.getPostavy().isEmpty());
    }

    /**
     * Testuje prázdnou lokaci.
     * Ověřuje, že nově vytvořená lokace neobsahuje žádné předměty, východy ani postavy.
     */
    @Test
    public void testPrazdnaLokace() {
        Lokace prazdnaLokace = new Lokace("poust", "Nekonečná písečná poušť");
        assertTrue(prazdnaLokace.getPredmety().isEmpty());
        assertTrue(prazdnaLokace.getVychody().isEmpty());
        assertTrue(prazdnaLokace.getPostavy().isEmpty());
    }

    /**
     * Testuje kombinaci akcí v lokaci.
     * Přidání předmětů a postav do lokace a kontrola východů.
     */
    @Test
    public void testKombinaceAkci() {
        Predmet lampa = new Predmet("lampa",true);
        les.pridejPredmet(lampa);

        assertTrue(les.getPredmety().contains(mec));
        assertTrue(les.getPredmety().contains(lampa));
        assertEquals(2, les.getPredmety().size());

        Postava obchodnik = new Postava("obchodnik", "Cestující obchodník");
        les.pridejPostavu(obchodnik);

        assertTrue(les.getPostavy().contains(rytir));
        assertTrue(les.getPostavy().contains(obchodnik));
        assertEquals(2, les.getPostavy().size());

        assertEquals(mytina, les.vratVychod("mytina"));
        assertNull(les.vratVychod("jeskyne"));
    }
}
