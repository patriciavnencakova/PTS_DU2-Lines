package interfaces;

import datatypes.LineName;
import datatypes.Pair;
import datatypes.StopName;
import datatypes.Time;

import java.util.ArrayList;

public interface StopInterface {
    void updateReachableAt(Time time, LineName line);

    Pair<Time, LineName> getReachableAt();

    ArrayList<LineName> getLines();

    StopName getName();
}
