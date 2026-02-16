import java.util.Random;
import java.util.Arrays;

public class GaudiMitStatistikV2 {
    public static void main(String[] args) {


        Random r = new Random();
        int[] myArr = new int[100];
        int wieOft = 0;
        int c=0;
        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = r.nextInt(101);
        }

        System.out.println(Arrays.toString(myArr));
       Arrays.sort(myArr);

        boolean sorterd = false;
        for (int i = 0; !sorterd && i < myArr.length; i++) {

            sorterd = true;
            wieOft++;
            for (int j = 0; j < myArr.length - 1-i; j++) {

                c++;
                if (myArr[j] > myArr[j + 1]) {
                    int temp = myArr[j];
                    myArr[j] = myArr[j + 1];
                    myArr[j + 1] = temp;
                    sorterd = false;

                }

            }


        }
        System.out.println(c+"  "+wieOft + Arrays.toString(myArr));


    }
}




























/*


        Random r = new Random();
        int[] myArr = new int[101];
        int[] geordnetArr = new int[101];
        //Arrays.fill(geordnetArr,-1);
        int maxnum;
        int minnum;
        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = r.nextInt(100);
        }

        System.out.println("unsortierteArray" + Arrays.toString(myArr));
        maxnum = myArr[100];
        minnum = myArr[0];
        System.out.println(minnum);
        System.out.println(maxnum);
        for (int j = 1; j < myArr.length; j++) {
            if (minnum > myArr[j]){
                minnum=myArr[j];
                minnum = myArr[+1];
            }
            if(maxnum<myArr[(100-j)%100]){

                maxnum=myArr[(100-j)%100];

            }


        }

       */
/* if (myArr[i] < minnum){
            myArr[i] = minnum;
            System.out.println(myArr[i]);}

        if (myArr[i] > maxnum){
            myArr[i] = maxnum;

        System.out.println(myArr[i]);}*//*

        //  int x = myArr[i] -1;
        //    System.out.println(x);
        // if()

              */
/*System.out.println(myArr[i]);

            while (x< geordnetArr.length&&myArr[i] == geordnetArr[x]) {
                geordnetArr[x++] = myArr[i];
            }

            geordnetArr[x] = myArr[i];
        *//*

        //  System.out.println(Arrays.toString(myArr));
*/


