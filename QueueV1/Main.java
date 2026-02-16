package QueueV1;

import stackV1.Element;
import stackV1.Stack;

import java.util.Arrays;
import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {

        Queue neu = new Queue();
        neu.enqueue(2);
        neu.enqueue(23);
        neu.enqueue(1);
        neu.enqueue(7);


        System.out.println(neu);
        System.out.println(Arrays.toString(neu.dequeue(2)));
        System.out.println(neu);
        System.out.println(neu.size());


    }
}
