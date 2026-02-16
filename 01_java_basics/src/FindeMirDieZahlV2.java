import java.util.Arrays;
import java.util.ArrayList;

public class FindeMirDieZahlV2 {

    public static int binarySearch(int[] arr, int x, int offset) {

        ArrayList<Integer> geteilteArr = new ArrayList<Integer>();
        int mitteVonArr = (arr.length-1) / 2;

        if (arr[0] == x && arr.length==1) {
            return offset;
        } else if(arr.length==1) {
            System.out.println("nicht gefunden");
            return -1;
        }


        if (x <= arr[mitteVonArr]) {
            int[] left = Arrays.copyOfRange(arr, 0, mitteVonArr+1);
            return binarySearch(left, x, offset);
        } else {
            offset = offset+ mitteVonArr + 1;
            int[] rechts = Arrays.copyOfRange(arr, mitteVonArr+1, arr.length);
            return binarySearch(rechts, x, offset);
        }

    }

    public static void main(String[] args) {
        int [] myArr={1,2,4,5,6,7,8};
        int x = 6;
        int pos = binarySearch(myArr,x,0);
        System.out.println(x + " an pos " + pos);
    }
}
