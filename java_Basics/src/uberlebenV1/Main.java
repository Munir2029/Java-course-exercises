package uberlebenV1;

import java.util.ArrayList;

public class Main {

    static ArrayList<Human> population = new ArrayList<>();

    public static void main(String[] args) {


        Human h1 = new Human("munir", 20);
        Human h2 = new Human("petra", 20);
        h1.love(h2);

        System.out.println(h2.inLovIn.name);
        Human child=h1.hasChildWithLover(h2);
        if (child != null) {
            population.add(child);
        }




    }
}
