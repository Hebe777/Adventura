package Logika;

import java.util.HashMap;
import java.util.Map;

/**
 * Třída Inventar představuje inventář hráče, který slouží k uchovávání předmětů.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class Inventar {
    private static final int KAPACITA = 11;

    private final Map<String, Predmet> obsahBatohu;

    /**
     * Konstruktor třídy Inventar. Inicializuje prázdný inventář.
     */
    public Inventar() {
        obsahBatohu = new HashMap<>();
    }

    /**
     * Metoda přidává předmět do inventáře, pokud je v něm dostatek místa.
     *
     * @param predmet předmět, který má být vložen do inventáře
     * @return true, pokud byl předmět úspěšně vložen, jinak false
     */
    public boolean vlozDoInventare(Predmet predmet){
        if(obsahBatohu.size() < KAPACITA){
            obsahBatohu.put(predmet.getNazev(), predmet);
            return true;
        }
        return false;
    }
    /**
     * Metoda odebírá předmět z inventáře.
     *
     * @param predmet předmět, který má být odebrán z inventáře
     * @return true, pokud byl předmět úspěšně odebrán, jinak false
     */
    public boolean odeberZInventare(Predmet predmet) {
        if(obsahBatohu.containsKey(predmet.getNazev())){
            obsahBatohu.remove(predmet.getNazev());
            return true;
        }
        return false;
    }

    /**
     * Metoda vrací obsah inventáře jako mapu předmětů.
     *
     * @return mapa předmětů v inventáři
     */
    public Map<String, Predmet> getObsahBatohu() {
        return obsahBatohu;
    }

    /**
     * Metoda vrací textový popis obsahu inventáře.
     *
     * @return textový popis obsahu inventáře
     */
    public String zobrazInventar(){
        StringBuilder text = new StringBuilder("Aktualně máš v invetáři tyto předměty: ");

        for(Predmet p : obsahBatohu.values()){
            text.append(p.getNazev()).append(" ");
        }

        if(text.length() < 40){
            return "Inventář je prázdný.";
        }

        return text.toString();
    }

    /**
     * Metoda odebírá předmět z inventáře na základě jeho názvu a odstraňuje ho z inventáře.
     *
     * @param jmenoVeci název předmětu, který má být odebrán
     * @return vybraný předmět, pokud se nachází v inventáři, jinak null
     */
    public Predmet vyberVecVBatohu(String jmenoVeci) {
        Predmet predmet;
        if (obsahBatohu.containsKey(jmenoVeci)) {
            predmet = obsahBatohu.get(jmenoVeci);
            obsahBatohu.remove(jmenoVeci);
            return predmet;
        }
        return null;
    }

}
