package interfaces;

import datatypes.StopName;
import datatypes.Time;

public interface LineInterface {
    void updateReachable(Time time, StopName stop);
    StopName updateCapacityAndGetPreviousStop(StopName stop, Time time);
    boolean containStop(StopName stopName);
}
