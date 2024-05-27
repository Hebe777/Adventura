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
        Lokace zadni_ulicky = new Lokace("zadni_ulicky","Tajemné a často přehlížené uličky za tržištěm, kde se dají objevit méně běžné suroviny.");
        Lokace farmarsky_trh = new Lokace("farmarsky_trh", "Venkovní trh, kde místní farmáři prodávají vše od čerstvé zeleniny po ručně dělané sýry.");
        Lokace vegetarianska_restaurace = new Lokace("vegetarianska_restaurace", "Moderní zařízení s důrazem na zdravou a udržitelnou stravu, nabízející inspiraci pro alternativní způsoby použití zeleniny v receptech.");
        Lokace kuchyn = new Lokace("kuchyn", "Toto místo představuje centrum kulinárního dění, kde se shromažďují všechny ingredience a kuchyňské náčiní nezbytné pro vytvoření skvělých pokrmů.");

        // Suroviny potřebné k splnění receptu
        Predmet kastrol = new Predmet("kastrol", "Velký hrnec na vaření, ideální pro přípravu polévek nebo dušených pokrmů", true);
        Predmet cibule = new Predmet("cibule", "Základ mnoha pokrmů, cibule přidává jídlu bohatou a hlubokou chuť. Je nezbytnou součástí mnoha receptů a v ratatouille slouží jako aromatický základ.", true);
        Predmet cesnek = new Predmet("cesnek", "Svou silnou a charakteristickou chutí dodává česnek jídlu pikantní hloubku. Používá se v malém množství, ale jeho vliv na celkovou chuť je nezaměnitelný.", true);
        Predmet paprika = new Predmet("paprika", "Papriky přinášejí do ratatouille sladkost a barvu. Červené, zelené a žluté varianty zajišťují vizuální pestrost a jemnou chuť.", true);
        Predmet cuketa = new Predmet("cuketa", "Cukety dodávají jídlu šťavnatost a jsou skvělé pro absorbování ostatních chutí v pokrmu. Jejich jemná textura se dobře kombinuje s ostatními surovinami.", true);
        Predmet lilek = new Predmet("lilek", "Lilek je srdcem ratatouille, poskytuje masitou texturu a schopnost nasáknout se omáčkou a chutěmi z ostatních ingrediencí.", true);
        Predmet rajce = new Predmet("rajce", "Rajčata jsou klíčovou ingrediencí pro vytvoření bohaté a šťavnaté omáčky v ratatouille. Přidávají potřebnou kyselost a hloubku.", true);
        Predmet olivovy_olej = new Predmet("olivovy_olej", "Olivový olej je esenciální pro sautéing surovin a dodává jídlu bohatý podkladový tón. Tento olej také pomáhá propojit chutě ostatních surovin.", true);
        Predmet bylinky = new Predmet("bylinky", "Čerstvé bylinky jako tymián, rozmarýn a bazalka přidávají ratatouille svěží a aromatický nádech, který zvyšuje celkovou chuť jídla.", true);
        Predmet sul = new Predmet("sul", "Sůl je základní koření, které je nezbytné ve většině receptů, včetně ratatouille.", true);
        Predmet pepr = new Predmet("pepr", "Pepř dodává jídlu jemnou pikantnost a komplexnost, která může zintenzivnit celkovou chuťovou paletu pokrmu.", true);
        Predmet vino = new Predmet("vino", "Tajná přísada pro bonusovou výhru, víno zvýší chuť jídla, přidává bohatost a hloubku omáčce, a zároveň poskytuje jemný alkoholový podtón.", true);

        // Další předměty
        Predmet nuz = new Predmet("nuz", "Ostrý kuchyňský nůž, nezbytný nástroj pro krájení a přípravu ingrediencí.", true);
        Predmet vidlicka = new Predmet("vidlicka", "Základní jídelní nástroj pro manipulaci s jídlem.", true);
        Predmet sklenice = new Predmet("sklenice", "Sklenice na vodu nebo víno.", true);
        Predmet tvaroh = new Predmet("tvaroh", "Čerstvý tvaroh, ideální pro dezerty nebo slané pokrmy.", true);
        Predmet mrkev = new Predmet("mrkev", "Čerstvá mrkev, křupavá a sladká, vhodná do salátů nebo jako příloha.", true);
        Predmet salat = new Predmet("salat", "Zelený salát, nezbytný pro svěží saláty nebo jako příloha.", true);
        Predmet citron = new Predmet("citron", "Citron pro dochucení pokrmů nebo nápojů.", true);
        Predmet bageta = new Predmet("bageta", "Čerstvě upečená bageta, skvělá k snídani nebo jako příloha.", true);
        Predmet vino_bile = new Predmet("vino_bile", "Láhev bílého vína, ideální pro lehké pokrmy nebo jako doplněk k rybám.", true);
        Predmet stul = new Predmet("stul", "Velký jídelní stůl, vhodný pro servírování jídla.", false);
        Predmet zidle = new Predmet("zidle", "Pohodlná židle k jídelnímu stolu.", false);
        Predmet mlyncek_na_pepr = new Predmet("mlyncek_na_pepr", "Ruční mlýnek na pepř, který umožňuje čerstvě mletý pepř pro intenzivní chuť.", false);
        Predmet police = new Predmet("police", "Dřevěná police na uskladnění kuchyňských potřeb.", false);
        Predmet krb = new Predmet("krb", "Krb, který dodává místnosti teplo a atmosféru.", false);
        Predmet lednice = new Predmet("lednice", "Chladnička pro uchování čerstvých potravin.", false);

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

        trziste.pridejVychod(zadni_ulicky);
        zadni_ulicky.pridejVychod(trziste);

        trziste.pridejVychod(farmarsky_trh);
        farmarsky_trh.pridejVychod(trziste);

        zahrada.pridejVychod(vinoteka);
        vinoteka.pridejVychod(zahrada);

        pekarstvi.pridejVychod(vegetarianska_restaurace);
        vegetarianska_restaurace.pridejVychod(pekarstvi);

        farmarsky_trh.pridejVychod(kuchyn);
        kuchyn.pridejVychod(farmarsky_trh);

        // Přidání postav
        vinoteka.pridejPostavu(alfred);
        kuchyn.pridejPostavu(skinner);
        kuchyn.pridejPostavu(colette);

        // Rozmístění předmětů do lokací
        strechy.pridejPredmet(kastrol);
        strechy.pridejPredmet(olivovy_olej);
        strechy.pridejPredmet(pepr);

        ulice.pridejPredmet(cibule);
        ulice.pridejPredmet(cesnek);
        ulice.pridejPredmet(stul);
        ulice.pridejPredmet(zidle);

        trziste.pridejPredmet(paprika);
        trziste.pridejPredmet(cuketa);
        trziste.pridejPredmet(mlyncek_na_pepr);

        zahrada.pridejPredmet(lilek);
        zahrada.pridejPredmet(rajce);
        zahrada.pridejPredmet(krb);

        pekarstvi.pridejPredmet(bageta);
        pekarstvi.pridejPredmet(vidlicka);
        pekarstvi.pridejPredmet(sul);
        pekarstvi.pridejPredmet(sklenice);

        vinoteka.pridejPredmet(vino);
        vinoteka.pridejPredmet(vino_bile);
        vinoteka.pridejPredmet(police);
        vinoteka.pridejPredmet(zidle);

        zadni_ulicky.pridejPredmet(bylinky);
        zadni_ulicky.pridejPredmet(nuz);
        zadni_ulicky.pridejPredmet(citron);

        farmarsky_trh.pridejPredmet(mrkev);
        farmarsky_trh.pridejPredmet(salat);
        farmarsky_trh.pridejPredmet(police);
        farmarsky_trh.pridejPredmet(stul);

        vegetarianska_restaurace.pridejPredmet(citron);
        vegetarianska_restaurace.pridejPredmet(tvaroh);
        vegetarianska_restaurace.pridejPredmet(zidle);
        vegetarianska_restaurace.pridejPredmet(krb);

        kuchyn.pridejPredmet(nuz);
        kuchyn.pridejPredmet(mlyncek_na_pepr);
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
