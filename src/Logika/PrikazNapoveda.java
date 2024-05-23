package Logika;

public class PrikazNapoveda implements IPrikaz{

    @Override
    public String getNazev(){
        return "napoveda";
    }

    @Override
    public String proved(String[] parametryPrikazu){
        return "Toto je hra o lupiči, který se snaží vykrást dům. " +
                "Tvým úkolem je odnést si lup v co největší hodnotě." +
                " Musíš si ale dávat pozor, v boudě je pes, kterého nechceš probudit.";
    }
}
