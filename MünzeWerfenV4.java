import java.util.Random;
import java.util.Scanner;

public class MünzeWerfenV4 {
    public static void main(String[] args) {

        Random r = new Random();
        Scanner sr = new Scanner(System.in);
        int sumWerfenZhal = 0;
        int werfenZahl;
        int summeKopf = 0;
        int summeZahl = 0;
        boolean kopf;

        boolean zufrieden = false;
        //werfenZahl+= sumWerfenZhal;
        while (!zufrieden) {

            do {
                System.out.println("Wie oft soll die Münze geworfen werden (INSGESAMT ungerade, neue Zahl 1-10)?");
                werfenZahl = sr.nextInt();
            }
            while (werfenZahl > 10 || werfenZahl < 1 || (werfenZahl + sumWerfenZhal) % 2 == 0);


            sumWerfenZhal = sumWerfenZhal + werfenZahl;


            for (int i = 0; i < werfenZahl; i++) {
                kopf = r.nextBoolean();
                if (kopf) {
                    System.out.println("Die Münze ist auf Kopf gelandet ");
                    summeKopf++;
                } else {
                    System.out.println("Die Münze ist auf Zahl gelandet ");
                    summeZahl++;

                }
                System.out.println("summe kopf: " + summeKopf);
                System.out.println("summe zahl: " + summeZahl);

            }


            System.out.println("Bist du mit dem Ergebnis zufrieden?");
            zufrieden = sr.nextBoolean();
        }
        //todo
        if (summeZahl > summeKopf) {
            System.out.println("Stefan bekommt das Ticket.");
        } else {
            System.out.println("Stefan verliet er bekommt das Ticket nicht ");


        }

    }
}
