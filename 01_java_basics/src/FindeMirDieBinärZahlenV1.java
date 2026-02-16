import java.util.ArrayList;
import java.util.Scanner;


public class FindeMirDieBinärZahlenV1 {

    public static String dec2binary(int tester) {
        System.out.println("angekommen mit " + tester);
        int binärZahl= tester%2;
        if (tester<=1){
            System.out.println("rausgehen ALT mit " + tester);
            return Integer.toString(tester);

        }else {
            System.out.println("reingehen ALT mit " + tester/2);
            String result = dec2binary(tester / 2)+binärZahl;
            System.out.println("rausgehen mit result: " + result);
            return result;
        }

    }

    public static void main(String[] args) {
        while (true) {
            Scanner sr = new Scanner(System.in);

            System.out.println("Gib Sie der Zhal den Sie als BinärZhal umwandelen wollen");

            int tester = sr.nextInt();

            String b = dec2binary(tester);
            b = new StringBuilder(b).reverse().toString();
            System.out.println(b);

        }
    }
}
