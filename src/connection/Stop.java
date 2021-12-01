package connection;

import datatypes.LineName;
import datatypes.Pair;
import datatypes.StopName;
import datatypes.Time;
import interfaces.StopInterface;

import java.util.ArrayList;
import java.util.Optional;

public class Stop implements StopInterface {
    private StopName name;
    private Time reachableAt;
    private Optional<LineName> reachableVia;
    private ArrayList<LineName> lines;

    public Stop(StopName name) {
        this.name = name;
        this.reachableAt = new Time(Integer.MAX_VALUE);
    }

    @Override
    public void updateReachableAt(Time time, Optional<LineName> line) {
        if (time.getTime() < reachableAt.getTime()) {
            reachableAt = time;
            reachableVia = line;
        }
    }

    @Override
    public Pair<Time, LineName> getReachableAt() {
        return null;
    }

    @Override
    public ArrayList<LineName> getLines() {
        return null;
    }

    @Override
    public StopName getName() {
        return name;
    }
}
