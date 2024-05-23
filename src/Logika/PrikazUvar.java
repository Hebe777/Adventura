package Logika;

public class PrikazUvar implements IPrikaz{
    private Hra hra;

    public PrikazUvar(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String getNazev() {
        return "uvar";
    }

    @Override
    public String proved(String[] parametryPrikazu) {
        return null;
    }
}
