package Logika;

/**
 * Třída Postava představuje postavu ve hře.
 *
 * @author Dominik Hebelka
 * @version 2024-25-5
 */
public class Postava {
    private final String jmeno;
    private final String proslov;

    /**
     * Konstruktor třídy Postava. Inicializuje postavu se jménem a proslovem.
     *
     * @param jmeno jméno postavy
     * @param proslov proslov postavy
     */
    public Postava(String jmeno, String proslov) {
        this.jmeno = jmeno;
        this.proslov = proslov;
    }

    /**
     * Metoda vrací jméno postavy.
     * @return jméno postavy
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Metoda vrací proslov postavy.
     * @return proslov postavy
     */
    public String getProslov() {
        return proslov;
    }

}
