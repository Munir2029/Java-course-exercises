package Graphen;

import java.util.ArrayList;

public class City {

    String name;
    public ArrayList<Connection> connections;
    static ArrayList<City> allCities = new ArrayList<>();


    public City(String name) {
        this.name = name;
        this.connections = new ArrayList<>();
        allCities.add(this);
    }
    //public double move()
    public String toString() {

        return this.name;
    }
}
