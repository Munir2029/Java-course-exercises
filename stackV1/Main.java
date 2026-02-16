package stackV1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(3);
        s.push(4);
        s.push(1);

        System.out.println(s);
        System.out.println("peek: "+ s.peek());
        System.out.println("pop: " + s.pop());
        System.out.println("multipop: " + Arrays.toString(s.pop(2)));
        System.out.println(s);



        System.out.println(s.peek());




    }
}
