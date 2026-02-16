package lootov1Wiederholong;

import java.util.ArrayList;
import java.util.Random;

public class LottoTester {
    public static void main(String[] args) {
        Firma Casion = new Firma();

        for (int i = 0; i < 3; i++) {
            LottoSchein ls = Casion.verkaufen();
            System.out.println(ls);
        }

        Random rn = new Random();
        Firma lottoFirma = new Firma();
        ArrayList<Person> personen = new ArrayList<>();
        int anzahlPersonen = rn.nextInt(101);
        for (int i = 0; i < anzahlPersonen; i++) {
            String name = "User" + i;
            double geld = rn.nextInt(11);
            personen.add(new Person(name, geld));


        }
        for (int i = 0; i < personen.size(); i++) {

            System.out.println(personen.get(i));

            int runden = 20;
            for (int runde = 0; runde < runden; runde++) {
                if (rn.nextBoolean()) {
                    Person tmpPerson = personen.get(i);
                    tmpPerson.kaufen(lottoFirma);
                }
            }

        }

        System.out.println("\n nach dem kauf");
        for (int i = 0; i < personen.size(); i++) {
            Person p = personen.get(i);
            System.out.println(p);
        }

        int siegNr = rn.nextInt(1,LottoSchein.counter +1);
        System.out.println("Die Siegernummer ist " + siegNr);

        for (int i = 0; i < personen.size(); i++) {
            for (int s = 0; s < personen.get(i).meineSchein.size(); s++) {
                if (siegNr == personen.get(i).meineSchein.get(s).nr) {
                    System.out.println(personen.get(i).name + " gewinnt " + LottoSchein.counter + "€ gewonnen!");
                    personen.get(i).geld += LottoSchein.counter;
                    System.out.println("Die Person hat jetzt " + personen.get(i).geld + "€");
                }
            }
        }
    }
}
