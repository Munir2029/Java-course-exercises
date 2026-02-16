package DateizugriffeV1;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File datei = new File("EinmalEins1.java");

//        System.out.println(datei.isFile());
//
//
//        System.out.println(Dateizugriffe.fileList("src"));
//        List<String> test = Dateizugriffe.readFileLineByLine(datei.getPath());
//
//        System.out.println(test);
//
//        System.out.println("habe geschafft:");
//        for (String line : test) {
//            System.out.println(line);
//        }

        System.out.println("What "+Dateizugriffe.writeFileLineByLine("output.text",new String[]{"alskdjalsjdlak","jdlakjj"},true));


//        Dateizugriffe.readFileLineByLine("output.text");


        System.out.println("lesen "+Dateizugriffe.readFileLineByLine("output.text"));


        Dateizugriffe.recFileStructure("src");

//        System.out.println(Dateizugriffe.recFileStructure("src"));

//        Scanner sr = null;
//        try {
//           sr = new Scanner(datei);
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        }
//
//        while (sr.hasNext()){
//       System.out.println(sr.nextLine());
//        }


    }

}
