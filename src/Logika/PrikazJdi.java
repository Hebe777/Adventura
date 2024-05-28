package Logika;

/**
 * Třída PrikazJdi implementuje příkaz "jdi" pro hru.
 * Tento příkaz umožňuje hráči přejít do jiné lokace.
 *
 * @author  Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazJdi implements IPrikaz{

    private final Hra hra;

    /**
     * Konstruktor třídy PrikazJdi. Inicializuje příkaz s odkazem na aktuální hru.
     *
     * @param hra aktuální hra
     */
    public PrikazJdi(Hra hra){
        this.hra = hra;
    }

    /**
     * Metoda vrací název příkazu.
     *
     * @return název příkazu "jdi"
     */
    @Override
    public String getNazev(){
        return "jdi";
    }

    /**
     * Metoda provádí příkaz "jdi". Přesune hráče do zadané lokace, pokud je dostupná.
     *
     * @param parametryPrikazu pole parametrů příkazu (očekává se jeden parametr - název lokace)
     * @return textový výsledek provedení příkazu
     */
    @Override
    public String proved(String[] parametryPrikazu){

        if (parametryPrikazu.length < 1){
            return "Musiš mi říct, kam mám jít.";
        }

        if(parametryPrikazu.length > 1){
            return "Zadal jsi mi moc lokací, nevím kam mám jít.";
        }

        String nazevLokace = parametryPrikazu[0];
        HerniSvet herniSvet = hra.getHerniSvet();


        Lokace aktualniLokace = hra.getHerniSvet().getAktualniLokace();

        if(!aktualniLokace.maVychod(nazevLokace)){
            return "Do lokace '" + nazevLokace + "' se odsud nedá jít";
        }

        Lokace novaLokace = aktualniLokace.vratVychod(nazevLokace);
        herniSvet.setAktualniLokace(novaLokace);

        return "Odešel jsi do lokace " + novaLokace.getNazev() + "\n\n" + novaLokace.getPopis();
    }
}
