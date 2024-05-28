package Logika;

/**
 * Třída PrikazRozhledniSe implementuje příkaz "rozhledni_se" pro hru.
 * Tento příkaz umožňuje hráči získat popis aktuální lokace.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazRozhledniSe implements IPrikaz{
    private final Hra hra;


    /**
     * Konstruktor třídy PrikazRozhledniSe. Inicializuje příkaz s odkazem na aktuální hru.
     *
     * @param hra aktuální instance hry
     */
    public PrikazRozhledniSe(Hra hra){
        this.hra = hra;
    }

    /**
     * Metoda vrací název příkazu.
     *
     * @return název příkazu "rozhledni_se"
     */
    @Override
    public String getNazev() {
        return "rozhledni_se";
    }

    /**
     * Metoda provádí příkaz "rozhledni_se". Vrací popis aktuální lokace.
     *
     * @param parametryPrikazu pole parametrů příkazu (očekává se žádný parametr)
     * @return textový výsledek provedení příkazu s popisem aktuální lokace nebo chybovou zprávou
     */
    @Override
    public String proved(String[] parametryPrikazu) {

        if(parametryPrikazu.length > 0){
            return "Tomu nerozumím, neumím se rozhlednout na něco";
        }

        return hra.getHerniSvet().getAktualniLokace().getPopis();
    }
}
