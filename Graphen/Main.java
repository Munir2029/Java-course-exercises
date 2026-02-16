package Graphen;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        City temp;

        for (int i = 0; i < 4; i++) {
            String city = "City " + i;
            new City(city);
            temp = City.allCities.get(i);
            System.out.println(temp);
        }

        Random r = new Random();
        for (int c = 0; c < City.allCities.size(); c++) {
            for (int k = 0; k < City.allCities.size(); k++) {

                if (c != k) {
                    int welche = r.nextInt(5);
                    switch (welche) {
                        case 0:
                            new Path(City.allCities.get(c), City.allCities.get(k), r.nextInt(100) + 1);
                            break;
                        case 1:
                            new Road(City.allCities.get(c), City.allCities.get(k), r.nextInt(100) + 1);
                            break;
                        case 2:
                            new TrainTracks(City.allCities.get(c), City.allCities.get(k), r.nextInt(100) + 1);
                            break;
                    }
                }


//            City startCity = City.allCities.get(c);
//            City endCity = City.allCities.get(c + 1);
            }
        }
//            System.out.println(Path.allConnections.get(2).start);
//            for (int x = 1; x < 9; x++) {
//
//                new Path(startCity,endCity,100);
//
//            }
//
//        for (City c :City.allCities){
//            int x=0;
//


//        System.out.print(City.allCities);


//
//        for (City c:City.allCities){
//           int count=0;
//        new Path(c,c,200);
//
//            System.out.println(c);
//            count++;
//            System.out.println(count);
//        int[] xValues = {0, 0, 1};
//        int[] yValues = {1, 2, 2};
//        Random r=new Random();
//            for (int x=0;x<3;x++){
////                City temp1=City.allCities.get(x);
////                City temp2=City.allCities.get(x+1);
////                City temp3=City.allCities.get(x+2);
//
//
//    new Path(City.allCities.get(xValues[0]),City.allCities.get(yValues[x]), r.nextInt(100));  //1
//    new Road(City.allCities.get(xValues[0]),City.allCities.get(yValues[x]), r.nextInt(100));
//    new TrainTracks(City.allCities.get(xValues[0]),City.allCities.get(yValues[x]), r.nextInt(100));
////                City co=Connection.allConnections.get(x).end;
////                System.out.println("was ist das "+co);
//                System.out.println(Path.allConnections.get(x).start);
////
//            }


//
//        City city1=new City("Wien");
//        City city2=new City("Linz");
//        City city3=new City("Graz");
//
//        Connection c1 = new Path(city1, city2, 200);
//        Connection c2 = new TrainTracks(city1, city3, 150);
//        Connection c3 = new TrainTracks(city3, city1, 150);
//
        City tmp = City.allCities.get(0);

        double km = 0;
        double zeit = 0;

        int auswahl;
        do {
            System.out.println("Du bist gerade in " + tmp.name + " und hast bis jetzt " + km + " km und " + zeit + "min erreicht");
            System.out.println("Wo willst du hin?");
            int count = 1;
            for (Connection c : tmp.connections) {
                System.out.println(count + ". " + c.start.name + " -> " + c.end.name + "(" + c.distance + "km, " + c.zeit + "min");
                count++;
            }
            auswahl = sc.nextInt();
            if (auswahl <= count && auswahl != 0) {
                km += tmp.connections.get(auswahl - 1).distance;
                zeit += tmp.connections.get(auswahl - 1).zeit;

                tmp = tmp.connections.get(auswahl - 1).end;
            }
        } while (auswahl != 0);

        System.out.println("Tschös mein Liber");
//
//
//
////        System.out.println("City " + city1.name + " Id NR "+city1.id+" ist "+city1.distance+" km");
////        System.out.println("City " + city2.name + " Id NR "+city2.id+" ist "+city2.distance+" km");
////        System.out.println("City " + city3.name + " Id NR "+city3.id+" ist "+city3.distance+" km");
////        TheWay theWay=new TheWay(city1.name,city2.name)
//
//        System.out.println("You are City " +city1.name+ " all together you traveled");
//
    }

}
