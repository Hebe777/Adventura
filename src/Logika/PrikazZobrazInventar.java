package Logika;

import java.util.Map;

public class PrikazZobrazInventar implements IPrikaz{
    private Hra hra;

    public PrikazZobrazInventar(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String getNazev() {
        return "zobraz_inventar";
    }

    @Override
    public String proved(String[] parametryPrikazu) {
        return hra.getInventar().zobrazInventar();
    }
}
