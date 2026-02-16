package lootov1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lootov1.*;

public class Main {
    public static void main(String[] args) {
        //hier müssen wir immer ein
        // new objekt ginerern bevor wir
        //anfangen wie beim Scanner und Random

        Firma casinoAustria = new Firma();



//        for (int i = 0; i < 3; i++) {
//            LottoSchein ls = casinoAustria.verkaufen();
//            System.out.println(ls);
//        }


        Firma lottoFirma = new Firma();
        Random rand = new Random();
        int anzahlPersonen = 3; //rand.nextInt(100) + 1;

        //new liste um die personen zu speichen
        ArrayList<Person> personen = new ArrayList<>();

        //creat personen
        for (int i = 1; i <= anzahlPersonen; i++) {
            String name = "User " + i;
            double geld = rand.nextInt(11);//von 0 bis 10 euro
            personen.add(new Person(name, geld));
        }

        for (Person p : personen) {
            System.out.println(p);
        }
        int runden = 10;
        for (int runde = 0; runde < runden; runde++) {
            for (int i = 0; i < personen.size(); i++) {
                //Person p = personen.get(i);
                if (rand.nextBoolean()) {
                    personen.get(i).kaufen(lottoFirma);
                }
            }
        }

        System.out.println("\n---nach dem kauf---");
        for (int i = 0; i < personen.size(); i++) {
            Person p = personen.get(i);
            System.out.println(p);
        }

        int siegNr = rand.nextInt(1, LottoSchein.counter + 1);
        System.out.println("Die Siegernummer ist " + siegNr);

        for (int i = 0; i < personen.size(); i++) {
            for (int s = 0; s < personen.get(i).meinScheine.size(); s++) {
                if (siegNr == personen.get(i).meinScheine.get(s).nr) {
                    System.out.println(personen.get(i).name + " gewinnt " + LottoSchein.counter + "€ gewonnen!");
                    personen.get(i).geld += LottoSchein.counter;
                    System.out.println("Die Person hat jetzt " + personen.get(i).geld + "€");
                }
            }
        }
    }
}
