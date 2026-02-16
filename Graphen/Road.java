package Graphen;

public class Road extends Connection {
    public Road(City start, City end, double distance) {
        super(start, end, distance, distance/2);
    }
}
