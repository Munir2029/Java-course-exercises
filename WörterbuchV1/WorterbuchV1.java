package WörterbuchV1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class WorterbuchV1 {
    static HashMap<String, String> worterbuchDE = new HashMap<>();
    static HashMap<String, String> dictionaryED = new HashMap<>();

    public static void main(String[] args) {
//        String deutscheText = "ich gehe einkaufen mit milad!!!2-123";
       String englischText = "I stay at Home in meinem! Haus, hiewwd73a2? ";

        String transletedTextDeutsch = "";


        worterbuchDE.put("Äpfel", "Apple");
        worterbuchDE.put("ich", "I");
        worterbuchDE.put("gehe", "go");
        worterbuchDE.put("einkaufen", "to shopping");
        worterbuchDE.put("Haus", "Home");

        dictionaryED.put("Apple", "Äpfel");
        dictionaryED.put("I", "ich");
        dictionaryED.put("go", "gehen");
        dictionaryED.put("toshopp", "einkaufen");
        dictionaryED.put("Home", "Haus");
        dictionaryED.put("stay", "bleibe");
        dictionaryED.put("at", "zu");

        englischText = englischText.replaceAll("[?!]+", "");

//      translate(deutscheText);
        System.out.println(" ");
        System.out.println("original: "+ englischText);
       String translated = translate(englischText);
        System.out.println("translated: " + translated);


    }

    public static String translate(String text) {

        String[] arrDeutschText = text.split(" ");
        String ret = "";


        for (String s : arrDeutschText) {

            if (worterbuchDE.containsKey(s)) {
//                System.out.print(worterbuchDE.get(s));
                ret += worterbuchDE.get(s);
//                System.out.print(" ");
            }
            else if(dictionaryED.containsKey(s)) {
//                System.out.print(dictionaryED.get(s));
                ret += dictionaryED.get(s);
//                System.out.print(" ");
            }
         else{
//             System.out.println(s);
             ret += s;
//             System.out.println(" ");
        }
         ret += " ";
    }

        return ret;
}


}
