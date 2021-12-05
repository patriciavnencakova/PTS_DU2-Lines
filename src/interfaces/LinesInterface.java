package interfaces;

import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;

import java.util.ArrayList;

public interface LinesInterface {
    void updateReachable(ArrayList<LineName> lineNames, StopName stop, Time time);

    StopName updateCapacityAndGetPreviousStop(LineName line, StopName stop, Time time);

    void clean();
}
