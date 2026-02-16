import java.util.Scanner;

public class BetrunkenV2 {


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Wie alt bist du?");
        int age = s.nextInt();


        System.out.println("Hast du deinen Führerschein dabei?");
        boolean license = s.nextBoolean();

        System.out.println("Wie viel Bier hast du getrunken?");
        int bier = s.nextInt();

        System.out.println("Wie viel Shots hast du getrunken?");
        int shots = s.nextInt();

        if(age>=17 && age <19 && license && bier+shots==0||age>=19 && bier+shots<=2&&license ){
            System.out.println("Du darfst Auto fahren");
        }else {
            System.out.println("Du darfst nicht fahren");
        }


    }


}