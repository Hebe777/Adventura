package Logika;

import java.util.*;

public class PrikazUvar implements IPrikaz{
    private Hra hra;

    public PrikazUvar(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String getNazev() {
        return "uvar";
    }

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
            && ingredience.containsKey("olivovy_olej") && ingredience.containsKey("bylinky") && ingredience.containsKey("sul")
            && ingredience.containsKey("pepr")){
            if(ingredience.containsKey("vino")){
                hra.getHerniSvet().setVyhra(true);
                hra.setHraSkoncila(true);
                return "Gratuluji vyhrál(a) jsi! Koukám, že jsi našel i víno. Získáváš pro tedy i bonusové body.";
            }
            hra.setHraSkoncila(true);
            hra.getHerniSvet().setVyhra(true);
            return "Gratuluji vyhrál(a) jsi! Všechny potřebné suroviny jsi našel.";
        }else{
            hra.setHraSkoncila(true);
            hra.getHerniSvet().setProhra(true);
            return "Bohužel jsi prohrál(a). Buďto ti nějaké ingredience chybí a nebo jsi přidal nějaké špatné ingredience.";
        }
    }
}
