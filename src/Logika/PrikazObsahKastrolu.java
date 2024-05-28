package Logika;

/**
 * Třída PrikazObsahKastrolu implementuje příkaz "obsah_kastrolu" pro hru.
 * Tento příkaz umožňuje hráči zjistit, jaké předměty jsou aktuálně v kastrolu.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazObsahKastrolu implements IPrikaz{
    private final Hra hra;

    /**
     * Konstruktor třídy PrikazObsahKastrolu. Inicializuje příkaz s odkazem na aktuální hru.
     *
     * @param hra aktuální instance hry
     */
    public PrikazObsahKastrolu(Hra hra) {
        this.hra = hra;
    }

    /**
     * Metoda vrací název příkazu.
     *
     * @return název příkazu "obsah_kastrolu"
     */
    @Override
    public String getNazev() {
        return "obsah_kastrolu";
    }

    /**
     * Metoda provádí příkaz "obsah_kastrolu". Zjistí a vrátí obsah kastrolu, pokud je hráč v kuchyni a kastrol je nalezen.
     *
     * @param parametryPrikazu pole parametrů příkazu (není očekáván žádný parametr)
     * @return textový výsledek provedení příkazu s obsahem kastrolu nebo chybovou zprávou
     */
    @Override
    public String proved(String[] parametryPrikazu) {
        Lokace aktualniLokace = hra.getHerniSvet().getAktualniLokace();
        Predmet kastrol = aktualniLokace.vratPredmet("kastrol");

        if(!aktualniLokace.getNazev().equals("kuchyn")){
            return "Aby jsi mohl vidět co je v kastrolu, tak se musíš nacházet v kuchyni.";
        }

        if(kastrol == null){
            return "Kastrol není v kuchyni.";
        }

        if(kastrol.getPredmety().isEmpty()){
            return "Kastrol je prázdný.";
        }
        return kastrol.seznamPredmetu();
    }
}
