package Logika;

/**
 * Třída PrikazKonec implementuje příkaz "konec" pro hru.
 * Tento příkaz ukončuje aktuální hru.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazKonec implements IPrikaz{

    private final Hra hra;

    /**
     * Konstruktor třídy PrikazKonec. Inicializuje příkaz s odkazem na aktuální hru.
     *
     * @param hra aktuální instance hry
     */
    public PrikazKonec(Hra hra){
        this.hra = hra;
    }

    /**
     * Metoda vrací název příkazu.
     *
     * @return název příkazu "konec"
     */
    @Override
    public String getNazev(){
        return "konec";
    }

    /**
     * Metoda provádí příkaz "konec". Nastaví stav hry jako ukončený.
     *
     * @param parametryPrikazu pole parametrů příkazu (není očekáván žádný parametr)
     * @return textový výsledek provedení příkazu
     */
    @Override
    public String proved(String[] parametryPrikazu){
        hra.setHraSkoncila(true);
        return "Hra byla ukončena příkazem KONEC!";
    }
}
