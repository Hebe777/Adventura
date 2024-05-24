package Logika;

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
        Predmet kastrol = aktualniLokace.vratPredmet("kastrol");

        if(!aktualniLokace.getNazev().equals("kuchyn")){
            return "Aby jsi mohl vidět co je v kastrolu, tak se musíš nacházet v kuchyni.";
        }

        if(kastrol == null){
            return "Nejdříve musíš najít kastrol.";
        }

        return kastrol.seznamPredmetu();
    }
}
