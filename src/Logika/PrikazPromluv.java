package Logika;

public class PrikazPromluv implements IPrikaz{
    private Hra hra;

    public PrikazPromluv(Hra hra) {
        this.hra = hra;
    }


    @Override
    public String getNazev() {
        return "promluv";
    }

    @Override
    public String proved(String[] parametryPrikazu) {
        return null;
    }
}
