package Logika;

public class PrikazJdi implements IPrikaz{

    private Hra hra;

    public PrikazJdi(Hra hra){
        this.hra = hra;
    }

    @Override
    public String getNazev(){
        return "jdi";
    }

    @Override
    public String proved(String[] parametryPrikazu){

        if (parametryPrikazu.length < 1){
            return "Musiš mi říct, kam mám jít.";
        }

        if(parametryPrikazu.length > 1){
            return "Zadal jsi mi moc lokací, nevím kam mám jít.";
        }

        String nazevLokace = parametryPrikazu[0];
        HerniSvet herniSvet = hra.getHerniSvet();


        Lokace aktualniLokace = hra.getHerniSvet().getAktualniLokace();

        if(!aktualniLokace.maVychod(nazevLokace)){
            return "Do lokace '" + nazevLokace + "' se odsud nedá jít";
        }

        Lokace novaLokace = aktualniLokace.vratVychod(nazevLokace);
        herniSvet.setAktualniLokace(novaLokace);

        return "Odešel jsi do lokace " + novaLokace.getNazev() + "\n\n" + novaLokace.getPopis();
    }
}
