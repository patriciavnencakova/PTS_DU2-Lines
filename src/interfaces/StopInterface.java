package interfaces;

import datatypes.*;

import java.util.ArrayList;
import java.util.Optional;

public interface StopInterface {
    void updateReachableAt(Time time, Optional<LineName> line);
    Pair<Time,LineName> getReachableAt();
    ArrayList<LineName> getLines();
    StopName getName();
}
