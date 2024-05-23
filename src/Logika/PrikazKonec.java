package Logika;

public class PrikazKonec implements IPrikaz{

    private Hra hra;

    public PrikazKonec(Hra hra){
        this.hra = hra;
    }

    @Override
    public String getNazev(){
        return "konec";
    }

    @Override
    public String proved(String[] parametryPrikazu){
        hra.setHraSkoncila(true);
        return "Hra byla ukončena příkazem KONEC!";
    }
}
