package Logika;

import java.util.*;

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
        Scanner scanner = new Scanner(System.in);
        if(parametryPrikazu.length < 1){
            return "Nevím, s kým mám mluvit.";
        }

        Lokace aktualniLokace = hra.getHerniSvet().getAktualniLokace();
        Postava postava = aktualniLokace.najdiPostavu(parametryPrikazu[0]);

        if(postava.getJmeno().equalsIgnoreCase("Alfred")){
            int i = 0;
            System.out.println(postava.getProslov());
            System.out.print(">> ");
            while (scanner.nextInt() != 6){
                System.out.println("Špatná odpověď");
                if(i >= 2){
                    System.out.println("\nMám pro tebe menší nápovědu. Kolik je 3*2?");
                }
                System.out.print(">> ");
                i++;
            }
            return "Správně! Víno najdeš ve 'vinotéce'.\nAby ses tam dostal musíš se vrátit zpátky do 'Ulic Paříže', " +
                    "poté se musíš vydat do 'Zahrady v parku', odkud ji už uvidíš :)";
        }


        if(postava.getJmeno().equalsIgnoreCase("Colette")){
            List<String> recept = new ArrayList<>(Arrays.asList("cibule","cesnek","paprika","cuketa","lilek","rajce","olivovy_olej","bylinky","sul","pepr"));
            String text = "Tomu nerozumím";
            Predmet kastrol = aktualniLokace.vratPredmet("kastrol");

            if(kastrol == null){
                return "Collete: Aby jsi se mnou mohl mluvit musíš nejdříve najít kastrol.";
            }

            Set<String> obsahKastrolu = kastrol.getPredmety().keySet();

            for(String s : obsahKastrolu){
                recept.remove(s);
            }

            System.out.println(postava.getProslov());
            System.out.print(">> ");
            String odpoved = scanner.nextLine();
            if(odpoved.equalsIgnoreCase("ano")){
                if(aktualniLokace.vratPredmet("kastrol") != null){
                    text = "Chybí ti tyto ingredience: ";
                    for(String s : recept){
                        text += s + " ";
                    }
                }

            }else if(odpoved.equalsIgnoreCase("ne")){
                text = "Kdyby jsi pomoc přeci jen někdy potřeboval, víš kde mě najdeš :)";
            }
            return text;
        }

        if(postava.getJmeno().equalsIgnoreCase("Skinner")){
            return postava.getProslov();
        }

        return "Tato postavu tu není";
    }
}
