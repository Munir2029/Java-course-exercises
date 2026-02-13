
  
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KinoVerwaltungV1_1 {
    public static void main(String[] args) {
        int[] filmNO = new int[]{1, 2, 3};
        String[] availMovies = new String[]{"matrix", "matrix2", "Interstellar"};
        String[] time = new String[]{"15:00", "20:00", "18:00"};
        int[] kinoSaal = new int[]{97, 98, 99};
        int[] seatsLeft = new int[]{100, 120, 130};
        ArrayList<Integer> gekauft = new ArrayList();
        Scanner sr = new Scanner(System.in);
        int wallet = 0;

        do {
            System.out.println("wie viel hast du geld mind 15€");
            wallet = sr.nextInt();
        } while(wallet < 15);

        int wahlNR = 1;
        int tickets = 0;

        while(wahlNR != 0) {
            System.out.println(String.format("%s       %s       %s     %s        %s", "filmNumr", "Filmname", "Uhrzeit", "saal", "Restplätze"));

            for(int i = 0; i < filmNO.length; ++i) {
                System.out.print(filmNO[i] + "            " + availMovies[i] + "         " + time[i] + "       " + kinoSaal[i] + "          ");
                boolean verfügber = seatsLeft[i] > 0;
                if (verfügber) {
                    System.out.println(seatsLeft[i] + " Platz noch verfügber");
                } else {
                    System.out.println("ausgebucht ");
                }
            }

            System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
            wahlNR = sr.nextInt();
            if (wahlNR > 0 && wahlNR < 4) {
                gekauft.add(wahlNR);
                if (seatsLeft[wahlNR - 1] <= 0) {
                    System.out.println("Der Film ist ausgebucht ");
                } else {
                    System.out.println("Es sind noch " + seatsLeft[wahlNR - 1] + " Tickets um jeweils 15€ dafür verfügbar. Wie viele möchtest du kaufen");

                    for(tickets = sr.nextInt(); tickets <= 0; tickets = sr.nextInt()) {
                        System.out.println("ungültiger zahl ");
                        System.out.println("Es sind noch " + seatsLeft[wahlNR - 1] + " Tickets um jeweils 15€ dafür verfügbar. Wie viele möchtest du kaufen");
                    }

                    int gesamteBetrag = tickets * 15;
                    if (gesamteBetrag <= wallet) {
                        if (tickets > seatsLeft[wahlNR - 1]) {
                            System.out.println("zu wieneg Plätze,verfügber plätze momentean sind " + seatsLeft[wahlNR - 1] + " Plätze");
                        } else {
                            seatsLeft[wahlNR - 1] -= tickets;
                            System.out.println("Du kaufst " + tickets + " Tickets um " + gesamteBetrag + "€und hast jetzt noch " + (wallet - gesamteBetrag));
                            wallet -= gesamteBetrag;

                            for(int i = 0; i < tickets; ++i) {
                                gekauft.add(wahlNR);
                            }
                        }
                    } else {
                        System.out.println("geld ist zu wenig");
                    }
                }

                System.out.println(Arrays.toString(seatsLeft));
                System.out.println(gekauft);
            } else if (wahlNR <= 3 && wahlNR >= 0) {
                wahlNR *= wahlNR;
            } else {
                System.out.println("ungültiger Filmnummer");
            }
        }

        System.out.println("du hast 0 ausgäwhlt Tschüs");
    }
}

