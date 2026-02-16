import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV2 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        int summeKopf = 0;
        int summeZahl = 0;

        System.out.println("wie viel mal wilst du werfen");
        int werfenZahl = sc.nextInt();
        if(werfenZahl<1){
            System.out.println("ungultieger zhal");
        }else {

            for (int i = 0; i < werfenZahl; i++) {
                boolean kopf = r.nextBoolean();
                if (kopf) {
                    System.out.println("Die Münze ist auf Kopf gelandet ");
                    summeKopf++;
                } else {
                    System.out.println("Die Münze ist auf Zahl gelandet ");
                    summeZahl++;

                }
            }

            System.out.println("summeZahl" + summeZahl);
            System.out.println("summeKopf" + summeKopf);

            if (summeKopf > summeZahl) {
                System.out.println("ich gewinne ich bekomme das Ticket");
            } else if (summeZahl > summeKopf) {
                System.out.println("Stefan gewinnet er bekommt das Tickt");
            } else {
                System.out.println("Keiner gwinner ist unentschieden");
            }
        }
    }

}












