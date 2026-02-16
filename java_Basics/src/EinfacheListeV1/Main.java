package EinfacheListeV1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

      MyList myArr = new MyList();
    myArr.add(5);
     myArr.add(4);
     myArr.add(2);
     myArr.add(1);
      myArr.add(37);
     myArr.add(488);

//        System.out.println(myArr.remove(2));
//        System.out.println(myArr.remove(0));
        System.out.println(myArr);
        myArr.sort();
//      myArr.add(0,7);
 //     myArr.get(2);

        System.out.println(myArr);
    }

}
