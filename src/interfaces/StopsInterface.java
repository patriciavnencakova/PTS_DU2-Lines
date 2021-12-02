package interfaces;

import datatypes.*;

import java.util.ArrayList;
import java.util.Optional;

public interface StopsInterface {
    Optional<Pair<StopName, Time>> earliestReachableStopAfter(Time time);
    boolean setStartingStop(StopName stopName, Time time);
    ArrayList<LineName> getLines(StopName stopName);
    Pair<Time, LineName> getReachableAt(StopName stop);
}
