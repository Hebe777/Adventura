package Testy;

import Logika.Lokace;
import Logika.Postava;
import Logika.Predmet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class LokaceTest {
    private Lokace les;
    private Lokace mytina;
    private Lokace jeskyne;
    private Predmet mec;
    private Predmet klic;
    private Postava rytir;
    private Postava drak;

    @BeforeEach
    public void setUp() {
        les = new Lokace("les", "Hustý temný les");
        mytina = new Lokace("mytina", "Malá mýtina uprostřed lesa");
        jeskyne = new Lokace("jeskyne", "Tmavá vlhká jeskyně");
        mec = new Predmet("mec", "Starý rezavý meč", true);
        klic = new Predmet("klic", "Zlatý klíč od truhly", true);
        rytir = new Postava("rytir", "Udatný rytíř");
        drak = new Postava("drak", "Nebezpečný drak");

        les.pridejVychod(mytina);
        mytina.pridejVychod(les);
        mytina.pridejVychod(jeskyne);
        jeskyne.pridejVychod(mytina);

        // Přidání předmětů do lokací
        les.pridejPredmet(mec);
        mytina.pridejPredmet(klic);

        // Přidání postav do lokací
        les.pridejPostavu(rytir);
        jeskyne.pridejPostavu(drak);
    }

    @Test
    public void testNavigaceMeziLokacemi() {
        assertEquals(mytina, les.vratVychod("mytina"));
        assertEquals(les, mytina.vratVychod("les"));
        assertEquals(jeskyne, mytina.vratVychod("jeskyne"));
        assertEquals(mytina, jeskyne.vratVychod("mytina"));
    }

    @Test
    public void testPredmetyVLokacich() {
        assertTrue(les.getPredmety().contains(mec));
        assertTrue(mytina.getPredmety().contains(klic));
        assertTrue(jeskyne.getPredmety().isEmpty());
    }

    @Test
    public void testPostavyVLokacich() {
        assertTrue(les.getPostavy().contains(rytir));
        assertTrue(jeskyne.getPostavy().contains(drak));
        assertTrue(mytina.getPostavy().isEmpty());
    }

    @Test
    public void testPrazdnaLokace() {
        Lokace prazdnaLokace = new Lokace("poust", "Nekonečná písečná poušť");
        assertTrue(prazdnaLokace.getPredmety().isEmpty());
        assertTrue(prazdnaLokace.getVychody().isEmpty());
        assertTrue(prazdnaLokace.getPostavy().isEmpty());
    }

    @Test
    public void testKombinaceAkci() {
        Predmet lampa = new Predmet("lampa", "Stará olejová lampa", true);
        les.pridejPredmet(lampa);

        assertTrue(les.getPredmety().contains(mec));
        assertTrue(les.getPredmety().contains(lampa));
        assertEquals(2, les.getPredmety().size());

        // Přidání další postavy do lesu
        Postava obchodnik = new Postava("obchodnik", "Cestující obchodník");
        les.pridejPostavu(obchodnik);

        assertTrue(les.getPostavy().contains(rytir));
        assertTrue(les.getPostavy().contains(obchodnik));
        assertEquals(2, les.getPostavy().size());

        // Kontrola východů po změně
        assertEquals(mytina, les.vratVychod("mytina"));
        assertNull(les.vratVychod("jeskyne"));
    }
}
