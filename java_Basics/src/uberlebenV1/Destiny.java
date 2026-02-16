package uberlebenV1;

import java.util.ArrayList;


public class Destiny {

    public static void oneYearPassed(int year) {

        System.out.println("Jahr: " + year);

        for (int h = 0; h < House.allHouses.size(); h++) {
            House hTmp = House.allHouses.get(h);

            if (!hTmp.getOlder()) {

                // lösche verbindungen
                for (Human h2 : Human.allHuman) {
                    if (h2.livesIn == hTmp) {
                        h2.livesIn = null;
                    }
                }

                // dann lösche haus
                House.allHouses.remove(hTmp);
                h--;
            }
        }
        for (int hu = 0; hu < Human.allHuman.size(); hu++) {
            Human huTemp = Human.allHuman.get(hu);
            if (!huTemp.getOlder()) {
                for (Human human : Human.allHuman) {
                    if (human.inLovIn == huTemp) {
                        human.inLovIn = null;
                    }
                }
                Human.allHuman.remove(huTemp);
                hu--;
            }
        }
        Human huTemp;
        for (int hu = 0; hu < Human.allHuman.size(); hu++) {
            huTemp = Human.allHuman.get(hu);
            for (int y = hu + 1; y < Human.allHuman.size(); y++) {

                huTemp.love(Human.allHuman.get(y));

                if (huTemp.inLovIn == Human.allHuman.get(y) && Human.allHuman.get(y).inLovIn == huTemp) {

                    Human child = huTemp.hasChildWithLover(Human.allHuman.get(y));

                    if (child != null) {
                        Human.allHuman.add(child);
                    }

                    if (huTemp.livesIn == null && Human.allHuman.get(y).livesIn == null && huTemp.strength + Human.allHuman.get(y).strength > 3 && huTemp.intelligence + Human.allHuman.get(y).intelligence > 3) {
                        House.allHouses.add(new House(huTemp, Human.allHuman.get(y)));
                    }
                }


            }
        }

//        human.getOlder();
//        System.out.println("Das ist " + House.counter + " Jahr");
//ArrayList<House>toRemove =new ArrayList<>();


    }


    public static void main(String[] args) {
        Human munir = new Human("munir", 20);
        Human petra = new Human("petra", 30);
        //System.out.println("my age ist " + munir.age);
//      Destiny destiny=new Destiny();
//      destiny.oneYearPassed(munir);
//        System.out.println(munir.age);
//        System.out.println(House.allHouses.size());
//        System.out.println(Human.allHuman.size());
//        System.out.println(House.allHouses.get(0));

        System.out.println(petra);
        System.out.println(munir);

        int year = 0;
        while (Human.allHuman.size() > 0 || House.allHouses.size() > 0) {
            oneYearPassed(year);
            year++;
        }
    }
}
