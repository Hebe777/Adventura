package Logika;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrikazObsahKastrolu implements IPrikaz{
    private Hra hra;

    public PrikazObsahKastrolu(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String getNazev() {
        return "obsah_kastrolu";
    }

    @Override
    public String proved(String[] parametryPrikazu) {
        Lokace aktualniLokace = hra.getHerniSvet().getAktualniLokace();
        Set<String> inventar = hra.getInventar().getObsahBatohu().keySet();
        Predmet kastrol = aktualniLokace.vratPredmet("kastrol");

        if(!aktualniLokace.getNazev().equals("kuchyn")){
            return "Aby jsi mohl vidět co je v kastrolu, tak se musíš nacházet v kuchyni.";
        }

        if(kastrol == null){
            return "Nejdříve musíš najít kastrol.";
        }

        String text = "V kastrolu se nachází tyto ingredience: ";


        return "Vše v pořádku";
    }
}
