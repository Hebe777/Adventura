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

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public boolean isPrenositelny() {
        return prenositelny;
    }

    public void setPrenositelny(boolean prenositelny) {
        this.prenositelny = prenositelny;
    }

    public boolean vlozPredmetDoKastrolu (Predmet predmet) {
        if (predmety.size() < KAPACITA ) {
            predmety.put(predmet.getNazev(), predmet);
            return true;
        }
        return false;
    }
}
