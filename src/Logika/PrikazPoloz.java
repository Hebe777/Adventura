package Logika;
/**
 * Třída PrikazPoloz implementuje příkaz "poloz" pro hru.
 * Tento příkaz umožňuje hráči položit předmět z inventáře do aktuální lokace nebo do kastrolu, pokud je v kuchyni.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazPoloz implements IPrikaz{
    private final Hra hra;

    /**
     * Konstruktor třídy PrikazPoloz. Inicializuje příkaz s odkazem na aktuální hru.
     *
     * @param hra aktuální instance hry
     */
    public PrikazPoloz(Hra hra) {
        this.hra = hra;
    }

    /**
     * Metoda vrací název příkazu.
     *
     * @return název příkazu "poloz"
     */
    @Override
    public String getNazev() {
        return "poloz";
    }

    /**
     * Metoda provádí příkaz "poloz". Položí předmět z inventáře do aktuální lokace nebo do kastrolu, pokud je v kuchyni.
     *
     * @param parametryPrikazu pole parametrů příkazu (očekává se jeden parametr - název předmětu)
     * @return textový výsledek provedení příkazu
     */
    @Override
    public String proved(String[] parametryPrikazu) {
        if(parametryPrikazu.length < 1){
            return "Musíš zadat, jaký předmět chceš položit.";
        }

        if(parametryPrikazu.length > 1){
            return "Neumím položit více než jeden předmět.";
        }

        String parametr = parametryPrikazu[0];
        Lokace aktualniLokace = hra.getHerniSvet().getAktualniLokace();
        Inventar inventar = hra.getInventar();
        Predmet predmet = hra.getInventar().getObsahBatohu().get(parametr);


        if(aktualniLokace.getNazev().equals("kuchyn")  && aktualniLokace.vratPredmet("kastrol") != null){
            Predmet ingredience = inventar.vyberVecVBatohu(parametr);

            if(ingredience == null){
                return "Ingerienci '" + parametr + "' nemáš v batohu.";
            }

            Predmet kastrol = aktualniLokace.vratPredmet("kastrol");
            if(!kastrol.vlozPredmetDoKastrolu(ingredience)){
                return "Kastrol je plný! Použít lze jen příkaz 'uvar'";
            }
            return "Ingredience '" + ingredience.getNazev()
                    + "' byla přidána do kastrolu.";
        }

        if(predmet == null){
            return "Předmět '" + parametr + "' nemáš v batohu.";
        }

        if(!inventar.odeberZInventare(predmet)){
            return "Předmět '" + predmet.getNazev() + "' se nepodařilo položit.";
        }

        aktualniLokace.pridejPredmet(predmet);

        return "Předmět '" + predmet.getNazev() + "' byl položen v lokaci '" + aktualniLokace.getNazev() + "'.";

    }
}
