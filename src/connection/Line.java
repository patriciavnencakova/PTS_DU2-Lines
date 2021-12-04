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
        Time lastPossible = startingTimes.get(startingTimes.size() - 1);
        StopName currentStop = firstStop;
        Time currentTime = lastPossible;
        int indexOfStop = 0;
        while (currentStop != stop) {
            Pair<Time, StopName> nextStop = lineSegments.get(indexOfStop).nextStop(currentTime);
            currentStop = nextStop.getII();
            currentTime = nextStop.getI();
            indexOfStop++;
        }

        if (currentTime.getTime() < time.getTime()) {
            //TODO neexistuje spojenie pre tento cas
        }

        this.updateAllPossible(indexOfStop, currentTime);

        int indexOfStartingTime = startingTimes.size() - 1;
        TimeDiff length = new TimeDiff(currentTime.getTime() - lastPossible.getTime());
        while (this.catchEarlier(time, length, indexOfStartingTime)) {
            Time tmp = new Time(startingTimes.get(indexOfStartingTime - 1).getTime() + length.getTimeDiff());
            this.updateAllPossible(indexOfStop, tmp);
            indexOfStartingTime--;
        }
    }

    @Override
    public StopName updateCapacityAndGetPreviousStop(StopName stop, Time time) {
        return null;
    }

    public void updateAllPossible(int indexOfStop, Time currentTime) {
        while (indexOfStop < lineSegments.size()) {
            Triplet<Time, StopName, Boolean> nextStop = lineSegments.get(indexOfStop).nextStopAndUpdateReachable(currentTime);
            currentTime = nextStop.getI();
            if (!nextStop.getIII()) break;
            indexOfStop++;
        }
    }

    public Boolean catchEarlier(Time time, TimeDiff length, int index) {
        if (index == 0) return false;
        return (startingTimes.get(index - 1).getTime() + length.getTimeDiff()) >= time.getTime();
    }
}
