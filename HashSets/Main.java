package HashSets;

import java.util.HashSet;


public class Main {

    public static void main(String[] args) {

        HashSet<String> gesamteGrupen = new HashSet();


        HashSet<String> gruppe1 = new HashSet();
        gruppe1.add("David");
        gruppe1.add("Horst");
        gruppe1.add("Eva");
        gruppe1.add("Maria");
        gruppe1.add("Lio");

        HashSet<String> gruppe2 = new HashSet<>();
        gruppe2.add("Eva");
        gruppe2.add("Helene");
        gruppe2.add("Maria");
        gruppe2.add("Munir");
        gruppe2.add("Horst");



        HashSet<String> gruppe3 = new HashSet<>();
        gruppe3.add("Eva");
        gruppe3.add("Horst");
        gruppe3.add("Alicia");
        gruppe3.add("Helene");
        gruppe3.add("Munir");


        HashSet<String> gruppe1Copy = new HashSet<>(gruppe1);                    //da müssen wir ein Coppy von HashSet von gruppe1
        HashSet<String> gruppe2Copy = new HashSet<>(gruppe2);
        HashSet<String> gruppe3Copy = new HashSet<>(gruppe3);
//        HashSet<HashSet> einzigeArtigeNamen=new HashSet<>();


        //Welcher Namen kommen in gruppe1 UND gruppe 2 vor (also doppelt)?
        HashSet<String> gemeinsamNamenInGr1UndGr2 = new HashSet<>(gruppe1);
        gemeinsamNamenInGr1UndGr2.retainAll(gruppe2);               //retainAll heiß schneide alle nammen was gleich sind .  auf Englisch intersection   Deutsch Überschneidung
        System.out.println("Alle namen die in gruppe1 und gruppe2 kommen: \n" + gemeinsamNamenInGr1UndGr2);
        gruppe1Copy.removeAll(gemeinsamNamenInGr1UndGr2);
        System.out.println("Test gruppe1Copy " + gruppe1Copy);    //momentan das ist der einzige name in grupe1 mit (gr1,g2)
        gruppe2Copy.removeAll(gemeinsamNamenInGr1UndGr2);
        System.out.println("Test gruppe2Copy" + gruppe2Copy);       //momentan das ist der einzige name in grupe1 mit (gr1,g2)


        gesamteGrupen.addAll(gruppe1Copy);
        gesamteGrupen.addAll(gruppe2Copy);
        gesamteGrupen.addAll(gruppe3Copy);
        System.out.println("Alle namen  in allen gruppen sind: \n" + gesamteGrupen);

        System.out.println("gruppe1: " + gruppe1);
        System.out.println("gruppe2: " + gruppe2);
        System.out.println("gruppe3: " + gruppe3);


        //Welche Namen kommen in ALLEN 3 Gruppen vor (also dreifach)?
        gemeinsamNamenInGr1UndGr2.retainAll(gruppe3);
        System.out.println("drei fach" + gemeinsamNamenInGr1UndGr2);
        //  Ist gruppe2 oder gruppe3 eine Teilgruppe von gruppe1? (also sind z.B. alle Mitglieder der Gruppe 2 auch Mitglieder der gruppe1?)

        System.out.println("gruppe 1 " + gruppe1Copy);

        System.out.println(gruppe1.containsAll(gruppe3));


        //Welche Namen kommen überhaupt nur 1x vor (sind also einzigartig)?

        HashSet<String> eiinzigeArtigeName = new HashSet<>();
        HashSet<String> gemeinsamNamenInGr1UndGr3 = new HashSet<>(gruppe3);
        HashSet<String> gemeinsamNamenInGr2UndGr3 = new HashSet<>(gruppe3);

        gemeinsamNamenInGr1UndGr3.retainAll(gruppe1);
        gemeinsamNamenInGr2UndGr3.retainAll(gruppe2);


        gruppe3Copy.removeAll(gemeinsamNamenInGr1UndGr3);
        gruppe3Copy.removeAll(gemeinsamNamenInGr2UndGr3);

        gruppe1Copy.removeAll(gemeinsamNamenInGr1UndGr3);
        gruppe2Copy.removeAll(gemeinsamNamenInGr2UndGr3);


        eiinzigeArtigeName.addAll(gruppe1Copy);
        eiinzigeArtigeName.addAll(gruppe2Copy);
        eiinzigeArtigeName.addAll(gruppe3Copy);

        System.out.println("die einzigen Artigen namen sind:" + eiinzigeArtigeName);





    }
}
