package connection;

import datatypes.*;
import interfaces.LineSegmentInterface;

import java.util.HashMap;

public class LineSegment implements LineSegmentInterface {
    private Stop nextStop;
    private TimeDiff timeToNextStop;
    private HashMap<Time, Integer> numberOfPassengers;
    private Integer capacity;
    private LineName lineName;


    @Override
    public Pair<Time, StopName> nextStop(Time startTime) {
        return new Pair<>(new Time(startTime.getTime() + timeToNextStop.getTimeDiff()), nextStop.getName());
    }

    @Override
    public Tuple<Time, StopName, Boolean> nextStopAndUpdateReachable(Time startTime) {
        return null;
    }

    @Override
    public void incrementCapacity(Time startTime) {}

    @Override
    public TimeDiff getTimeToNextStop() {
        return timeToNextStop;
    }

    @Override
    public Stop getNextStop() {
        return nextStop;
    }
}
