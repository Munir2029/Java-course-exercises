package Graphen;

public class TrainTracks extends Connection {
    public TrainTracks(City start, City end, double distance) {

        super(start, end, distance, distance/10);
    }
}
