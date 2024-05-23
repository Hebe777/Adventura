package Logika;

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
        String kastrol = null;
        if(!aktualniLokace.getNazev().equals("kuchyn")){
            return "Aby jsi mohl vidět co je v kastrolu, tak se musíš nacházet v kuchyni.";
        }

        for(String s : inventar){
            if(s.equals("kastrol")){
                kastrol = s;
            }
        }

        for (Predmet p : aktualniLokace.getPredmety()){
            if(p.getNazev().equals("kastrol")){
                kastrol = p.getNazev();
            }
        }
        if(kastrol == null){
            return "Není tu kastrol.";
        }
        return "Vše v pořádku";
    }
}
