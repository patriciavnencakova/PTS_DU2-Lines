package connection;

import java.util.ArrayList;

public class Line {
    private LineName name;
    private ArrayList<Time> startingTimes;
    private StopName firstStop;

    public Line(LineName name, ArrayList<Time> startingTimes, StopName firstStop) {
        this.name = name;
        this.startingTimes = new ArrayList<>(startingTimes);
        this.firstStop = firstStop;
    }

    public void updateReachable(Time time, StopName stop) {}

    public void updateCapacityAndGetPreviousStop(StopName stop, Time time) {}
}
