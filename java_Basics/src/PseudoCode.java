
import java.util.Scanner;

public class PseudoCode {
    public static void main(String[] args) {
        int number;
        boolean primeNumber = false;
        int counter = 0;
        Scanner sr = new Scanner(System.in);
        boolean repetition = true;
        while (repetition) {
            System.out.println("gib ein Zhal ");
            number = sr.nextInt();


            if (number % 2 == 0 && number != 2 || number < 2) {
                primeNumber = false;
            } else if (number == 2) {
                primeNumber = true;
            } else {
                for (int c = 3; c<number; c=c+2) {
                    if (number % c == 0) {

                        counter++;
                        System.out.println("wie oft");
                    }
                }
                if (counter == 0 || number==3) {
                    primeNumber = true;

                } else {
                    primeNumber = false;
                }

            }

            if (primeNumber) {
                System.out.println(number + " " + "ist primeNumber");
            } else {
                System.out.println(number + " " + "ist nicht primeNumber");
            }
            System.out.println("repetition" + "=" + "true" + " to end" + "=" + "false");
            repetition = sr.nextBoolean();


        }
        System.out.println("Tschüss");


    }
}









