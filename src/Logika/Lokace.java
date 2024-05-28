package Logika;

import java.util.HashSet;
import java.util.Set;
/**
 * Třída Lokace představuje prostory ve hře, mezi kterými se postava může pohybovat.
 * Lokace může obsahovat předměty a postavy a může mít východy do jiných lokací.
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
     * Konstruktor pro vytvoření lokace s daným názvem a popisem.
     *
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

    /**
     * Vrací název lokace.
     *
     * @return Název lokace
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Vrací popis lokace, včetně seznamu východů, předmětů a postav v lokaci.
     *
     * @return Řetězec s popisem lokace
     */
    public String getPopis() {
        StringBuilder nazvyVychodu = new StringBuilder("Místnosti: ");
        for(Lokace l : vychody){
            nazvyVychodu.append(l.getNazev()).append(" ");
        }

        StringBuilder seznamPredmetu = new StringBuilder("Předměty: ");
        for(Predmet p : predmety){
            seznamPredmetu.append(p.getNazev()).append(" ");
        }

        StringBuilder seznamPostav = new StringBuilder("Postavy: ");
        for(Postava p : postavy){
            seznamPostav.append(p.getJmeno()).append(" ");
        }

        if(nazvyVychodu.length() < 12){
            nazvyVychodu = new StringBuilder("Z této místnosti nevede žádná cesta");
        }

        if(seznamPredmetu.length() < 11){
            seznamPredmetu = new StringBuilder("V této místnosti se nenachází žádný předmět");
        }

        if(seznamPostav.length() < 10){
            seznamPostav = new StringBuilder("V této místnosti se nenachází žádná postava");
        }

        return "Právě se nacházíš v místnosti '" + nazev + "'.\n" +
                popis + "\n\n" + nazvyVychodu + "\n" + seznamPredmetu + "\n" + seznamPostav;
    }

    /**
     * Přidá východ do této lokace.
     *
     * @param cilovaLokace Lokace, do které tento východ vede
     * @return true, pokud se podaří východ přidat; false, pokud se přidání nepodaří
     */
    public boolean pridejVychod(Lokace cilovaLokace) {
        return vychody.add(cilovaLokace);
    }

    /**
     * Kontroluje, zda se z této lokace dá jít do lokace zadané v parametru.
     *
     * @param nazevLokace Název lokace, do které chceme jít
     * @return true, pokud se do lokace dá jít; false, pokud se nedá
     */
    public boolean maVychod(String nazevLokace){
        for(Lokace l : vychody){
            if(l.getNazev().equals(nazevLokace)){
                return true;
            }
        }
        return false;
    }

    /**
     * Vrací sadu východů z této lokace.
     *
     * @return Sada východů
     */
    public Set<Lokace> getVychody() {
        return vychody;
    }

    /**
     * Vrací sadu postav v této lokaci.
     *
     * @return Sada postav
     */
    public Set<Postava> getPostavy() {
        return postavy;
    }

    /**
     * Vrací lokaci, která odpovídá názvu v parametru, pokud se tato lokace nachází mezi východy.
     *
     * @param nazevLokace Název hledané lokace
     * @return Lokace, pokud se nachází mezi východy; null, pokud se nenachází
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
     * Vrací předmět s daným názvem, pokud se nachází v této lokaci.
     *
     * @param nazevPredmetu Název hledaného předmětu
     * @return Předmět, pokud se nachází v této lokaci; null, pokud se nenachází
     */
    public Predmet vratPredmet(String nazevPredmetu){
        for(Predmet p : predmety){
            if(p.getNazev().equals(nazevPredmetu)){
                return p;
            }
        }
        return null;
    }

    /**
     * Vrací sadu předmětů v této lokaci.
     *
     * @return Sada předmětů
     */
    public Set<Predmet> getPredmety() {
        return predmety;
    }

    /**
     * Přidá předmět do této lokace.
     *
     * @param predmet Předmět, který bude vložen
     * @return true, pokud se předmět podaří přidat; false, pokud se nepodaří
     */
    public boolean pridejPredmet(Predmet predmet) {
        return predmety.add(predmet);
    }

    /**
     * Odebere předmět z této lokace.
     *
     * @param predmet Předmět, který bude odebrán
     * @return true, pokud se předmět podaří odebrat; false, pokud se nepodaří
     */
    public boolean odeberPredmet(Predmet predmet){
        return predmety.remove(predmet);
    }

    /**
     * Přidá postavu do této lokace.
     *
     * @param postava Postava, která bude přidána
     */
    public void pridejPostavu(Postava postava) {
        postavy.add(postava);
    }

    /**
     * Zjistí, zda se v lokaci nachází postava se zadaným jménem.
     *
     * @param jmeno Jméno hledané postavy
     * @return Postava, pokud se nachází v lokaci; null, pokud se nenachází
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
