package DateizugriffeV1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;

public class Dateizugriffe {


    public Dateizugriffe() {


    }


    public static boolean fileExists(String path) {
        boolean isDa = false;
        File test = new File(path);
        if (test.exists()) {
//            System.out.println("The File is Exists " + path);
            isDa = true;
        } else {
//            System.out.println("The File is not Exists " + path);
        }

        return isDa;
    }


    public static ArrayList<String> fileList(String path) {
        ArrayList<String> ret = new ArrayList<>();

        File f = new File(path);

        if (f.isDirectory()) {
            System.out.println(Arrays.toString(f.listFiles()));
            for (File one : f.listFiles()) {

                ret.add(one.getName());
            }
        }
        return ret;
    }


    public static ArrayList<String> readFileLineByLine(String path) {
        ArrayList<String> ret = new ArrayList<>();

        try {
            File file = new File(path);

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                ret.add(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("The File is not Exists");
        }


        return ret;
    }

    public static boolean writeFileLineByLine(String path, String[] lines, boolean append) {

        try
                (FileWriter writer = new FileWriter(path, append)) {
            for (String line : lines) {
                writer.write(line + "\n");
            }


        } catch (IOException e) {
            System.out.println("Fehler" + e.getMessage());
        }

        return append;
    }


    public static void recFileStructure(String path) {
        recFileStructure(path, 0);
    }
    public static void recFileStructure(String path, int depth) {
        File file = new File(path);
        if (file.exists()) {
            System.out.println("--".repeat(depth) + file.getName());

            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    recFileStructure(f.getPath(), depth + 1);
                }
            }
        }


    }

}