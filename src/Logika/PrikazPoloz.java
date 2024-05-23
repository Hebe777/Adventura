package Logika;

public class PrikazPoloz implements IPrikaz{
    private Hra hra;

    public PrikazPoloz(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String getNazev() {
        return "poloz";
    }

    @Override
    public String proved(String[] parametryPrikazu) {
        if(parametryPrikazu.length < 0){
            return "Musíš zadat, jaký předmět chceš položit.";
        }

        if(parametryPrikazu.length > 1){
            return "Neumím položit více než jeden předmět.";
        }

        String parametr = parametryPrikazu[0];
        Lokace aktualniLokace = hra.getHerniSvet().getAktualniLokace();
        Inventar inventar = hra.getInventar();
        Predmet predmet = hra.getInventar().getObsahBatohu().get(parametr);

        if(predmet == null){
            return "Předmět '" + parametr + "' nemáš v batohu.";
        }

        if(!inventar.odeberZInventare(predmet)){
            return "Předmět '" + predmet.getNazev() + "' se nepodařilo položit.";
        }

        aktualniLokace.pridejPredmet(predmet);
        return "Předmět '" + predmet.getNazev() + "' byl položen v lokaci '" + aktualniLokace.getNazev() + "'. ";
    }
}
