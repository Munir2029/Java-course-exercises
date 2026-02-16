import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;


public class FindeMirDieZahlV1 {

    public static void main(String[] args) {
int[] myArry={1,2,3,4,5,6,7,8,9,9,9,9,4,4,4,4,9,1,1};
int[] pos =indexesOf(myArry,9);
        System.out.println("indizes:"+ Arrays.toString(pos));
    }

    public static int[] indexesOf(int[] arr, int value) {
        ArrayList<Integer> gefundenePosition = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                gefundenePosition.add(i);
            }
        }

        int[] ret = new int[gefundenePosition.size()]; // array erstellen, basierend auf Anzahl gefundenePosition
        for (int i = 0; i < gefundenePosition.size(); i++) { // gefundenePosition-Werte in array schreiben
            ret[i] = gefundenePosition.get(i);
        }

        if (gefundenePosition.size()>0) {
            return ret;
        }
        else {
            return new int[] {-1};
        }


        // TODO: sucht nach ALLEN Zahlen value im Array arr
        // return: Array aller Positionen im Array oder [] wenn nicht gefunden
    }

}
