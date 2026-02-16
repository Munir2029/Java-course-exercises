import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenv3 {
    public static void main(String[] args) {
        Random r = new Random();

        Scanner sr = new Scanner(System.in);

        int werfenZahl;
        int summeKopf = 0;
        int summeZhal = 0;


        do {
            System.out.println("Wie oft soll die Münze geworfen werden (ungerade Zahl 1-10)?");
            werfenZahl = sr.nextInt();
        }
        while (werfenZahl % 2 == 0 || werfenZahl > 10 || werfenZahl < 1);
        for (int i = 0; i < werfenZahl; i++) {

            boolean kopf = r.nextBoolean();

            if (kopf) {

                System.out.println("Die Münze ist auf Kopf gelandet ");
                summeKopf++;
            } else {
                System.out.println("Die Münze ist auf Zahl gelandet ");
                summeZhal++;

            }
        }

        System.out.println("summe zahl: " + + summeZhal);
        System.out.println("summe kopf: " + summeKopf);

        if (summeKopf > summeZhal) {
            System.out.println("ich gewinne ich bekomme das Ticket");
        } else  {
            System.out.println("Stefan gewinnet er bekommt das Tickt");
        }


    }
}
