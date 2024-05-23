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
        if(parametryPrikazu.length < 1){
            return "Nevím, s kým mám mluvit.";
        }

        Lokace aktualniLokace = hra.getHerniSvet().getAktualniLokace();
        Postava postava = aktualniLokace.najdiPostavu(parametryPrikazu[0]);

        if(postava == null){
            return "Tato postava tu není.";
        }

        return postava.getProslov();
    }
}
