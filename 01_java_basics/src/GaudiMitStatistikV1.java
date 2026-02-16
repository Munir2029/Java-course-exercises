public class GaudiMitStatistikV1 {
    public static void main(String[] args) {
        int uppercaseLetters = 0;
        int lowercaseLetters = 0;
        int number = 0;
        int specialCharacters = 0;
        String sentence = "Unter #Handy finden sich 6 große Anbieter, 2 davon sind aber die besten!";
        char[] myArr = sentence.toCharArray();   //   jz ist die sentence ist ein Char Arr

        for (int i = 0; i < myArr.length; i++) {
            char wichLetter = sentence.charAt(i);        // beispiel  sentence.charAt(0)== 'U' unsw

            if (wichLetter >='0' && wichLetter <= '9') {        //ich muss noch ausbessern
                number++;
            } else if (sentence.charAt(i) >= 'A' && sentence.charAt(i) < 91) {
                uppercaseLetters++;

            } else if (sentence.charAt(i) < 123 && sentence.charAt(i) > 96) {
                lowercaseLetters++;

            } else {
                specialCharacters++;
            }

        }
        System.out.println("Großbuchstaben: " + uppercaseLetters);
        System.out.println("Kleinbuchstaben: " + lowercaseLetters);
        System.out.println("zhalen: " + number);
        System.out.println("sonderzeichen:" + specialCharacters);


    }
}
