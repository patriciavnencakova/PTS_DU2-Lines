package interfaces;

import connection.Stop;
import datatypes.*;

public interface LineSegmentInterface {
    Pair<Time, StopName> nextStop(Time startTime);
    Tuple<Time, StopName, Boolean> nextStopAndUpdateReachable(Time startTime);
    void incrementCapacity(Time startTime);
    TimeDiff getTimeToNextStop();
    Stop getNextStop();
}
