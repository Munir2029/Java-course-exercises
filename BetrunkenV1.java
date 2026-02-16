import java.util.Scanner;

public class BetrunkenV1 {public static void main(String []args){

    Scanner s = new Scanner(System.in);

    System.out.println("Wie viel Bier hast du getrunken?");
    int bier = s.nextInt();

    System.out.println("Wie viel Shots hast du getrunken?");
    int shots = s.nextInt();
if ( bier == 0 && shots == 0){
    System.out.println("Gar nicht betrunken");
}else if (bier + shots <=2 ){
    System.out.println("leicht betrunken");
}else if ( shots == 0&& bier+shots<=6 ){
    System.out.println("Betrunken");
}else {
    System.out.println("Hoffnungslos betrunken");
}






}
}
