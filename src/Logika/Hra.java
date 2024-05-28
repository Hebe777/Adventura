package Logika;


import java.util.HashSet;
import java.util.Set;

/**
 * Třída Hra slouží k ovládání hry.
 * Obsahuje metody pro zpracování příkazů, kontrolu stavu hry a správu herního světa.
 *
 * @author  Dominik Hebelka
 * @version 2024-25-05
 */
public class Hra {
    private boolean hraSkoncila;
    private final HerniSvet herniSvet;
    private final Inventar inventar;
    private final Set<IPrikaz> prikazy;
    private int pruchody = 0;

    /**
     * Konstruktor třídy Hra. Inicializuje herní svět, inventář a dostupné příkazy.
     */
    public Hra() {
        hraSkoncila = false;
        herniSvet = new HerniSvet();
        inventar = new Inventar();

        prikazy = new HashSet<>();

        prikazy.add(new PrikazJdi(this));
        prikazy.add(new PrikazKonec(this));
        prikazy.add(new PrikazSeber(this));
        prikazy.add(new PrikazRozhledniSe(this));
        prikazy.add(new PrikazNapoveda());
        prikazy.add(new PrikazPoloz(this));
        prikazy.add(new PrikazObsahKastrolu(this));
        prikazy.add(new PrikazUvar(this));
        prikazy.add(new PrikazZobrazInventar(this));
        prikazy.add(new PrikazPromluv(this));
    }

    /**
     * Metoda vrací, zda hra skončila.
     *
     * @return true, pokud hra skončila, jinak false
     */
    public boolean isHraSkoncila() {
        return hraSkoncila;
    }

    /**
     * Metoda nastavuje stav hry jako ukončený.
     *
     * @param hraSkoncila true, pokud hra skončila, jinak false
     */
    public void setHraSkoncila(boolean hraSkoncila) {
        this.hraSkoncila = hraSkoncila;
    }

    /**
     * Metoda vrací aktuální herní svět.
     *
     * @return herní svět
     */
    public HerniSvet getHerniSvet() {
        return herniSvet;
    }

    /**
     * Metoda zpracovává příkazy zadané hráčem.
     *
     * @param prikaz text příkazu zadaný hráčem
     * @return textový výsledek provedení příkazu
     */
    public String zpracujPrikaz(String prikaz){
        String [] slova = prikaz.split(" ");
        String text = "Tento příkaz neznám.";

        String [] parametryPrikazu = new String[slova.length - 1];
        for (int i = 1; i < slova.length; i++) {
            parametryPrikazu[i - 1] = slova[1];
        }

        for (IPrikaz p : prikazy){
            if(p.getNazev().equalsIgnoreCase(slova[0])) {
                if(pruchody >= 30){
                    herniSvet.setProhra(true);
                    setHraSkoncila(true);
                    text = "Počet průchodů byl překročen.";
                    break;
                } else if (p.getNazev().equalsIgnoreCase("jdi")) {
                    pruchody++;
                }
                return p.proved(parametryPrikazu);
            }
        }

        if (herniSvet.getStav() != StavHry.HRA_BEZI) {
            hraSkoncila = true;
        }

        return text;
    }

    /**
     * Metoda vrací prolog.
     *
     * @return úvodní text hry
     */
    public String getProlog(){
        return "Vítej ve hře 'Remyho kulinářská mise. Pokud si nebudeš během hry vědět rady můžeš použít příkaz 'napoveda', pro ukončení hry využíj příkaz 'konec'." +
                "\n\n" + herniSvet.getAktualniLokace().getPopis();
    }

    /**
     * Metoda vrací epilog.
     *
     * @return závěrečný text hry
     */
    public String getEpilog(){
        return "Hra je u konce. \nDíky, že sis zahrál(a). Můžeš to zkusit znovu ;)";
    }

    /**
     * Metoda vrací inventář hráče.
     *
     * @return inventář hráče
     */
    public Inventar getInventar() {
        return inventar;
    }

}
