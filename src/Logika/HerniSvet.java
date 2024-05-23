package Logika;

public class HerniSvet { // slouží k vytvoření herního světa
    private Lokace aktualniLokace;

    public HerniSvet() {
        Lokace dum = new Lokace("dum", "Tady bydlíš, proto tu začíname");
        Lokace les = new Lokace("les", "Obyčejny les, rostou tu houby");
        Lokace temnyLes = new Lokace("temny_les", "Temný les, necítíš se tady dobře");
        Lokace jeskyne = new Lokace("jeskyne", "Říká se, že tady bydlí vlk!");
        Lokace chaloupka = new Lokace("chaloupka", "Tady bydlí babička");

        Predmet hrib = new Predmet("hrib", "Krásný hříbek", true);
        Predmet hrib2 = new Predmet("hrib2", "Krásný hříbek2", true);
        Predmet hrib3 = new Predmet("hrib3", "Krásný hříbek2", true);
        Predmet hrib4 = new Predmet("hrib4", "Krásný hříbek2", true);
        Predmet hrib11 = new Predmet("hrib11", "Krásný hříbek", true);
        Predmet hrib5 = new Predmet("hrib5", "Krásný hříbek2", true);
        Predmet hrib6 = new Predmet("hrib6", "Krásný hříbek2", true);
        Predmet hrib7 = new Predmet("hrib7", "Krásný hříbek2", true);
        Predmet hrib12 = new Predmet("hrib12", "Krásný hříbek", true);
        Predmet hrib8 = new Predmet("hrib8", "Krásný hříbek2", true);
        Predmet hrib9 = new Predmet("hrib9", "Krásný hříbek2", true);
        Predmet hrib10 = new Predmet("hrib10", "Krásný hříbek2", true);
        les.pridejPredmet(hrib);
        jeskyne.pridejPredmet(hrib2);
        jeskyne.pridejPredmet(hrib3);
        jeskyne.pridejPredmet(hrib4);
        jeskyne.pridejPredmet(hrib5);
        jeskyne.pridejPredmet(hrib7);
        jeskyne.pridejPredmet(hrib8);
        jeskyne.pridejPredmet(hrib9);
        jeskyne.pridejPredmet(hrib10);
        jeskyne.pridejPredmet(hrib11);
        jeskyne.pridejPredmet(hrib12);

        dum.pridejVychod(les);
        les.pridejVychod(dum);

        les.pridejVychod(temnyLes);
        temnyLes.pridejVychod(les);

        temnyLes.pridejVychod(jeskyne); //sežere mě vlk a nic mi nepomůže

        temnyLes.pridejVychod(chaloupka);
        chaloupka.pridejVychod(temnyLes);


        aktualniLokace = dum;
    }

    public Lokace getAktualniLokace() {
        return aktualniLokace;
    }

    public void setAktualniLokace(Lokace aktualniLokace) {
        this.aktualniLokace = aktualniLokace;
    }

    public StavHry getStav(){
        if (aktualniLokace.getNazev().equals("lod")){
            return StavHry.VYHRA;
        }

        if (aktualniLokace.getNazev().equals("lod")){
            return StavHry.PROHRA;
        }

        return StavHry.HRA_BEZI;
    }
}
