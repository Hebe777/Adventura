package Logika;

/**
 * Rozhrání pro vytváření příkazů
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public interface IPrikaz {
    String getNazev();
    String proved(String[] parametryPrikazu);
}
