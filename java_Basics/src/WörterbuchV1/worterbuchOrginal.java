package WörterbuchV1;

import DateizugriffeV1.Dateizugriffe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class worterbuchOrginal {

    static HashMap<String, String> worterbuchDE = new HashMap<>();
    static HashMap<String, String> dictionaryED = new HashMap<>();

    static String path = "C://Users//Codersbay//IdeaProjects//itOrietirung1//src//WörterbuchV1//allWords";


    public static void main(String[] args) {


        String deutscheText = "ich! ,ge?he? einkaufen? mit milad!1";
        String englischText = "I? stay! at% Home in! meinem! Home???? in Linz!! ";

        String transletedTextDeutsch = "";

        File file = new File("allWords");
        List<String> lines = Dateizugriffe.readFileLineByLine(path);

        int count = 0;
        for (String line : lines) {
            String[] word;
            //line = line.replaceAll(";", ", ");


            word = line.split(";");

            add2all(word[0], word[1]);

            count++;
            if (count > 200)
                System.out.println("sd");

//            System.out.println("word " + Arrays.toString(word));
//            System.out.println("hhhhhh "+word[0]);
//            System.out.println("bbbb "+word[1]);
//
//            add2all(word[0], word[1]);
//            System.out.println("line " + line);

        }

        System.out.println("lines" + lines.size());

        //test
        for (int x = 0; x < worterbuchDE.size(); x++) {

            System.out.print(worterbuchDE.size());
            System.out.println(" ");
        }
//
//        for (String line:lines){
//
//
//
//        }

//        englischText = englischText.replaceAll("[?!]+", "");

        translateEnDe(englischText);
        System.out.println(" ");
        System.out.println("original: " + englischText);
        String translatedEn = translateEnDe(englischText);
        System.out.println("translated: " + translatedEn);


        translateDeEn(deutscheText);
        System.out.println(" ");
        System.out.println("original: " + deutscheText);
        String translatedDe = translateDeEn(deutscheText);
        System.out.println("translated: " + translatedDe);
//
//        String s = translateEnDe(englischText);
//
//        System.out.println("translate test " + s);
//
//        String welcheSprache = guessLanguage(englischText);
//
//
//        System.out.println("die Sprache ist " + welcheSprache);
//
//
//        System.out.println("translate any language " + translateAnyLanguage(englischText));


        String s = translateEnDe(englischText);

        System.out.println("translate test " + s);
    }


    public static void add2all(String german, String english) {
        worterbuchDE.put(german, english);
        dictionaryED.put(english, german);
    }

    public static String translateEnDe(String text) {

        String[] arrEnglischText = text.split(" ");
        String ret = "";


        for (String s : arrEnglischText) {

            String onlyWord = s.replaceAll("[^A-Za-zÄÖÜäöüß ]", "");

            System.out.println("onlyword " + onlyWord);
//            String extraBuchstaben = s.replaceAll("[A-z]", "");

            if (dictionaryED.containsKey(onlyWord)) {

                ret += s.replaceAll(onlyWord, dictionaryED.get(onlyWord));

            } else if (worterbuchDE.containsKey(onlyWord)) {
                ret += s;
            } else {
                ret += s.replaceAll(onlyWord, addAnewWord(onlyWord));;
            }
            ret += " ";
        }

        return ret;
    }

    public static String translateDeEn(String text) {

        System.out.println(text);
        System.out.println(worterbuchDE);

        String[] arrDeutscheText = text.split(" ");
        String ret = "";


        for (String s : arrDeutscheText) {


            String onlyWord = s.replaceAll("[!-@]", "");

            //String extraBuchstaben = s.replaceAll("[A-z]", "");


            if (worterbuchDE.containsKey(onlyWord)) {
                ret += s.replaceAll(onlyWord, worterbuchDE.get(onlyWord));
            } else if (dictionaryED.containsKey(onlyWord)) {
                ret += s;
            } else {
                ret += s.replaceAll(onlyWord, addAnewWord(onlyWord));;
            }
            ret += " ";
        }

        return ret;
    }

    public static String guessLanguage(String text) {

        File file = new File("allWords");
        // إزالة علامات الترقيم
        text = text.replaceAll("[^A-Za-zÄÖÜäöüß ]", "");
        String[] words = text.split("\\s+");      // يقسم إلى كلمات

        int deCount = 0;
        int enCount = 0;

        for (String word : words) {
            // نحاول مقارنة الكلمات كما هي وكذلك بصيغة lowercase
            String lowerWord = word.toLowerCase();

            if (worterbuchDE.containsKey(word) || worterbuchDE.containsKey(lowerWord)) {
                deCount++;
            }
            if (dictionaryED.containsKey(word) || dictionaryED.containsKey(lowerWord)) {
                enCount++;
            }
        }

        if (deCount == 0 && enCount == 0) {
            return "unknown";
        } else if (deCount > enCount) {
            return "de";
        } else {
            return "en";
        }
    }

    public static String translateAnyLanguage(String text) {
        String resulte = "";
        String whatsLanguage = guessLanguage(text);
        if (whatsLanguage.equals("de")) {
            resulte = translateDeEn(text);

        } else if (whatsLanguage.equals("en")) {
            resulte = translateEnDe(text);

        } else {
            resulte = "unbekante Sprache";
        }
        return resulte;
    }

    public static String addAnewWord(String neuword) {
        Scanner sr = new Scanner(System.in);
        System.out.println("Ich kenne dieses Word " + "( " + neuword + " )" + " nicht ist das Deutsch oder Englisch?\n für DeutschDrücken Sie 1 \nFür Englisch Drücken Sie 2");
        int GermanOrEnglish = sr.nextInt();

        if (GermanOrEnglish == 1) {
            System.out.println("was bedutet " + " (" + neuword + ")" + " auf Englisch");
            String userTranslationEnDe = sr.next();
            add2all(neuword, userTranslationEnDe);

            String[] insert = {
                    neuword + ";" + userTranslationEnDe,
            };

            Dateizugriffe.writeFileLineByLine(path, insert, true);

            return  userTranslationEnDe;
        } else {
            System.out.println("What dose it mean " + "(" + neuword + ")" + " In German");
            String userTranslationDeEn = sr.next();
            add2all(userTranslationDeEn, neuword);

            String[] insert = {
                    userTranslationDeEn + ";" + neuword,
            };

            Dateizugriffe.writeFileLineByLine(path, insert, true);

            return userTranslationDeEn;
        }


    }

}



