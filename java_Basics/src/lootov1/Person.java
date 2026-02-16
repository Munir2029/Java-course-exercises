package lootov1;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    double geld;
    ArrayList<LottoSchein> meinScheine;


    // Konstruktor
    public Person(String name, double geld) {
        this.name = name;
        /*this heißt dass
         * der name den benuzer eingebt wird
         * in der name in die klasse geschbeicht*/
        this.geld = geld;
        this.meinScheine = new ArrayList<>();
    }

    //methode
    public void kaufen(Firma firma) {
        if (geld >= 1) {
            LottoSchein schein = firma.verkaufen();
            meinScheine.add(schein);
            geld -= 1;
            System.out.println(this.name + " kauft den Lottoschein " + schein.nr);
        }
    }
    public String toString(){
        return name+" hat noch " + geld + " €";
    }

}





