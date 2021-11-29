package connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Stops {
    public Optional<HashMap<StopName, Time>> earliestReachableStopAfter(Time time) {
        return Optional.empty();
    }

    public boolean setStartingStop(StopName name, Time time) {
        Stop stop = new Stop(name);
        stop.updateReachableAt(time, Optional.empty());

        //return asi este upravit podla niecoho nvm coho
        return true;
    }

    public ArrayList<LineName> getLines(StopName name) {
        Stop stop = new Stop(name);
        return stop.getLines();
    }

    public HashMap<Time, LineName> getReachableAt(StopName stop) {
        return null;
    }
}
