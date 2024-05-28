package Testy;

import Logika.Hra;
import Logika.PrikazZobrazInventar;
import Logika.Predmet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Třída PrikazZobrazInventarTest testuje funkčnost třídy PrikazZobrazInventar.
 *
 * Testuje se provedení příkazu "zobraz_inventar" v různých stavech, jako je prázdný inventář
 * a inventář obsahující jeden předmět.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazZobrazInventarTest {
    private Hra hra;
    private PrikazZobrazInventar prikazZobrazInventar;
    private Predmet jablko;

    /**
     * Nastavení výchozího stavu před každým testem.
     * Inicializuje hru, příkaz "zobraz_inventar" a předmět.
     */
    @BeforeEach
    public void setUp() {
        hra = new Hra();
        prikazZobrazInventar = new PrikazZobrazInventar(hra);
        jablko = new Predmet("jablko", true);
    }

    /**
     * Testuje provedení příkazu "zobraz_inventar" s prázdným inventářem.
     * Ověřuje, že pokud je inventář prázdný, vrátí se správná zpráva.
     */
    @Test
    public void testPrazdnyInventar() {
        String vysledek = prikazZobrazInventar.proved(new String[]{});
        assertEquals("Inventář je prázdný.", vysledek);
    }

    /**
     * Testuje provedení příkazu "zobraz_inventar" s jedním předmětem v inventáři.
     * Ověřuje, že pokud je v inventáři jeden předmět, vrátí se správný výpis inventáře.
     */
    @Test
    public void testJedenPredmet() {
        hra.getInventar().vlozDoInventare(jablko);
        String vysledek = prikazZobrazInventar.proved(new String[]{});
        assertEquals("Aktualně máš v invetáři tyto předměty: jablko ", vysledek);
    }
}