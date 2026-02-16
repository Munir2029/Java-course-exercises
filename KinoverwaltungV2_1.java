import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KinoverwaltungV2_1 {
    public static void main(String[] args) {

        Scanner sr = new Scanner(System.in);
        int wallet = 0;
        int auswahlBis4 = 10;
        int filmAuswahl = 1;
        ArrayList<Integer> gekauft = new ArrayList<>();

        String[][] info = {{"1.", "Matrix", "10:00", "A13", "20€", "100"},
                {"2.", "Matrix2", "12:00", "B97", "15€", "120"},
                {"3.", "Interstellar", "14:00", "C88", "25€", "130"}};


        while (wallet < 15) {
            System.out.println("wie viel Geld hast du mind 15€");
            wallet = sr.nextInt();
        }

        System.out.println("Was willst du als nächstes tun? (Du hast noch " + wallet + "€)");
        System.out.println("1. Ticket kaufen");
        System.out.println("2. Film ansehen");
        System.out.println("3. Gewinnspiel");
        System.out.println("4. Kino verlassen");
        auswahlBis4 = sr.nextInt();
        if (auswahlBis4 == 4) {
            System.out.println("Du verlässt das Kino. Auf wiedersehen!");
        } else if (auswahlBis4 == 1) {
            int filmAuswahlNR = 1;
            int tickets = 0;

            while (filmAuswahlNR != 0) {
                System.out.println(String.format("%s       %s       %s     %s        %s", "filmNumr", "Filmname", "Uhrzeit", "saal", "Preis","Restplätze"));
                for (int i = 0; i < info.length; i++) {

                    System.out.print(info[i][0] + "            " + info[i][1] + "         " + info[i][2] + "       " + info[i][3] + "          " + info[i][4]);

                    boolean verfügber = Integer.parseInt(info[i][5]) > 0;
                    if (verfügber) {
                        System.out.println(info[i][5] + " Platz noch verfügber");
                    } else {
                        System.out.println("ausgebucht ");
                    }
                }


                System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
                filmAuswahlNR = sr.nextInt();
                String ausgesuchteFilm=info[filmAuswahl-1][2];
                System.out.println("du hast "+info[filmAuswahl-1][2]+" ausgewhält");

                if (filmAuswahlNR > 0 && filmAuswahlNR < 4) {
                 //   gekauft.add(filmAuswahlNR);

                    if (Integer.parseInt(info[filmAuswahlNR-1][5]) <= 0){
                        System.out.println("Der Film ist ausgebucht ");
                    } else {

                        System.out.println("Es sind noch " + info[filmAuswahlNR - 1][5] + " Tickets um jeweils "+info[filmAuswahlNR-1][4]+" dafür verfügbar. Wie viele möchtest du kaufen");
                        tickets = sr.nextInt();

                        while (tickets <= 0) {
                            System.out.println("ungültiger zahl ");
                            System.out.println("Es sind noch " + info[filmAuswahlNR - 1][5] + " Tickets um jeweils "+info[filmAuswahlNR-1][4]+"  dafür verfügbar. Wie viele möchtest du kaufen");
                            tickets = sr.nextInt();
                        }
                        int gesamteBetrag = tickets *Integer.parseInt(info[filmAuswahlNR-1][4]) ;


                        if (gesamteBetrag <= wallet) {


                            if (tickets >Integer.parseInt(info[filmAuswahlNR-1][5]) ) {
                                System.out.println("zu wieneg Plätze,verfügber plätze momentean sind " + Integer.parseInt(info[filmAuswahlNR-1][5]) + " Plätze");
                            } else {
                                int newPlätze=Integer.parseInt(info[filmAuswahlNR-1][5])- tickets;


                                System.out.println("Du kaufst " + tickets + " Tickets um " + gesamteBetrag + "€und hast jetzt noch " + (wallet - gesamteBetrag)+"€");
                                wallet -= gesamteBetrag;
                                for (int i = 0; i < tickets; i++) {
                                    gekauft.add(filmAuswahlNR);

                                }

                            }


                        } else {

                            System.out.println("geld ist zu wenig");
                        }
                    }


                    //test anfang

                    //System.out.println(Arrays.toString(info[filmAuswahlNR-1][5]));
                    System.out.println(gekauft);
                    //test ende

                } else if (filmAuswahlNR > 3 || filmAuswahlNR < 0) {
                    System.out.println("ungültiger Filmnummer");
                } else {

                    filmAuswahlNR = filmAuswahlNR * filmAuswahlNR;
                }
            }
            System.out.println("du hast 0 ausgäwhlt Tschüs");


        }


    }
}






