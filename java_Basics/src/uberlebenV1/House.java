package uberlebenV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class House {
    static int counter = 0;
    Random n = new Random();
    int age;
    int perfection;
    int nr;
    static ArrayList<House> allHouses = new ArrayList<>();

    public House(Human one, Human two) {
        counter++;
        this.age = 0;
        this.nr = counter;
        this.perfection = (one.intelligence + two.intelligence) / 2 + (one.strength + two.strength) / 2;
        System.out.println(one.name + " and " + two.name + " build a house with perfection " + this.perfection);

        one.livesIn = this;
        two.livesIn = this;

        allHouses.add(this);
    }

    public boolean getOlder() {
        age++;
        if (n.nextInt(age) > perfection) {
            System.out.println("Haus nr " + this.nr + " ist kaputt");
            return false;
        }
        return true;
    }

    public String toString() {
        return "House.NR " + nr + "\n age of The House "
                + age + "\n how good is the house " + perfection;
    }
}



