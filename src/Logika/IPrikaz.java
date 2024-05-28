package Logika;

/**
 * Rozhrání pro vytváření příkazů
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public interface IPrikaz {
    /**
     * Metoda vrací název příkazu.
     *
     * @return Název příkazu jako řetězec
     */
    String getNazev();

    /**
     * Metoda provádí příkaz s danými parametry.
     *
     * @param parametryPrikazu Pole parametrů příkazu
     * @return Výsledek provedení příkazu jako řetězec
     */
    String proved(String[] parametryPrikazu);
}
