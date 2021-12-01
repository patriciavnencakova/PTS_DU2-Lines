package connection;

import datatypes.*;
import interfaces.StopsInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Stops implements StopsInterface {
    HashMap<StopName, Stop> stops;

    public Stops(HashMap<StopName, Stop> stops) {
        this.stops = stops;
    }
     @Override
    public Optional<HashMap<StopName, Time>> earliestReachableStopAfter(Time time) {
        return Optional.empty();
    }

    @Override
    public boolean setStartingStop(StopName stopName, Time time) {
        if (!stops.containsKey(stopName)) return false;
        stops.get(stopName).updateReachableAt(time, Optional.empty());
        return true;
    }

    @Override
    public ArrayList<LineName> getLines(StopName stopName) {
        // TODO: dorobit check ci je stopName v stops
        return stops.get(stopName).getLines();
    }

    @Override
    public HashMap<Time, LineName> getReachableAt(StopName stop) {
        return null;
    }
}
