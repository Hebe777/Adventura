package Testy;

import Logika.Hra;
import Logika.PrikazPoloz;
import Logika.Predmet;
import Logika.Lokace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Třída PrikazPolozTest testuje funkčnost třídy PrikazPoloz.
 *
 * Testuje se položení předmětu za různých podmínek, jako je chybějící parametr,
 * neznámý předmět, položení více předmětů najednou, platný předmět, položení do kastrolu
 * a pokus o položení do plného kastrolu.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazPolozTest {
    private Hra hra;
    private PrikazPoloz prikazPoloz;
    private Predmet kastrol;
    private Lokace kuchyne;

    /**
     * Nastavení výchozího stavu před každým testem.
     * Inicializuje hru, příkaz "poloz", kastrol a kuchyni.
     */
    @BeforeEach
    public void setUp() {
        hra = new Hra();
        prikazPoloz = new PrikazPoloz(hra);
        kastrol = new Predmet("kastrol", true);
        kuchyne = new Lokace("kuchyn", "Jste v kuchyni");
    }

    /**
     * Testuje provedení příkazu "poloz" bez parametru.
     * Ověřuje, že pokud není zadán žádný parametr, vrátí se správná chybová zpráva.
     */
    @Test
    public void testProvedBezParametru() {
        String vysledek = prikazPoloz.proved(new String[]{});
        assertEquals("Musíš zadat, jaký předmět chceš položit.", vysledek);
    }

    /**
     * Testuje provedení příkazu "poloz" s neznámým předmětem.
     * Ověřuje, že pokud je zadán neznámý předmět, vrátí se správná chybová zpráva.
     */
    @Test
    public void testProvedNeznamyPredmet() {
        String vysledek = prikazPoloz.proved(new String[]{"neznámo"});
        assertEquals("Předmět 'neznámo' nemáš v batohu.", vysledek);
    }

    /**
     * Testuje provedení příkazu "poloz" s více předměty najednou.
     * Ověřuje, že pokud je zadáno více předmětů najednou, vrátí se správná chybová zpráva.
     */
    @Test
    public void testProvedVicePredmetuNajednou(){
        String vysledek = prikazPoloz.proved(new String[]{"Jablko", "Hruška"});
        assertEquals("Neumím položit více než jeden předmět.", vysledek);
    }

    /**
     * Testuje provedení příkazu "poloz" s platným předmětem.
     * Ověřuje, že pokud je zadán platný předmět, předmět je správně položen v aktuální lokaci.
     */
    @Test
    public void testProvedPlatnyPredmet() {
        hra.getInventar().vlozDoInventare(new Predmet("Jablko", true));
        String vysledek = prikazPoloz.proved(new String[]{"Jablko"});
        assertEquals("Předmět 'Jablko' byl položen v lokaci 'strechy'.", vysledek);
    }

    /**
     * Testuje provedení příkazu "poloz" při položení předmětu do kastrolu.
     * Ověřuje, že pokud je kastrol v aktuální lokaci, předmět je správně vložen do kastrolu.
     */
    @Test
    public void testProvedPolozitDoKastrolu() {
        hra.getHerniSvet().setAktualniLokace(kuchyne);
        hra.getInventar().vlozDoInventare(new Predmet("Jablko", true));
        kuchyne.pridejPredmet(kastrol);
        String vysledek = prikazPoloz.proved(new String[]{"Jablko"});
        assertEquals("Ingredience 'Jablko' byla přidána do kastrolu.", vysledek);
        assertTrue(kastrol.getPredmety().containsKey("Jablko"));
    }

    /**
     * Testuje provedení příkazu "poloz" při pokusu o položení předmětu do plného kastrolu.
     * Ověřuje, že pokud je kastrol plný, vrátí se správná chybová zpráva a předmět není vložen do kastrolu.
     */
    @Test
    public void testProvedPolozitDoPlnehoKastrolu() {
        hra.getHerniSvet().setAktualniLokace(kuchyne);
        hra.getInventar().vlozDoInventare(new Predmet("Jablko", true));
        kuchyne.pridejPredmet(kastrol);
        for(int i = 0; i < 11; i++){
            kastrol.vlozPredmetDoKastrolu(new Predmet("Jablko" + i, true));
        }
        String vysledek = prikazPoloz.proved(new String[]{"Jablko"});
        assertEquals("Kastrol je plný! Použít lze jen příkaz 'uvar'", vysledek);
        assertFalse(kastrol.getPredmety().containsKey("Jablko"));
    }
}