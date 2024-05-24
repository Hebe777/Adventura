package Logika;

import java.util.HashMap;
import java.util.Map;

public class Inventar {
    private static final int KAPACITA = 11;

    private Map<String, Predmet> obsahBatohu;

    public Inventar() {
        obsahBatohu = new HashMap<>();
    }

    public boolean vlozDoInventare(Predmet predmet){
        if(obsahBatohu.size() < KAPACITA){
            obsahBatohu.put(predmet.getNazev(), predmet);
            return true;
        }
        return false;
    }

    public boolean odeberZInventare(Predmet predmet) {
        if(obsahBatohu.containsKey(predmet.getNazev())){
            obsahBatohu.remove(predmet);
            return true;
        }
        return false;
    }

    public Map<String, Predmet> getObsahBatohu() {
        return obsahBatohu;
    }

    public String zobrazInventar(){
        String text = "Aktualně máš v invetáři tyto předměty: ";

        for(Predmet p : obsahBatohu.values()){
            text += p.getNazev() + " ";
        }

        if(text.length() < 40){
            return "Inventář je prázdný.";
        }

        return text;
    }

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
