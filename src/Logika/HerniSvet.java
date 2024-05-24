package Logika;

public class HerniSvet { // slouží k vytvoření herního světa
    private Lokace aktualniLokace;
    private boolean vyhra;

    public HerniSvet() {
        Lokace dum = new Lokace("dum", "Tady bydlíš, proto tu začíname");
        Lokace les = new Lokace("les", "Obyčejny les, rostou tu houby");
        Lokace kuchyn = new Lokace("kuchyn", "kuchyn");
        Lokace temnyLes = new Lokace("temny_les", "Temný les, necítíš se tady dobře");
        Lokace jeskyne = new Lokace("jeskyne", "Říká se, že tady bydlí vlk!");
        Lokace chaloupka = new Lokace("chaloupka", "Tady bydlí babička");

        Predmet kastrol = new Predmet("kastrol", "kastrol", true);
        Predmet cibule = new Predmet("cibule", "Krásný hříbek2", true);
        Predmet cesnek = new Predmet("cesnek", "Krásný hříbek2", true);
        Predmet paprika = new Predmet("paprika", "Krásný hříbek2", true);
        Predmet cuketa = new Predmet("cuketa", "Krásný hříbek", true);
        Predmet lilek = new Predmet("lilek", "Krásný hříbek2", true);
        Predmet rajce = new Predmet("rajce", "Krásný hříbek2", true);
        Predmet olivovy_olej = new Predmet("olivovy_olej", "Krásný hříbek2", true);
        Predmet bylinky = new Predmet("bylinky", "Krásný hříbek", true);
        Predmet sul = new Predmet("sul", "Krásný hříbek2", true);
        Predmet pepr = new Predmet("pepr", "Krásný hříbek2", true);
        Predmet vino = new Predmet("vino", "Krásný hříbek2", true);
        les.pridejPredmet(kastrol);
        les.pridejPredmet(cibule);
        jeskyne.pridejPredmet(cesnek);
        jeskyne.pridejPredmet(paprika);
        jeskyne.pridejPredmet(cuketa);
        jeskyne.pridejPredmet(lilek);
        jeskyne.pridejPredmet(rajce);
        jeskyne.pridejPredmet(olivovy_olej);
        jeskyne.pridejPredmet(bylinky);
        jeskyne.pridejPredmet(sul);
        jeskyne.pridejPredmet(pepr);
        jeskyne.pridejPredmet(vino);

        les.pridejVychod(jeskyne);
        jeskyne.pridejVychod(les);

        dum.pridejVychod(les);
        les.pridejVychod(dum);

        les.pridejVychod(kuchyn);
        kuchyn.pridejVychod(les);

        les.pridejVychod(temnyLes);
        temnyLes.pridejVychod(les);

        temnyLes.pridejVychod(jeskyne); //sežere mě vlk a nic mi nepomůže

        temnyLes.pridejVychod(chaloupka);
        chaloupka.pridejVychod(temnyLes);

        les.pridejPostavu(new Postava("Alfred", "Ahoj Remy. Rád tě potkávám. Mám pro tebe menší radu. " +
                "\nAle nebude to zadarmo. Abych ti nápovědu řekl, tak mi musíš odpovědět na jednoduchou otázku. \n" +
                "Kolik lahví vína se nachází v jedné krabici?"));

        les.pridejPostavu(new Postava("Karel", "Ahoj Remy. Rád tě potkávám. Mám pro tebe menší radu. " +
                "\nPokud chceš přidat svému ratatouille, přidej do něj kapičku dobrého vína. Za rohem je vinárna, běž se tam kouknout."));

        kuchyn.pridejPostavu(new Postava("Colette", "Ahoj Remy. Potřebuješ pomoc?"));

        aktualniLokace = dum;
    }

    public Lokace getAktualniLokace() {
        return aktualniLokace;
    }

    public boolean isVyhra() {
        return vyhra;
    }

    public void setVyhra(boolean vyhra) {
        this.vyhra = vyhra;
    }

    public void setAktualniLokace(Lokace aktualniLokace) {
        this.aktualniLokace = aktualniLokace;
    }

    public StavHry getStav(){
        if (aktualniLokace.getNazev().equals("kuchyn") && isVyhra()){
            return StavHry.VYHRA;
        }

        if (aktualniLokace.getNazev().equals("lod")){
            return StavHry.PROHRA;
        }

        return StavHry.HRA_BEZI;
    }
}
