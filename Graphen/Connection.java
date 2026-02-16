package Graphen;

import java.util.ArrayList;

public abstract class Connection {
    City start;
    City end;
    double distance;
    double zeit;

    static ArrayList<Connection> allConnections = new ArrayList<>();

    public Connection(City start, City end, double distance, double zeit) {
        this.start = start;
        this.end = end;
        this.zeit = zeit;
        this.distance = distance;
        this.start.connections.add(this);

        allConnections.add(this);
    }

}