package connection;

import datatypes.LineName;
import datatypes.Pair;
import datatypes.StopName;
import datatypes.Time;
import interfaces.FactoryInterface;
import interfaces.StopInterface;
import interfaces.StopsInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Stops implements StopsInterface {
    HashMap<StopName, StopInterface> stops;
    FactoryInterface factory;

    public Stops(FactoryInterface factory) {
        this.factory = factory;
    }

    @Override
    public Optional<Pair<StopName, Time>> earliestReachableStopAfter(Time time) {
        Time min = new Time(Integer.MAX_VALUE);
        StopName stopName = null;

        for (StopInterface stop : stops.values()) {
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
    public void setStartingStop(StopName stopName, Time time) {
        if (!stops.containsKey(stopName)) addStop(stopName);
        stops.get(stopName).updateReachableAt(time, null);
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

    @Override
    public void clean() {
        stops = new HashMap<>();
    }

    public void addStop(StopName stop) {
        Optional<StopInterface> s = factory.createStop(stop);
        if (s.isEmpty()) {
            //TODO exception
        } else {
            stops.put(stop, s.get());
        }
    }
}
