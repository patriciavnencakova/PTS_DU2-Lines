package connection;

import datatypes.*;
import interfaces.LineSegmentInterface;

import java.util.HashMap;

public class LineSegment implements LineSegmentInterface {
    private final Stop nextStop;
    private final TimeDiff timeToNextStop;
    private final HashMap<Time, Integer> numberOfPassengers;
    private final Integer capacity;
    private final LineName lineName;

    public LineSegment(Stop nextStop, TimeDiff timeToNextStop, HashMap<Time, Integer> numberOfPassengers, Integer capacity, LineName lineName) {
        this.nextStop = nextStop;
        this.timeToNextStop = timeToNextStop;
        this.numberOfPassengers = numberOfPassengers;
        this.capacity = capacity;
        this.lineName = lineName;
    }

    @Override
    public Pair<Time, StopName> nextStop(Time startTime) {
        return new Pair<>(new Time(startTime.getTime() + timeToNextStop.getTimeDiff()), nextStop.getName());
    }

    @Override
    public Triplet<Time, StopName, Boolean> nextStopAndUpdateReachable(Time startTime) {
        Time time = new Time(timeToNextStop.getTimeDiff() + startTime.getTime());
        if (!(numberOfPassengers.get(startTime) < capacity)) return new Triplet<>(time, nextStop.getName(), false);
        nextStop.updateReachableAt(time, lineName);
        return new Triplet<>(time, nextStop.getName(), true);
    }

    @Override
    public void incrementCapacity(Time startTime) {
        numberOfPassengers.put(startTime, numberOfPassengers.get(startTime) + 1);
    }

    @Override
    public TimeDiff getTimeToNextStop() {
        return timeToNextStop;
    }

    @Override
    public Stop getNextStop() {
        return nextStop;
    }
}