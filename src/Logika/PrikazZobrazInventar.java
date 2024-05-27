package Logika;

/**
 * Třída PrikazZobrazInventar implementuje příkaz "zobraz_inventar" pro hru.
 * Tento příkaz umožňuje hráči zobrazit obsah jeho inventáře.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazZobrazInventar implements IPrikaz{
    private Hra hra;

    /**
     * Konstruktor třídy PrikazZobrazInventar. Inicializuje příkaz s odkazem na aktuální hru.
     *
     * @param hra aktuální instance hry
     */
    public PrikazZobrazInventar(Hra hra) {
        this.hra = hra;
    }

    /**
     * Metoda vrací název příkazu.
     *
     * @return název příkazu "zobraz_inventar"
     */
    @Override
    public String getNazev() {
        return "zobraz_inventar";
    }

    /**
     * Metoda provádí příkaz "zobraz_inventar". Vrací textový popis obsahu inventáře hráče.
     *
     * @param parametryPrikazu pole parametrů příkazu (není očekáván žádný parametr)
     * @return textový výsledek provedení příkazu s obsahem inventáře
     */
    @Override
    public String proved(String[] parametryPrikazu) {
        return hra.getInventar().zobrazInventar();
    }
}
