package connection;

import java.util.HashMap;

public class LineSegment {
    private Stop nextStop;
    private TimeDiff timeToNextStop;
    private HashMap<Time, Integer> numberOfPassengers;
    private Integer capacity;
    private LineName lineName;

    public HashMap<Time, StopName> nextStop(Time startTime) {
        return null;
    }

//    public tuple<Time, StopName, Boolean> nextStopAndUpdateReachable(Time startTime) {
//        return null;
//    }

    public void incrementCapacity(Time startTime) {}
}
