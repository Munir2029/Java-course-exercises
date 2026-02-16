import javax.swing.*;
import java.util.Scanner;

public class KinoverwaltungV2 {
    public static void main(String[] args) {

        Scanner sr = new Scanner(System.in);
        int wallet = 0;
        int auswahl = 10;
        int filmAuswahl = 1;
        int seatsLeft = 3;
        int preis;
        boolean ausgebocht = false;


        String[][] info = {{"1.", "Interstellar", "10:00", "A13", "20", "0"},
                {"2.", "Matrix2", "12:00", "B97", "15", "12"},
                {"3.", "Matrix", "14:00", "C88", "25", "13"}};


        while (wallet < 15) {
            System.out.println("wie viel Geld hast du mind 15€");
            wallet = sr.nextInt();
        }

        System.out.println("Was willst du als nächstes tun? (Du hast noch " + wallet + "€)");
        System.out.println("1. Ticket kaufen");
        System.out.println("2. Film ansehen");
        System.out.println("3. Gewinnspiel");
        System.out.println("4. Kino verlassen");
        auswahl = sr.nextInt();
        if (auswahl == 4) {
            System.out.println("Du verlässt das Kino. Auf wiedersehen!");
        } else if (auswahl == 1) {
            while (filmAuswahl != 0) {
                System.out.printf("%s %20s %17s %11s %12s %24s %n", "Filmnr", "Filmname", "Uhrzeit", "Saal", "Preis", "Restplätze ");
                System.out.println("----------------------------------------------------------------------------------------------------");

                for (int i = 0; i < info.length; i++) {


                    System.out.printf("%s %25s %15s %12s %12s  ", info[i][0], info[i][1], info[i][2], info[i][3], info[i][4]);


                    int plätze = Integer.parseInt(info[i][5]);
                    boolean verfügber = plätze > 0;
                    if (verfügber) {
                        System.out.printf("%15d %2s", plätze, " Plätze noch ");
                    } else {
                        System.out.printf("%24s", "ausgebucht");
                    }
                    System.out.println();
                }
                do {
                    System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
                    filmAuswahl = sr.nextInt();
                    seatsLeft = Integer.parseInt(info[filmAuswahl - 1][5]);
                    ausgebocht = seatsLeft < 1;
                }

                while (ausgebocht);


                seatsLeft = Integer.parseInt(info[filmAuswahl - 1][5]);

                preis = Integer.parseInt(info[filmAuswahl - 1][4]);


                System.out.println("Es sind noch " + seatsLeft + " Tickets um jeweils " + info[filmAuswahl - 1][4] + " dafür verfügbar. Wie viele möchtest du kaufen?");
                int pTickt = sr.nextInt();
                int gesamtBetrag = pTickt * preis;


                while (pTickt > seatsLeft) {
                    System.out.println("zu wieneg Plätze,verfügber plätze momentean sind " + seatsLeft + " Plätze.Wie viele möchtest du kaufen?");
                    pTickt = sr.nextInt();
                }


                if (gesamtBetrag <= wallet) {

                    wallet -= gesamtBetrag;
                    System.out.println("Du kaufst " + pTickt + " Tickets um " + (preis * pTickt) + " € und hast jetzt noch " + wallet + " € ");

                    seatsLeft -= pTickt;

                    if (seatsLeft < 1) {
                        ausgebocht = true;
                    } else {
                        ausgebocht = false;
                    }


                } else {
                    System.out.println("zu wieng geld");
                }

            }
        }

    }

}


//  while (auswahl < 5 && auswahl > 0) {
//      while (auswahl != 4) {





