package connection;

import datatypes.LineName;
import datatypes.Pair;
import datatypes.StopName;
import datatypes.Time;
import interfaces.StopInterface;

import java.util.ArrayList;

public class Stop implements StopInterface {
    private final StopName name;
    private Time reachableAt = new Time(Integer.MAX_VALUE);
    //TODO optional
    private LineName reachableVia = null;
    private final ArrayList<LineName> lines;

    public Stop(StopName name, ArrayList<LineName> lines) {
        this.name = name;
        this.lines = lines;
    }

    @Override
    public void updateReachableAt(Time time, LineName line) {
        if (time.getTime() < reachableAt.getTime()) {
            reachableAt = time;
            reachableVia = line;
        }
    }

    @Override
    public Pair<Time, LineName> getReachableAt() {
        return new Pair<>(reachableAt, reachableVia);
    }

    @Override
    public ArrayList<LineName> getLines() {
        return lines;
    }

    @Override
    public StopName getName() {
        return name;
    }
}
