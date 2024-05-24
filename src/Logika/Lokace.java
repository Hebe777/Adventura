package Logika;

import java.util.HashSet;
import java.util.Set;

public class Lokace {
    private String nazev;
    private String popis;
    private Set<Predmet> predmety;

    private Set<Lokace> vychody;
    private Set<Postava> postavy;

    public Lokace(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;

        vychody = new HashSet<>();
        predmety = new HashSet<>();
        postavy = new HashSet<>();
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        String nazvyVychodu = "Místnosti: ";
        for(Lokace l : vychody){
            nazvyVychodu += l.getNazev() + " ";
        }

        String seznamPredmetu = "Předměty: ";
        for(Predmet p : predmety){
            seznamPredmetu += p.getNazev() + " ";
        }

        String seznamPostav = "Postavy: ";
        for(Postava p : postavy){
            seznamPostav += p.getJmeno() + " ";
        }

        if(nazvyVychodu.length() < 12){
            nazvyVychodu = "Z této místnosti nevede žádná cesta :/";
        }

        if(seznamPredmetu.length() < 11){
            seznamPredmetu = "V této místnosti se nenachází žádný předmět :/";
        }

        if(seznamPostav.length() < 10){
            seznamPostav = "V této místnosti se nenachází žádná postava :/";
        }

        return "Právě se nacházíš v místnosti '" + nazev + "'.\n" +
                popis + "\n\n" + nazvyVychodu + "\n" + seznamPredmetu + "\n" + seznamPostav;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public boolean pridejVychod(Lokace cilovaLokace) {
        return vychody.add(cilovaLokace);
    }

    public boolean maVychod(String nazevLokace){
        for(Lokace l : vychody){
            if(l.getNazev().equals(nazevLokace)){
                return true;
            }
        }
        return false;
    }

    public Lokace vratVychod(String nazevLokace){
        for(Lokace l : vychody){
            if(l.getNazev().equals(nazevLokace)){
                return l;
            }
        }
        return null;
    }

    public Predmet vratPredmet(String nazevPredmetu){
        for(Predmet p : predmety){
            if(p.getNazev().equals(nazevPredmetu)){
                return p;
            }
        }
        return null;
    }

    public Set<Predmet> getPredmety() {
        return predmety;
    }

    public boolean pridejPredmet(Predmet predmet) {
        return predmety.add(predmet);
    }

    public boolean odeberPredmet(Predmet predmet){
        return predmety.remove(predmet);
    }

    public void pridejPostavu(Postava postava) {
        postavy.add(postava);
    }

    public Postava najdiPostavu(String jmeno)
    {
        for(Postava p : postavy){
            if(p.getJmeno().equals(jmeno)){
                return p;
            }
        }
        return null;
    }

}
