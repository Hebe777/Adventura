package Logika;

import java.util.HashMap;
import java.util.Map;

public class Predmet {
    private String nazev;
    private String popis;
    private boolean prenositelny;
    private Map<String, Predmet> predmety; //kvůli kastrolu
    private static final int KAPACITA = 10;

    public Predmet(String nazev, String popis, boolean prenositelny) {
        this.nazev = nazev;
        this.popis = popis;
        this.prenositelny = prenositelny;

        predmety = new HashMap<>();
    }

    public String getNazev() {
        return nazev;
    }

    public boolean isPrenositelny() {
        return prenositelny;
    }

    public boolean vlozPredmetDoKastrolu (Predmet predmet) {
        if (predmety.size() < KAPACITA ) {
            predmety.put(predmet.getNazev(), predmet);
            return true;
        }
        return false;
    }

    public String seznamPredmetu(){
        String text = this.nazev.toUpperCase() + " obsahuje tyto předměty: ";
        for(String s : predmety.keySet()){
            text += s + " ";
        }
        return text;
    }

    public Map<String, Predmet> getPredmety() {
        return predmety;
    }
}
