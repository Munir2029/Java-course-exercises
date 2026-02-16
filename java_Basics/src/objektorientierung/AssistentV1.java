package objektorientierung;

import java.util.Scanner;

public class AssistentV1 {
    public static int inputBetween(int low, int high, String text) {
        Scanner sc = new Scanner(System.in);
        int choiceZhal;

        do {
            System.out.println(text);
            System.out.println("wähle ein zhal zwischen " + low + " und " + high);

            choiceZhal = sc.nextInt();

        } while (choiceZhal < low || choiceZhal > high);

        System.out.println(choiceZhal);


        return choiceZhal;

    }
}
