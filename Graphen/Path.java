package Graphen;

public class Path extends Connection {
    public Path(City start, City end, double distance) {

        super(start, end, distance, distance);
    }
}
