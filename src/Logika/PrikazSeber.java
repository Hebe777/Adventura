package Logika;

/**
 * Třída PrikazSeber implementuje příkaz "seber" pro hru.
 * Tento příkaz umožňuje hráči sebrat předmět z aktuální lokace a vložit jej do inventáře.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazSeber implements IPrikaz{
    private final Hra hra;

    /**
     * Konstruktor třídy PrikazSeber. Inicializuje příkaz s odkazem na aktuální hru.
     *
     * @param hra aktuální instance hry
     */
    public PrikazSeber(Hra hra) {
        this.hra = hra;
    }

    /**
     * Metoda vrací název příkazu.
     *
     * @return název příkazu "seber"
     */
    @Override
    public String getNazev() {
        return "seber";
    }

    /**
     * Metoda provádí příkaz "seber". Sebere předmět z aktuální lokace a vloží ho do inventáře, pokud je přenositelný a inventář není plný.
     *
     * @param parametryPrikazu pole parametrů příkazu (očekává se jeden parametr - název předmětu)
     * @return textový výsledek provedení příkazu
     */
    @Override
    public String proved(String[] parametryPrikazu) {
        if(parametryPrikazu.length < 1){
            return "Musíš mi říct, co mám sebrat.";
        }

        if(parametryPrikazu.length > 1){
            return "Omlouvám se, ale neumím sebrat najednou více věcí.";
        }

        Lokace aktualniLokace =  hra.getHerniSvet().getAktualniLokace();
        String nazev = parametryPrikazu[0];
        Predmet predmet = aktualniLokace.vratPredmet(nazev);


        if(predmet == null){
            return "Předmět '" + nazev + "' se v místnosti '" + aktualniLokace.getNazev() + "' nenachází.";
        }

        if(!predmet.isPrenositelny()){
            return "Předmět '" + nazev + "' se nedá vzít.";
        }

        if(hra.getInventar().vlozDoInventare(predmet)){
            aktualniLokace.odeberPredmet(predmet);
            return "Sebral jsi předmět '" + predmet.getNazev() + "' a vložil ho do inventáře.";
        }
        return "Bohužel máš plný inventář.";
    }
}
