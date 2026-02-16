import java.util.Arrays;
import java.util.Scanner;

public class KinoVerwaltungV1 {
    public static void main(String[] args) {


        int[] filmNO = {1, 2,3};
        String[] availMovies = {
                "matrix",
                "matrix2",
                "Interstellar"
        };
        String[] time = {"15:00", "20:00","18:00"};
        int[] kinoSaal = {97,98, 99};
        int[] seatsLeft = {100,120,130};
        //  boolean verfügber = seatsLeft[] > 0;


        int[] chosenMovies = new int[100];
        Scanner sr = new Scanner(System.in);




        int geldTasche = 0;
        do {
            System.out.println("wie viel hast du geld mind 15€");
            geldTasche = sr.nextInt();
        }
        while (geldTasche < 15);


        int arryNrAnfang = 0;

        int wahlNR = 1;
        int tickets = 0;
                                   //ich muss noch formatiern ///////////////////IUGFZTDUTZDIFZOUGIUFZIZTFDIZTD
        while (wahlNR != 0) {
            System.out.println(String.format("%s       %s       %s     %s        %s", "filmNumr", "Filmname", "Uhrzeit", "saal", "Restplätze"));
            for (int i = 0; i < filmNO.length; i++) {

                System.out.print(filmNO[i] + "            " + availMovies[i] + "         " + time[i] + "       " + kinoSaal[i] + "          ");
                boolean verfügber = seatsLeft[i] > 0;
                if (verfügber) {
                    System.out.println(+seatsLeft[i]+" Platz noch verfügber");
                } else {
                    System.out.println("ausgebucht ");
                }
            }


            System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
            wahlNR = sr.nextInt();

            if (wahlNR > 0 && wahlNR < 4) {
                chosenMovies[arryNrAnfang] = wahlNR;
                arryNrAnfang++;
                if (seatsLeft[wahlNR - 1] <= 0) {
                    System.out.println("Der Film ist ausgebucht ");
                } else {
                    System.out.println("Es sind noch " + seatsLeft[wahlNR - 1] + " Tickets um jeweils 15€ dafür verfügbar. Wie viele möchtest du kaufen");
                    tickets = sr.nextInt();

                    int gesamteBetrag = tickets * 15;


                    if (gesamteBetrag <= geldTasche) {


                        if (tickets > seatsLeft[wahlNR - 1]) {
                            System.out.println("zu wieneg Plätze,verfügber plätze momentean sind " + seatsLeft[wahlNR - 1] + " Plätze");
                        } else {
                            seatsLeft[wahlNR - 1] = seatsLeft[wahlNR - 1] - tickets;

                            System.out.println("Du kaufst " + tickets + " Tickets um " + gesamteBetrag + "€und hast jetzt noch " + (geldTasche - gesamteBetrag));

                            geldTasche -= gesamteBetrag;
                        }


                    } else {

                        System.out.println("geld ist zu wenig");
                    }
                }


                //test anfang

                System.out.println(Arrays.toString(seatsLeft));
                System.out.println(Arrays.toString(chosenMovies));
                //test ende

            } else if (wahlNR > 3 || wahlNR < 0) {
                System.out.println("ungültiger Filmnummer");
            } else {

                wahlNR = wahlNR * wahlNR;
            }
        }
        System.out.println("du hast 0 ausgäwhlt Tschüs");


    }


}

