import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class KinoverwaltungV2_2 {
    public static void main(String[] args) {

        Scanner sr = new Scanner(System.in);
        int wallet = 0;
        int auswahl = 0;
        int filmAuswahl = 2;
        int seatsLeft;
        int preis;
        boolean ausgebocht = true;
        boolean reppet = true;


        ArrayList<Integer> chosenMovies = new ArrayList<>();

        String[][] info = {{"1", ".", "Interstellar", "10:00", "A13", "20", "0"},
                {"2", ".", "Matrix2", "12:00", "B97", "15", "12"},
                {"3", ".", "Matrix", "14:00", "C88", "25", "13"}};

//C erste schleife
        while (wallet < 15) {
            System.out.println("wie viel Geld hast du mind 15€");
            wallet = sr.nextInt();

        }
//C zweite schleife

        while (auswahl == 0) {
            System.out.println("Was willst du als nächstes tun? (Du hast noch " + wallet + "€)");
            System.out.println("1. Ticket kaufen");
            System.out.println("2. Film ansehen");
            System.out.println("3. Gewinnspiel");
            System.out.println("4. Kino verlassen");
            auswahl = sr.nextInt();
            if (auswahl == 4) {
                System.out.println("Du verlässt das Kino. Auf wiedersehen!");
            }

//C drite schleife
            while (auswahl == 1) {

                System.out.printf("%s %20s %17s %11s %12s %24s %n", "Filmnr", "Filmname", "Uhrzeit", "Saal", "Preis", "Restplätze ");
                System.out.println("----------------------------------------------------------------------------------------------------");

                for (int i = 0; i < info.length; i++) {


                    System.out.printf("%s %s %25s %15s %12s %12s  ", info[i][0], info[i][1], info[i][2], info[i][3], info[i][4], info[i][5]);


                    int plätze = Integer.parseInt(info[i][6]);
                    ausgebocht = plätze < 1;
                    if (ausgebocht) {
                        System.out.printf("%24s", "ausgebucht");
                    } else {
                        System.out.printf("%15d %2s", plätze, " Plätze noch ");
                    }
                    System.out.println();


                }


                do {

                    System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
                    filmAuswahl = sr.nextInt();

                } while (filmAuswahl != 0 && filmAuswahl < 1 || filmAuswahl > 3);



                if (filmAuswahl == 0) {
                    auswahl = 0;
                } else {
                    System.out.println("Filmauswahl: " + filmAuswahl);
                    seatsLeft = Integer.parseInt(info[filmAuswahl - 1][6]);
                    ausgebocht = seatsLeft < 1;

                    while (filmAuswahl > 0 && reppet) {


                        seatsLeft = Integer.parseInt(info[filmAuswahl - 1][6]);

                        ausgebocht = seatsLeft < 1;

                        preis = Integer.parseInt(info[filmAuswahl - 1][5]);

                        if (!ausgebocht) {


                            System.out.println("Es sind noch " + seatsLeft + " Tickets um jeweils " + info[filmAuswahl - 1][5] + " dafür verfügbar. Wie viele möchtest du kaufen?(0 zum zrück)");

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
                                reppet = false;
                                for (int i = 0; i < pTickt; i++) {

                                    chosenMovies.add(Integer.parseInt(info[filmAuswahl - 1][0]));
                                }
                                System.out.println(chosenMovies);
                                info[filmAuswahl - 1][6] = String.valueOf(seatsLeft);


                            } else {
                                System.out.println("zu wieng geld");
                            }


                        } else {
                            System.out.println("der Film ist ausgebucht");
                            System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
                            filmAuswahl = sr.nextInt();

                            seatsLeft = Integer.parseInt(info[filmAuswahl - 1][6]);
                            ausgebocht = seatsLeft < 1;
                        }


                    }

                }
            }
            //C vierte schleife
            boolean reppet2 = true;
            while (auswahl == 2 && reppet2) {


                int verfügberTickt = 0;
                System.out.println("Welchen Film (für den du noch ein Ticket hast) möchtest du sehen? (0 für abbrechen)");

                for (int i = 0; i < info.length; i++) {
                    System.out.println(info[i][0] + info[i][1] + info[i][2]);

                }
                int temp = sr.nextInt();
                if (temp == 0) {
                    reppet2 = false;
                    auswahl = 0;
                } else {
                    int wieOft = 0;

                    int c = 0;
                    for (c = 0; c < chosenMovies.size(); c++) {
                        if (temp == chosenMovies.get(c)) {
                            System.out.println(c);
                            verfügberTickt++;
                        }
                    }

                    if (verfügberTickt > 0) {

                        do {
                            System.out.println("du hast " + verfügberTickt + " Tickt noch,wie oft willst du den Film sehen");
                            wieOft = sr.nextInt();
                        } while (wieOft > verfügberTickt || wieOft < 0);


                        for (int k = 0; k < wieOft; k++) {
                            chosenMovies.remove(Integer.valueOf(temp));
                        }
                        System.out.println("Du schaust dir den Film " + (info[temp - 1][2]) + " " + wieOft + " mal" + " an. Viel Spaß!");
                        verfügberTickt -= wieOft;

                    } else {
                        System.out.println("du hast kein Tickt");
                    }
                }

            }
            //C fünfte schleife
            boolean reppet3 = true;
            while (auswahl == 3 && reppet3) {
                Random r = new Random();
                System.out.println(" du kannst für 5€ bei einem Gewinnspiel mitmachen 1 für wieter und 0 für zrück dein aktuelle geld btrag ist " + wallet);
                int jaOrno = sr.nextInt();
                ;
                if (jaOrno == 0) {
                    reppet3 = false;
                    auswahl = 0;
                } else {
                    System.out.println("Du machst beim Gewinnspiel mit!");
                    int glückszahl = r.nextInt(10, 1001);
                    System.out.println("Deine Glückszahl ist: " + glückszahl);
                    int sum = 0;
                    while (glückszahl > 0) {
                        sum += glückszahl % 10;
                        glückszahl /= 10;

                    }
                    if (sum > 16) {
                        System.out.println("Die Ziffernsumme deiner Glückszahl  ist größer 16. Du gewinnst  20€!");
                        wallet += 20;

                    } else {
                        System.out.println("Die Ziffernsumme deiner Glückszahl  ist kleiner 16. Leider nicht gewonnen.");
                        wallet -= 5;
                    }
                }


            }

        }


    }
}




















