import java.util.Scanner;

public class GaudiMitArraysV2 {
    public static void main(String[] args) {
Scanner sr= new Scanner(System.in);

        String arr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //   int howMuch;
        char[] myArr = arr.toCharArray();
        System.out.println("verschieb nach rechts=Posative zahl");
        System.out.println("verschib nach links=Nigateve Zhal ");
       int howMuch =sr.nextInt();
        for (int i = 0; i < myArr.length; i++) {

            System.out.print(myArr[(i - howMuch + 26) % (26)]);

        }

    }
}
