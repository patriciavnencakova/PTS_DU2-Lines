package connection;

import datatypes.*;
import interfaces.LineInterface;

import java.util.ArrayList;

public class Line implements LineInterface {
    private LineName name;
    private ArrayList<Time> startingTimes;
    private StopName firstStop;
    private ArrayList<LineSegment> lineSegments;

    public Line(LineName name, ArrayList<Time> startingTimes, StopName firstStop, ArrayList<LineSegment> lineSegments) {
        this.name = name;
        this.startingTimes = new ArrayList<>(startingTimes);
        this.firstStop = firstStop;
        this.lineSegments = new ArrayList<>(lineSegments);
    }

    @Override
    public void updateReachable(Time time, StopName stop) {
        Time startingTime;
        for (int i = 0; i < startingTimes.size(); i++) {
            boolean exit = false;
            startingTime = startingTimes.get(i);
            Time currentTime = startingTime;
            for (int j = 0; j < lineSegments.size(); j++) {
                Pair<Time, StopName> nextStop = lineSegments.get(i).nextStop(currentTime);
                if (nextStop.getII() == stop && nextStop.getI().getTime() >= time.getTime()) {
                    exit = true;
                    break;
                }
                currentTime = nextStop.getI();
            }
            if (exit) break;
        }
    }

    @Override
    public void updateCapacityAndGetPreviousStop(StopName stop, Time time) {}
}
