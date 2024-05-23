package Logika;

public class PrikazSeber implements IPrikaz{
    private Hra hra;

    public PrikazSeber(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String getNazev() {
        return "seber";
    }

    @Override
    public String proved(String[] parametryPrikazu) {
        if(parametryPrikazu.length < 1){
            return "Musíš mi říct, co mám sebrat.";
        }

        if(parametryPrikazu.length > 1){
            return "Omlouvám se, ale neumím sebrat najednou více věcí.";
        }

        Lokace aktualniLokace =  hra.getHerniSvet().getAktualniLokace();
        String nazev = parametryPrikazu[0];
        Predmet predmet = aktualniLokace.vratPredmet(nazev);

        if(predmet == null){
            return "Předmět '" + nazev + "' se v místnosti '" + aktualniLokace.getNazev() + "' nenachází.";
        }

        if(!predmet.isPrenositelny()){
            return "Předmět '" + nazev + "' se nedá vzít.";
        }

        if(hra.getInventar().vlozDoInventare(predmet)){
            aktualniLokace.odeberPredmet(predmet);
            return "Sebral jsi předmět '" + predmet.getNazev() + "' a vložil ho do inventáře.";
        }
        return "Bohužel máš plný inventář.";
    }
}
