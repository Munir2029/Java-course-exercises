package JUnitTests1;

import static java.lang.Integer.parseInt;

public class Rechner implements RechnerInterface{

    public int division(int a, int b) {


        if (b==0) {
            return -1;
        } else {
            int resultat = a / b;
            return resultat;
        }


    }

    public boolean isTheRightName(String name){

        if(name.equals("munir")){
            return true;
        }else {
            return false;
        }
    }


//    public boolean einfachNameOhneZahlOderZichen(){
//
//
//        //Mohsens Methode
//
//    }

    public boolean einfachNameOhneZahlOderZichen(String name) {
int counterTrue=0;
int counterfalse=0;

        char[] M = name.toCharArray();

        for (int i = 0; i < M.length; i++) {
            char L = M[i];  //mun3ir
            if ((L >= 65 && L <= 99) || (L >= 97 && L <= 122)) {
                //
                counterTrue++;
            } else {
                counterfalse++;

            }

        }
        if(counterfalse>0) {
            return false;
        }else {
            return true;
        }
    }
}





