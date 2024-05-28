package Logika;
/**
 * Třída HerniSvet vytváří herní svět, který zahrnuje různé lokace a předměty.
 * Třída také spravuje aktuální stav hry, včetně výhry a prohry.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class HerniSvet { // slouží k vytvoření herního světa
    private Lokace aktualniLokace;
    private boolean vyhra;
    private boolean prohra;

    /**
     * Konstruktor třídy HerniSvet. Inicializuje všechny lokace, předměty a propojení mezi nimi.
     */
    public HerniSvet() {
        Lokace strechy = new Lokace("strechy", "Nad hlavami rušného města se tyčí střechy Paříže. Toto místo nabízí úchvatný výhled na město a umožňuje Remyho skrýt se před zraky zvědavců, zatímco plánuje své další kroky.");
        Lokace ulice = new Lokace("ulice", "Živý bulvár plný lidí, malých obchodů a vůně čerstvě pečeného pečiva. Toto místo je živým centrem městského dění a drbů z kulinářského světa.");
        Lokace trziste = new Lokace("trziste", "Centrum města, kde se prodávají čerstvé suroviny. Toto místo je živoucím srdcem lokálního obchodu a setkávání.");
        Lokace zahrada = new Lokace("zahrada", "Klidná oáza uprostřed města s kvetoucími květinami a zelenými keři, kde se nachází také malá vinotéka.");
        Lokace pekarstvi = new Lokace("pekarstvi", "Útulné místo s vůní čerstvého chleba a jiného pečiva. Ideální pro získání pekařských rad a potřebných zásob.");
        Lokace vinoteka = new Lokace("vinoteka", "Malebný obchod nabízející výběr nejlepších vín z celé Francie, vhodných pro zvýšení chuti vařených pokrmů.");
        Lokace zadniUlicky = new Lokace("zadniUlicky","Tajemné a často přehlížené uličky za tržištěm, kde se dají objevit méně běžné suroviny.");
        Lokace farmarskyTrh = new Lokace("farmarskyTrh", "Venkovní trh, kde místní farmáři prodávají vše od čerstvé zeleniny po ručně dělané sýry.");
        Lokace vegetarianskaRestaurace = new Lokace("vegetarianskaRestaurace", "Moderní zařízení s důrazem na zdravou a udržitelnou stravu, nabízející inspiraci pro alternativní způsoby použití zeleniny v receptech.");
        Lokace kuchyn = new Lokace("kuchyn", "Toto místo představuje centrum kulinárního dění, kde se shromažďují všechny ingredience a kuchyňské náčiní nezbytné pro vytvoření skvělých pokrmů.");

        // Suroviny potřebné k splnění receptu
        Predmet kastrol = new Predmet("kastrol", true);
        Predmet cibule = new Predmet("cibule", true);
        Predmet cesnek = new Predmet("cesnek", true);
        Predmet paprika = new Predmet("paprika", true);
        Predmet cuketa = new Predmet("cuketa", true);
        Predmet lilek = new Predmet("lilek", true);
        Predmet rajce = new Predmet("rajce", true);
        Predmet olivovyOlej = new Predmet("olivovyOlej", true);
        Predmet bylinky = new Predmet("bylinky", true);
        Predmet sul = new Predmet("sul", true);
        Predmet pepr = new Predmet("pepr", true);
        Predmet vino = new Predmet("vino", true);

        // Další předměty
        Predmet nuz = new Predmet("nuz", true);
        Predmet vidlicka = new Predmet("vidlicka", true);
        Predmet sklenice = new Predmet("sklenice", true);
        Predmet tvaroh = new Predmet("tvaroh", true);
        Predmet mrkev = new Predmet("mrkev", true);
        Predmet salat = new Predmet("salat", true);
        Predmet citron = new Predmet("citron", true);
        Predmet bageta = new Predmet("bageta", true);
        Predmet vinoBile = new Predmet("vinoBile", true);
        Predmet stul = new Predmet("stul", false);
        Predmet zidle = new Predmet("zidle", false);
        Predmet mlyncekNaPepr = new Predmet("mlyncekNaPepr", false);
        Predmet police = new Predmet("police", false);
        Predmet krb = new Predmet("krb", false);
        Predmet lednice = new Predmet("lednice", false);

        // Postavy
        Postava alfred = new Postava("Alfred", "Ahoj Remy. Rád tě potkávám. Mám pro tebe menší radu. " +
                "\nAle nebude to zadarmo. Abych ti nápovědu řekl, tak mi musíš odpovědět na jednoduchou otázku. \n" +
                "Kolik lahví vína se nachází v jedné krabici?");
        Postava skinner = new Postava("Skinner", "Dávej si na mě bacha ty kryso!");
        Postava colette = new Postava("Colette", "Ahoj Remy. Potřebuješ pomoc?");

        // Propojení lokací
        strechy.pridejVychod(ulice);
        ulice.pridejVychod(strechy);

        ulice.pridejVychod(trziste);
        trziste.pridejVychod(ulice);

        ulice.pridejVychod(zahrada);
        zahrada.pridejVychod(ulice);

        ulice.pridejVychod(pekarstvi);
        pekarstvi.pridejVychod(ulice);

        trziste.pridejVychod(zadniUlicky);
        zadniUlicky.pridejVychod(trziste);

        trziste.pridejVychod(farmarskyTrh);
        farmarskyTrh.pridejVychod(trziste);

        zahrada.pridejVychod(vinoteka);
        vinoteka.pridejVychod(zahrada);

        pekarstvi.pridejVychod(vegetarianskaRestaurace);
        vegetarianskaRestaurace.pridejVychod(pekarstvi);

        farmarskyTrh.pridejVychod(kuchyn);
        kuchyn.pridejVychod(farmarskyTrh);

        // Přidání postav
        trziste.pridejPostavu(alfred);
        kuchyn.pridejPostavu(skinner);
        kuchyn.pridejPostavu(colette);

        // Rozmístění předmětů do lokací
        strechy.pridejPredmet(kastrol);
        strechy.pridejPredmet(olivovyOlej);
        strechy.pridejPredmet(pepr);

        ulice.pridejPredmet(cibule);
        ulice.pridejPredmet(cesnek);
        ulice.pridejPredmet(stul);
        ulice.pridejPredmet(zidle);

        trziste.pridejPredmet(paprika);
        trziste.pridejPredmet(cuketa);
        trziste.pridejPredmet(mlyncekNaPepr);

        zahrada.pridejPredmet(lilek);
        zahrada.pridejPredmet(rajce);
        zahrada.pridejPredmet(krb);

        pekarstvi.pridejPredmet(bageta);
        pekarstvi.pridejPredmet(vidlicka);
        pekarstvi.pridejPredmet(sul);
        pekarstvi.pridejPredmet(sklenice);

        vinoteka.pridejPredmet(vino);
        vinoteka.pridejPredmet(vinoBile);
        vinoteka.pridejPredmet(police);
        vinoteka.pridejPredmet(zidle);

        zadniUlicky.pridejPredmet(bylinky);
        zadniUlicky.pridejPredmet(nuz);
        zadniUlicky.pridejPredmet(citron);

        farmarskyTrh.pridejPredmet(mrkev);
        farmarskyTrh.pridejPredmet(salat);
        farmarskyTrh.pridejPredmet(police);
        farmarskyTrh.pridejPredmet(stul);

        vegetarianskaRestaurace.pridejPredmet(citron);
        vegetarianskaRestaurace.pridejPredmet(tvaroh);
        vegetarianskaRestaurace.pridejPredmet(zidle);
        vegetarianskaRestaurace.pridejPredmet(krb);

        kuchyn.pridejPredmet(nuz);
        kuchyn.pridejPredmet(mlyncekNaPepr);
        kuchyn.pridejPredmet(vidlicka);
        kuchyn.pridejPredmet(sklenice);
        kuchyn.pridejPredmet(lednice);
        kuchyn.pridejPredmet(stul);

        aktualniLokace = strechy;
    }

    /**
     * Metoda vrací aktuální lokaci.
     * @return aktuální lokace
     */
    public Lokace getAktualniLokace() {
        return aktualniLokace;
    }

    /**
     * Metoda zjišťuje, zda hráč vyhrál.
     *
     * @return true, pokud hráč vyhrál, jinak false
     */
    public boolean isVyhra() {
        return vyhra;
    }

    /**
     * Metoda nastavuje stav výhry.
     *
     * @param vyhra true, pokud hráč vyhrál, jinak false
     */
    public void setVyhra(boolean vyhra) {
        this.vyhra = vyhra;
    }

    /**
     * Metoda zjišťuje, zda hráč prohrál.
     *
     * @return true, pokud hráč prohrál, jinak false
     */
    public boolean isProhra() {
        return prohra;
    }

    /**
     * Metoda nastavuje stav prohry.
     *
     * @param prohra true, pokud hráč prohrál, jinak false
     */
    public void setProhra(boolean prohra) {
        this.prohra = prohra;
    }

    /**
     * Metoda nastavuje aktuální lokaci.
     *
     * @param aktualniLokace lokace, která má být nastavena jako aktuální
     */
    public void setAktualniLokace(Lokace aktualniLokace) {
        this.aktualniLokace = aktualniLokace;
    }

    /**
     * Metoda vrací aktuální stav hry.
     *
     * @return StavHry.VYHRA pokud hráč vyhrál, StavHry.PROHRA pokud hráč prohrál, jinak StavHry.HRA_BEZI
     */
    public StavHry getStav() {
        if(isVyhra()) {
            return StavHry.VYHRA;
        }

        if(isProhra()) {
            return StavHry.PROHRA;
        }

        return StavHry.HRA_BEZI;
    }
}
