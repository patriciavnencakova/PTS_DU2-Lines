package interfaces;

import datatypes.*;
import connection.Stop;

public interface LineSegmentInterface {
    Pair<Time, StopName> nextStop(Time startTime);

    Triplet<Time, StopName, Boolean> nextStopAndUpdateReachable(Time startTime);

    void incrementCapacity(Time startTime);

    TimeDiff getTimeToNextStop();

    Stop getNextStop();
}
