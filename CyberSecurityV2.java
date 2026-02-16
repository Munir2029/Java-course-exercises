import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class CyberSecurityV2 {


    public static int inputBetween(int low, int high, String text) {
        Scanner sc = new Scanner(System.in);
        int choiceZhal;

        do {
            System.out.println(text);
            System.out.println("wähle ein zhal zwischen " + low + " und " + high);

            choiceZhal = sc.nextInt();

        } while (choiceZhal < low || choiceZhal > high);

        System.out.println(choiceZhal);


        return choiceZhal;

    }

    public static String changText() {
        Scanner sr = new Scanner(System.in);
        System.out.println("gib der new Text ein");
        return sr.nextLine();

    }


    public static String encode(String textencode) {
        char[] chars = textencode.toCharArray();
        Scanner sr = new Scanner(System.in);
        System.out.println("How far do you want me to encode the text?");
        int howMuch = sr.nextInt();

        //ArrayList<Character> ch = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] >= 'A' && chars[i] < 91) {
                chars[i] = (char) ((chars[i] - 65 + howMuch) % 26 + 65);
            } else {                 //        3                    68

                chars[i] = chars[i];
                //DDD    BBB
                // ABC    65 66 67    DEF 68 69 70

            }

        }


        return String.valueOf(chars);
    }


    public static String Decode(String textdecode)
    {
        char[] decode = textdecode.toCharArray();

        Scanner sr = new Scanner(System.in);
        System.out.println("How far do you want me to encode the text?");
        int shift = sr.nextInt();


        //DDDaaa
        for (int i = 0; i < decode.length; i++) {
            if (decode[i] >= 'A' && decode[i] < 91) {
                decode[i] = (char) ((decode[i] - 65 - shift + 26) % 26 + 65);
                //68        -65=3 -3 +26
                //D
                //65          -65=0 -3 +26 =23 23+65=88
                //A


            } else {
                decode[i] = decode[i];
            }
        }

        return String.valueOf(decode);
    }


    public static void main(String[] args) {


        Scanner sr = new Scanner(System.in);


        int c = 1;

        String text = "ABC";
        while (c > 0 && c < 4) {
            System.out.println("Text: " + text);
            c = inputBetween(1, 4, "1. Change text\n2. Encode by X?\n3. Decode by X\n4. EXIT");


            switch (c) {
                case 1:
                    text = changText();
                    break;
                case 2:
                    text = encode(text);
                    break;
                case 3:
                    text = Decode(text);
                default:
            }
        }

        System.out.println("Aufwiedersehen");
    }
}
