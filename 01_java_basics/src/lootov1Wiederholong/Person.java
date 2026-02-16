package lootov1Wiederholong;

import java.util.ArrayList;

public class Person {

    String name;
    double geld;
    ArrayList<LottoSchein> meineSchein;

    public Person(String title, double mony) {
        this.name = title;
        this.geld = mony;
        this.meineSchein = new ArrayList<>();
    }

    public void kaufen(Firma firma) {
        if (geld >= 1) {
            LottoSchein schein = firma.verkaufen();   //ich habe es nicht verstanden
            meineSchein.add(schein);
            geld -= 1;
            System.out.println(this.name + "kauft den Lottoschein" + schein.nr);
        }
    }

    public String toString() {
        return name + " hat noch " + geld + "€";
    }
}
