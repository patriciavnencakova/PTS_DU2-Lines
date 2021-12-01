package interfaces;

import datatypes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public interface StopsInterface {
    Optional<HashMap<StopName, Time>> earliestReachableStopAfter(Time time);
    boolean setStartingStop(StopName stopName, Time time);
    ArrayList<LineName> getLines(StopName stopName);
    HashMap<Time, LineName> getReachableAt(StopName stop);
}
