public class PenPaperAlgorithmen {
    public static void main(String[] args) {


        int number1 = 2;
        int number2 = 2;
        int counter = 6;



        for (int i = 0; counter > i; i++) {
            int sum = number1 + number2;
            System.out.println(number1 + "+" + number2 + "=" + sum);
            number1 = number2;
            number2 = sum;

        }


    }
}
