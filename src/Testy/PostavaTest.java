package Testy;

import Logika.Postava;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Třída PostavaTest testuje funkčnost třídy Postava.
 *
 * Testuje se správnost vrácení jména a proslovu postavy.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PostavaTest {
    private Postava postava1;
    private Postava postava2;

    /**
     * Nastavení výchozího stavu před každým testem.
     * Inicializuje dvě instance třídy Postava.
     */
    @BeforeEach
    public void setUp() {
        postava1 = new Postava("Gandalf", "Já jsem Gandalf a Gandalf znamená mě!");
        postava2 = new Postava(null, null);
    }

    /**
     * Testuje metodu getJmeno().
     * Ověřuje, že metoda vrací správné jméno postavy.
     */
    @Test
    public void testGetJmeno() {
        assertEquals("Gandalf", postava1.getJmeno());
        assertNull(postava2.getJmeno());
    }

    /**
     * Testuje metodu getProslov().
     * Ověřuje, že metoda vrací správný proslov postavy.
     */
    @Test
    public void testGetProslov() {
        assertEquals("Já jsem Gandalf a Gandalf znamená mě!", postava1.getProslov());
        assertNull(postava2.getProslov());
    }
}