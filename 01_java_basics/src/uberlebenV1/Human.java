package uberlebenV1;

import java.util.ArrayList;
import java.util.Random;

public class Human {
    Random rn = new Random();

   static int counter = 0;
    String name;
    char gender;
    int age;
    int beauty;
    int strength;
    int intelligence;
    Human inLovIn;
    House livesIn;
    Human mightLove;
  static   ArrayList<Human>allHuman=new ArrayList<>();


    public Human(String name, int age) {
counter++;
        this.name = name;
        if (rn.nextBoolean()) {
            this.gender = 'f';
        } else {
            this.gender = 'm';
        }
        this.age = age;
        this.strength = rn.nextInt(11);
        this.intelligence = rn.nextInt(11);
        this.beauty = rn.nextInt(11);
allHuman.add(this);
    }


    //noch nicht fertig ich muss noch ausbessern
    public boolean getOlder() {
        age++;


        if (livesIn == null && rn.nextInt(age) > strength * 10) {
            System.out.println(this.name + " ist gestorben");
            return false;

        } else if (livesIn != null && age > strength * 10 * 2) {
            System.out.println(this.name + " ist gestorben");
            return false;
        } else {
            return true;
        }
    }

    public boolean mightLove(Human other) {
        if ((this.age >= 18 && other.age >= 18 && other.inLovIn == null) && (other.beauty > this.beauty || other.intelligence > this.intelligence || other.strength > this.strength)) {
            return true;
        } else {
            return false;
        }
    }

    public void love(Human other) {
        if (this.mightLove(other) && other.mightLove(this)) {
            this.inLovIn = other;
            other.inLovIn = this;

        }
    }

    public Human hasChildWithLover(Human other) {

        if (this.inLovIn.gender == 'f' && other.inLovIn.gender == 'm' || this.inLovIn.gender == 'm' && other.inLovIn.gender == 'f') {
            Human child = new Human("child", 0);
            child.strength = (this.inLovIn.strength + other.inLovIn.strength) / 2;
            child.intelligence = (this.inLovIn.intelligence + other.inLovIn.intelligence) / 2;
            child.beauty = (this.inLovIn.beauty + other.inLovIn.beauty) / 2;

            this.strength--;
            other.strength--;

            System.out.println(this.name + " and " + other.name + " have a child with name " + child.name);
            return child;
        } else {
            return null;
        }
    }


    public String toString() {

        return " name " + name + " \n  age " + age + " alt" + " \n gender " + gender +
                " \n strength " + strength + "\n intelligence " + intelligence;
    }

}


