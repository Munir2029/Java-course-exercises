import java.util.Arrays;

public class EinfacheSortieralgorithmen {
//4321

    public static int[] BubbleSort(int[] ansortedArrOriginal, int counter) {

        int[] ansortedArr = ansortedArrOriginal.clone();

        boolean sorterd = false;
        for (int i = 0; !sorterd && i < ansortedArr.length; i++) {

            sorterd = true;
            counter++;
            for (int j = 0; j < ansortedArr.length - 1 - i; j++) {

                counter++;
                if (ansortedArr[j] > ansortedArr[j + 1]) {
                    int temp = ansortedArr[j];
                    ansortedArr[j] = ansortedArr[j + 1];
                    ansortedArr[j + 1] = temp;
                    sorterd = false;

                }

            }


        }
        System.out.println(counter + "  " + counter + Arrays.toString(ansortedArr));

        return ansortedArr;


    }

//        if (index == ansortedArr.length - 1) {
//            counter++;
//            index = 0;
//        }
//        if (counter >= ansortedArr.length - 2) {
//            return ansortedArr;
//
//        } else if (ansortedArr[index] <= ansortedArr[index + 1]) {
//            index++;
//            return BubbleSort(ansortedArr, index, counter);
//
//
//        } else if (ansortedArr[index] > ansortedArr[index + 1]) {
//
//            int temp = ansortedArr[index];
//            ansortedArr[index] = ansortedArr[index + 1];
//            ansortedArr[index + 1] = temp;
//            index++;
//        }
//        return BubbleSort(ansortedArr, index, counter);
//    }


//
//     System.out.println("3");
//            System.out.println("index= " + index);
//            System.out.println("conter = " + counter);


//
//    System.out.println("2");
//            System.out.println("index= " + index);
//            System.out.println("conter = " + counter);


//        boolean sorterd = false;
//        for (int i = 0; i < ansortedArr.length && !sorterd; i++) {
//            sorterd = true;
//            for (int j = 0; j < ansortedArr.length; j++) {
//
//                if (ansortedArr[j] > ansortedArr[j + 1]) {
//                    int temp = ansortedArr[j];
//                    ansortedArr[j] = ansortedArr[j + 1];
//                    ansortedArr[j + 1] = temp;
//                    sorterd = false;
//                }
//
//            }
//
//        }
//
//        return ansortedArr;
//    }


//        System.out.println(Arrays.toString(ansortedArr));
//        if (counter >= ansortedArr.length - 1) {
//
//            System.out.println("1");
//            System.out.println("index= " + index);
//            System.out.println("conter = " + counter);
//            return ansortedArr;
//        }
//
//
//        if ( index>=ansortedArr.length-1 ) {
//            counter++;
//            index = 0;
//            System.out.println("2");
//            System.out.println("index = " + index);
//            System.out.println("conter = " + counter);
//        }
//
//
//        if (ansortedArr[counter] > ansortedArr[index + 1]) {
//
//            int temp = ansortedArr[counter];
//            ansortedArr[counter] = ansortedArr[index + 1];
//            ansortedArr[index+1]=temp;
//            System.out.println(Arrays.toString(ansortedArr));
//
//            System.out.println("3");
//            System.out.println("index= " + index);
//            System.out.println("conter = " + counter);
//
//
//            SelectionSort(ansortedArr, index + 1, counter);
//
//        } else {
//            SelectionSort(ansortedArr, index + 1, counter);
//            System.out.println("4");
//            System.out.println("index= " + index);
//            System.out.println("conter = " + counter);
//        }
//        System.out.println("5");
//        System.out.println("index = " + index);
//        System.out.println("conter = " + counter);
//
//        return ansortedArr;
//    }


    public static int[] SelectionSort(int[] ansortedArrOriginal) {

        int[] ansortedArr = ansortedArrOriginal.clone();

        System.out.println("anfang " + Arrays.toString(ansortedArr));
        for (int i = 0; i < ansortedArr.length - 1; i++) {
            System.out.println("1");
            int minIndex = i;
            for (int j = i + 1; j < ansortedArr.length; j++) {
                System.out.println("2");
                if (ansortedArr[j] < ansortedArr[minIndex]) {
                    minIndex = j;
                    System.out.println("minIndex= " + minIndex);

                    System.out.println(Arrays.toString(ansortedArr));

                }
            }

            if (minIndex != i) {
                int temp = ansortedArr[i];
                ansortedArr[i] = ansortedArr[minIndex];
                ansortedArr[minIndex] = temp;
            }
        }

        return ansortedArr;
    }

    public static int[] InsertionSort(int[] ansortedArrOriginal) {
//
        int[] ansortedArr = ansortedArrOriginal.clone();

       // {3, 4, 5, 6,};
        for (int i = 1; i < ansortedArr.length; i++) {
          int temp=ansortedArr[i]; // =3
          int j=i;         //j=3
                               //5        4
            while (j>0 &&ansortedArr[j-1]>temp) {
                //4           //5
              ansortedArr[j]=ansortedArr[j-1];
              //5               //5
                j--;
            }
            ansortedArr[j]=temp;


        }



        return ansortedArr;
    }


    public static void main(String[] args) {


        int[] myAnsortedArr = {5, 3, 2, 1,6,2,};
        //int[] myInsertionSortArry = InsertionSort(myAnsortedArr);
//        int[] mySortierdtArr = SelectionSort(myAnsortedArr);
        System.out.println("Original " + Arrays.toString(myAnsortedArr));
        System.out.println("My sorted Arr bubble" + Arrays.toString(BubbleSort(myAnsortedArr, 0)));
        System.out.println("My sorted Arr selection" + Arrays.toString(SelectionSort(myAnsortedArr)));
        System.out.println("My sorted Arr insertion" + Arrays.toString(InsertionSort(myAnsortedArr)));


    }
}


