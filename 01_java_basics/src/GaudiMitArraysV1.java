import java.util.Arrays;
import java.util.Random;

public class GaudiMitArraysV1 {
    public static void main(String[] args) {
        Random r = new Random();

        int[] theFirst = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        for (int i = 0; i < theFirst.length; i++) {
            System.out.print(theFirst[i]+" ");


        }
        System.out.println();


        int[] a = new int[100];
        for (int x = 0; x < a.length; x++) {
            a[x] = r.nextInt(100);
            System.out.println(a[x]);

        }

        boolean[] s = new boolean[10];
        System.out.println(Arrays.toString(s));

        for (int c = 1; c < s.length; c++) {
            s[c] = ! s[c - 1];
        }
        System.out.println(Arrays.toString(s));
    }
}


