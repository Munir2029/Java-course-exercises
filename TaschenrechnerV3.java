import java.util.Scanner;

public class TaschenrechnerV3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        char operator = ' ';
        int a;
        int b;

        while (operator != 'x') {

            System.out.println("Gib den Operator(+,-,*,/,%) ein");
            operator = sc.next().charAt(0);

            if (operator == 'x') {
                System.out.println("das Programm bendnet");
            } else if (operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%') {


                System.out.println("Gib erste zhal ein");
                a = sc.nextInt();

                System.out.println("Gib die zweite zhal ein");
                b = sc.nextInt();


                switch (operator) {
                    case '+':
                        System.out.println(a + " + " + b + " = " + (a + b));
                        break;
                    case '-':
                        System.out.println(a + " - " + b + " = " + (a - b));
                        break;
                    case '*':
                        System.out.println(a + " * " + b + " = " + (a * b));
                        break;
                    case '/':
                        System.out.println(a + " / " + b + " = " + ((double) a / b));

                        break;
                    case '%':
                        System.out.println(a + " % " + b + " = " + (a % b));
                        break;


                }
            }
        }
    }
}



