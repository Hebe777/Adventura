package Logika;

public class PrikazRozhledniSe implements IPrikaz{
    private Hra hra;

    public PrikazRozhledniSe(Hra hra){
        this.hra = hra;
    }

    @Override
    public String getNazev() {
        return "rozhledni_se";
    }

    @Override
    public String proved(String[] parametryPrikazu) {

        if(parametryPrikazu.length > 0){
            return "Tomu nerozumím, neumím se rozhlednout na něco";
        }

        return hra.getHerniSvet().getAktualniLokace().getPopis();
    }
}
