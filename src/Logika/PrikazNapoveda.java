package Logika;

/**
 * Třída PrikazNapoveda implementuje příkaz "napoveda" pro hru.
 * Tento příkaz poskytuje hráči nápovědu o cílech hry a dostupných příkazech.
 *
 * @author Dominik Hebelka
 * @version 2024-25-05
 */
public class PrikazNapoveda implements IPrikaz{

    /**
     * Metoda vrací název příkazu.
     *
     * @return název příkazu "napoveda"
     */
    @Override
    public String getNazev(){
        return "napoveda";
    }

    /**
     * Metoda provádí příkaz "napoveda". Poskytuje hráči informace o cílech hry a dostupných příkazech.
     *
     * @param parametryPrikazu pole parametrů příkazu (není očekáván žádný parametr)
     * @return textový výsledek provedení příkazu s nápovědou
     */
    @Override
    public String proved(String[] parametryPrikazu){
        return "Tvým úkolem je najít kastrol a poté sesbírat všechny ingredience potřebné k uvaření ratatouille.\n"
                + "Následně všechny správné ingredience vložit do kastrolu v kuchyni a využít přikaz uvar." +
                " Dávej si bacha, ingredience co jsou v kastrolu už nemůžeš vyndat!\n"
                + "Pokud použiješ správné suroviny, hra končí tvým triumfem. Je zde i možnost bonusové výhry. \nV opačném případě tě Skinner z kuchyně"
                + " vyhodí a ty prohraješ. Další možnost prohry je pokud překročíš limit 30 průchodů mezi lokacemi.\n"
                + "S receptem ti pomůže Colette, neváhej se ji zeptat.\n\n" +
                "Seznam příkazů:\n" +
                "- jdi [místo] – Slouží k pohybu mezi lokacemi. Po přechodu vypíše další možné východy.\n" +
                "- rozhledni_se – Rozhledneš se po lokaci a vypíší se všechny předměty v lokaci a všechny možné východy.\n" +
                "- seber [předmět] - Přidá předmět do inventáře.\n" +
                "- poloz [předmět] - Položí předmět z inventáře do aktuální lokace. Pokud se nacházíš v kuchyni a je v kuchyni kastrol, tak položí předmět z inventáře do kastrolu v kuchyni.\n" +
                "- zobraz_inventar - Zobrazí, co máš v inventáři.\n" +
                "- obsah_kastrolu - Ukáže, co je aktuálně v kastrolu. Aby mohl být pooužit tento příkaz, musíš být v kuchyni.\n" +
                "- uvar - Spustí proces vaření, pokud máte všechny suroviny. Aby mohl být pooužit tento příkaz, musíš být v kuchyni.\n" +
                "- promluv [postava] – Umožňuje hráči interagovat s postavami a získat od nich informace nebo pomoc.\n" +
                "- konec - Ukončí hru.\n" +
                "- nápověda - Poskytne nápovědu k příkazům nebo hře obecně.";
    }
}
