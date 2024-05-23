package Logika;

public class Predmet {
    private String nazev;
    private String popis;
    private boolean prenositelny;

    public Predmet(String nazev, String popis, boolean prenositelny) {
        this.nazev = nazev;
        this.popis = popis;
        this.prenositelny = prenositelny;
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
}
