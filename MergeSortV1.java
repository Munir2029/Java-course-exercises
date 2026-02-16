import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortV1 {

    public static int[] mergeSortV1(int[] ansortedArr) {

        if (ansortedArr.length == 1) {
            return ansortedArr;
        }

        int dieMitteVonAnsortedArr = (ansortedArr.length - 1) / 2;


        int[] leftAnsortedArr;
        int[] rightAnsortedArr;


        System.out.println("mitte von Arr= " + dieMitteVonAnsortedArr);  //test

        leftAnsortedArr = Arrays.copyOfRange(ansortedArr, 0, dieMitteVonAnsortedArr + 1);
        System.out.print(Arrays.toString(leftAnsortedArr));      //test
        System.out.print("              ");
        rightAnsortedArr = Arrays.copyOfRange(ansortedArr, dieMitteVonAnsortedArr + 1, ansortedArr.length);
        System.out.println(Arrays.toString(rightAnsortedArr));
        System.out.println("left                         right");

        int[] leftPart = mergeSortV1(leftAnsortedArr);
        int[] rightPart = mergeSortV1(rightAnsortedArr);

        return merge(leftPart, rightPart);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];

        int indexOfLeft = 0;
        int indexOfRight = 0;
        int indexOfarr = 0;

        while (indexOfLeft < left.length && indexOfRight < right.length) {
            if (left[indexOfLeft] <= right[indexOfRight]) {
                arr[indexOfarr] = left[indexOfLeft];
                indexOfLeft++;
                indexOfarr++;
            } else {
                arr[indexOfarr] = right[indexOfRight];
                indexOfRight++;
                indexOfarr++;
            }
        }

        while (indexOfLeft<left.length) {
            arr[indexOfarr] = left[indexOfLeft];
            indexOfLeft++;
            indexOfarr++;
        }
        while (indexOfRight<right.length){

            arr[indexOfarr] = right[indexOfRight];
            indexOfRight++;
            indexOfarr++;
        }


        System.out.println("Merging " + Arrays.toString(left) + " and " + Arrays.toString(right) + " -> " + Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {
        int[] myansortedArr = {3, 4, 3, 2, 1, 0, 2};
        System.out.println(Arrays.toString(myansortedArr));
        mergeSortV1(myansortedArr);


    }
}
