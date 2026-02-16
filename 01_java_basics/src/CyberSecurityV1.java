import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CyberSecurityV1 {
    public static void main(String[] args) {


        Random r = new Random();
        ArrayList<Integer>bs=new ArrayList<>();
        int min = 48;
        int max = 58;
        int sumCounter=0;
        int wieOft = 20;
        int counter = 0;
        for (int x = 0; x < wieOft; x++) {

            String pwd = "";
            for (int i = 0; i < 4; i++) {
                pwd += (char) r.nextInt(min, max);
            }
            System.out.println(pwd);


            boolean gefunden = false;
            for (int i = 0; i < max - min && !gefunden; i++) {
                for (int j = 0; j < max - min && !gefunden; j++) {
                    for (int k = 0; k < max - min && !gefunden; k++) {
                        for (int l = 0; l < max - min && !gefunden; l++) {
                            String guess = "" + (char) (i + min) + (char) (j + min) + (char) (k + min) + (char) (min + l);
                            counter++;
                            //System.out.println(guess + "==?" + pwd);
                            if (pwd.equals(guess)) {
                                gefunden = true;
                                System.out.println("took " + counter + " guess");
                                System.out.println("Password is " + guess);

                                bs.add(counter);
                                sumCounter+=counter;
                            }




                        }

                    }
                }
            }


        }
        int durchschnittlich=counter/wieOft;
        System.out.println("counter "+ sumCounter);
        System.out.println("durchschnitlich "+(double)durchschnittlich);
        System.out.println(bs);
        int minmum =1000000000;
        int maximal=0;

        for (int i = 0; i < bs.size(); i++) {
            if (bs.get(i)<minmum){
                minmum=bs.get(i);
            }
           else if(bs.get(i)>maximal){
                maximal= bs.get(i);
            }
        }
        System.out.println("Best case was "+minmum+" guesses");
        System.out.println("worst case was "+maximal+" guesses");


    }
}
