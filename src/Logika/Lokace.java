package Logika;

import java.util.HashSet;
import java.util.Set;
/**
 * Třída lokace přestavuje prostory ve hře,  mezi kterými se postava může pohybovat
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class Lokace {
    private String nazev;
    private String popis;
    private Set<Predmet> predmety;

    private Set<Lokace> vychody;
    private Set<Postava> postavy;

    /**
     * Konstruktor pro vytvoření lokaci s daným názvem a popisem lokace.
     * @param nazev Název lokace
     * @param popis Popis lokace
     */
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

    /**
     * Metoda slouží k vypsání informací o lokaci
     * @return Výstupem je řetězec s informacemi
     */
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

    /**
     * Metoda slouží k přidaní východů.
     *
     * @param cilovaLokace lokace
     * @return true pokud se poraří východ přidat; false pokud se přidání nepodaří
     */
    public boolean pridejVychod(Lokace cilovaLokace) {
        return vychody.add(cilovaLokace);
    }

    /**
     * Metoda kontroluje, zda se z lokace ve které se nacházíme, dá jít do lokace v parametru
     *
     * @param nazevLokace nazév lokace do které chceme jít
     * @return true pokud se do lokace v parametru dá jít; false pokud se do lokace v parametru z aktuální lokace nedá jít
     */
    public boolean maVychod(String nazevLokace){
        for(Lokace l : vychody){
            if(l.getNazev().equals(nazevLokace)){
                return true;
            }
        }
        return false;
    }

    public Set<Lokace> getVychody() {
        return vychody;
    }

    public Set<Postava> getPostavy() {
        return postavy;
    }

    /**
     * Metoda slouží jako getter pro lokaci, kterou definujeme v parametru
     * @param nazevLokace název hledané lokace
     * @return pokud se lokace nachází v možný výhodech, tak ji vrátí; pokud se lokace ve východech nenachází vratí null
     */
    public Lokace vratVychod(String nazevLokace){
        for(Lokace l : vychody){
            if(l.getNazev().equals(nazevLokace)){
                return l;
            }
        }
        return null;
    }
    /**
     * Metoda zjistí, zda se v lokaci nachází předmět s daným názvem.
     * @param nazevPredmetu název hledaného předmětu
     * @return vrací se entita předmětu
     */
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

    /**
     * Metoda přidá předmět do lokace.
     * @param predmet Předmět, který bude vložen
     */
    public boolean pridejPredmet(Predmet predmet) {
        return predmety.add(predmet);
    }

    public boolean odeberPredmet(Predmet predmet){
        return predmety.remove(predmet);
    }

    public void pridejPostavu(Postava postava) {
        postavy.add(postava);
    }

    /**
     * Metoda zjistí, zda se v lokaci nachází postava se jménem, které je v parametru
     * @param jmeno Jméno hledané postavy
     * @return pokud se postava nachází v lokaci, metoda ji vrátí, pokud ne, tak vrací null
     */
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
