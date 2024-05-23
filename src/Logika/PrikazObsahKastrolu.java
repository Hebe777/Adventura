package Logika;

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
        return null;
    }
}
