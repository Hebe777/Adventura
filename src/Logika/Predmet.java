package Logika;

import java.util.HashMap;
import java.util.Map;

/**
 * Třída Predmet představuje předmět ve hře, který může být přenositelný a může obsahovat další předměty (využito pro kastrol).
 * Tato třída je například využívána pro implementaci kastrolu, do kterého lze vkládat další předměty.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class Predmet {
    private final String nazev;
    private final boolean prenositelny;
    private final Map<String, Predmet> predmety;
    private static final int KAPACITA = 11;

    /**
     * Konstruktor třídy Predmet. Inicializuje předmět s názvem, popisem a informací o přenositelnosti.
     *
     * @param nazev název předmětu
     * @param prenositelny boolean označující, zda je předmět přenositelný
     */
    public Predmet(String nazev, boolean prenositelny) {
        this.nazev = nazev;
        this.prenositelny = prenositelny;

        predmety = new HashMap<>();
    }

    /**
     * Metoda vrací název předmětu.
     *
     * @return název předmětu
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Metoda vrací, zda je předmět přenositelný.
     *
     * @return true, pokud je předmět přenositelný, jinak false
     */
    public boolean isPrenositelny() {
        return prenositelny;
    }

    /**
     * Metoda vkládá předmět do kastrolu. Pokud je kapacita kastrolu plná, nelze předmět vložit.
     *
     * @param predmet předmět, který má být vložen do kastrolu
     * @return true, pokud byl předmět úspěšně vložen, jinak false
     */
    public boolean vlozPredmetDoKastrolu (Predmet predmet) {
        if (predmety.size() < KAPACITA) {
            predmety.put(predmet.getNazev(), predmet);
            return true;
        }
        return false;
    }

    /**
     * Metoda vrací seznam předmětů v předmětu jako textový řetězec.
     *
     * @return textový řetězec obsahující seznam předmětů v kastrolu
     */
    public String seznamPredmetu(){
        StringBuilder text = new StringBuilder("V kastrolu je: ");
        for(String s : predmety.keySet()){
            text.append(s).append(" ");
        }
        return text.toString();
    }

    /**
     * Metoda vrací mapu předmětů obsažených v kastrolu.
     *
     * @return mapa předmětů v kastrolu
     */
    public Map<String, Predmet> getPredmety() {
        return predmety;
    }
}
