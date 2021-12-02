package interfaces;

import datatypes.*;

import java.util.ArrayList;

public interface StopInterface {
    void updateReachableAt(Time time, LineName line);
    Pair<Time,LineName> getReachableAt();
    ArrayList<LineName> getLines();
    StopName getName();
}
