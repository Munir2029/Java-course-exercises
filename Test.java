public class Test {


    public static int combinator(int n) {
        if (n > 1)
            return n * combinator(n - 1);
        else return n;
    }



    public static void main(String[] args) {


        System.out.println(combinator(2));

    }
}
