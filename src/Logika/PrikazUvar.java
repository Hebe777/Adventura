package Logika;

import java.util.*;

/**
 * Třída PrikazUvar implementuje příkaz "uvar" pro hru.
 * Tento příkaz umožňuje hráči uvařit pokrm, pokud jsou všechny potřebné ingredience v kastrolu v kuchyni.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazUvar implements IPrikaz{
    private final Hra hra;

    /**
     * Konstruktor třídy PrikazUvar. Inicializuje příkaz s odkazem na aktuální hru.
     *
     * @param hra aktuální instance hry
     */
    public PrikazUvar(Hra hra) {
        this.hra = hra;
    }

    /**
     * Metoda vrací název příkazu.
     *
     * @return název příkazu "uvar"
     */
    @Override
    public String getNazev() {
        return "uvar";
    }

    /**
     * Metoda provádí příkaz "uvar". Slouží ke spuštění procesu vaření, podle toho zda
     * jsou všechny potřebné ingredience v kastrolu v kuchyni, buď vyhrává nebo prohrává hru.
     *
     * @param parametryPrikazu pole parametrů příkazu (není očekáván žádný parametr)
     * @return textový výsledek provedení příkazu
     */
    @Override
    public String proved(String[] parametryPrikazu) {
        Lokace aktualniLokace = hra.getHerniSvet().getAktualniLokace();
        Predmet kastrol = aktualniLokace.vratPredmet("kastrol");

        if(!aktualniLokace.getNazev().equals("kuchyn")){
            return "Aby jsi mohl vařit musiš být v kuchyni!";
        }

        if(kastrol == null){
            return "Collete: Aby jsi se mnou mohl mluvit musíš nejdříve najít kastrol.";
        }


        Map<String, Predmet> ingredience = kastrol.getPredmety();
        if(ingredience.containsKey("cibule") && ingredience.containsKey("cesnek") && ingredience.containsKey("paprika")
            && ingredience.containsKey("cuketa") && ingredience.containsKey("lilek") && ingredience.containsKey("rajce")
            && ingredience.containsKey("olivovyOlej") && ingredience.containsKey("bylinky") && ingredience.containsKey("sul")
            && ingredience.containsKey("pepr")){
            if(ingredience.containsKey("vino")){
                hra.getHerniSvet().setVyhra(true);
                hra.setHraSkoncila(true);
                return "Gratuluji, vyhrál(a) jsi! Koukám, že jsi našel i víno. Získáváš pro tedy i bonusové body.";
            }
            hra.setHraSkoncila(true);
            hra.getHerniSvet().setVyhra(true);
            return "Gratuluji, vyhrál(a) jsi! Všechny potřebné suroviny jsi našel.";
        }else{
            hra.setHraSkoncila(true);
            hra.getHerniSvet().setProhra(true);

            if(ingredience.size() < 10){
                StringBuilder builder = new StringBuilder();
                List<String> recept = new ArrayList<>(Arrays.asList("cibule","cesnek","paprika","cuketa","lilek","rajce","olivovyOlej","bylinky","sul","pepr"));
                for(String s : kastrol.getPredmety().keySet()){
                    recept.remove(s);
                }
                for (String r : recept){
                    builder.append(r).append(" ");
                }
                return "Bohužel jsi prohrál(a). Chyběli ti tyto ingerdience: " + recept;
            }
            return "Bohužel jsi prohrál(a). Použil jsi špatné ingredience.";
        }
    }
}
