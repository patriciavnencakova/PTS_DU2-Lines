package interfaces;

import datatypes.*;

public interface LineInterface {
    void updateReachable(Time time, StopName stop);
    StopName updateCapacityAndGetPreviousStop(StopName stop, Time time);
}
