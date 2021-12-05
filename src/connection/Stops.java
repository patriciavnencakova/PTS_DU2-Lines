package connection;

import datatypes.LineName;
import datatypes.Pair;
import datatypes.StopName;
import datatypes.Time;
import inMemory.Stop;
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
    public Optional<Pair<StopName, Time>> earliestReachableStopAfter(Time time) {
        Time min = new Time(Integer.MAX_VALUE);
        StopName stopName = null;

        for (Stop stop : stops.values()) {
            Time tmp = stop.getReachableAt().getI();
            if (tmp.getTime() > time.getTime() && tmp.getTime() < min.getTime()) {
                min = tmp;
                stopName = stop.getName();
            }
        }

        if (stopName == null) return Optional.empty();
        return Optional.of(new Pair<>(stopName, min));
    }

    @Override
    public boolean setStartingStop(StopName stopName, Time time) {
        if (!stops.containsKey(stopName)) return false;
        stops.get(stopName).updateReachableAt(time, null);
        return true;
    }

    @Override
    public ArrayList<LineName> getLines(StopName stopName) {
        // TODO: dorobit check ci je stopName v stops
        return stops.get(stopName).getLines();
    }

    @Override
    public Pair<Time, LineName> getReachableAt(StopName stop) {
        return stops.get(stop).getReachableAt();
    }
}
