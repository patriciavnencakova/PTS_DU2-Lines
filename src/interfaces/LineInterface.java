package interfaces;

import datatypes.*;

public interface LineInterface {
    void updateReachable(Time time, StopName stop);
    void updateCapacityAndGetPreviousStop(StopName stop, Time time);
}