package Logika;


import java.util.HashSet;
import java.util.Set;

public class Hra { //slouží k ovládání hry
    private boolean hraSkoncila;
    private HerniSvet herniSvet;
    private Inventar inventar;
    private Set<IPrikaz> prikazy;
    private int pruchody;

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

    public boolean isHraSkoncila() {
        return hraSkoncila;
    }

    public void setHraSkoncila(boolean hraSkoncila) {
        this.hraSkoncila = hraSkoncila;
    }

    public HerniSvet getHerniSvet() {
        return herniSvet;
    }

    public void setHerniSvet(HerniSvet herniSvet) {
        this.herniSvet = herniSvet;
    }

    public String zpracujPrikaz(String prikaz){
        String [] slova = prikaz.split(" ");

        String [] parametryPrikazu = new String[slova.length - 1];
        for (int i = 1; i < slova.length; i++) {
            parametryPrikazu[i - 1] = slova[1];
        }

        for (IPrikaz p : prikazy){
            if(p.getNazev().equalsIgnoreCase(slova[0])) {
                return p.proved(parametryPrikazu);
            }
        }

        if (herniSvet.getStav() != StavHry.HRA_BEZI) {
            hraSkoncila = true;
        }

        return "Tento příkaz neznám.";
    }

    public String getProlog(){
        return "Vítejte. Toto je hra o ČK. Pokud nevíte co dál,...";
    }

    /**
     *
     * @return
     */
    public String getEpilog(){
        String text = "Díky, že sis zahrál(a). Pokud nemáš bonusovou výhru, můžeš to zkusit znovu.";

/*        if(herniSvet.getStav() == StavHry.VYHRA){
            text = "Úspešně jsi babičce donesl bábovku a vyhral \n\n" + text;
        }

        if(herniSvet.getStav() == StavHry.PROHRA){
            text = "Bohužel prohrál jsi\n\n" + text;
        }*/
        return "Díky, že sis zahrál(a). Pokud nemáš bonusovou výhru, můžeš to zkusit znovu.";
    }

    public Inventar getInventar() {
        return inventar;
    }

}
