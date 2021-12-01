package connection;

import datatypes.*;
import interfaces.LinesInterface;
import java.util.*;

public class Lines implements LinesInterface {
    HashMap<LineName, Line> lines;

    public Lines(HashMap<LineName, Line> lines) {
        this.lines = lines;
    }

    @Override
    public void updateReachable(ArrayList<LineName> lineNames, StopName stop, Time time) {
        for (LineName lineName : lineNames) {
           lines.get(lineName).updateReachable(time, stop);
        }
    }

    @Override
    public StopName updateCapacityAndGetPreviousStop(LineName line, StopName stop, Time time) {
        return null;
    }

    @Override
    public void clean() {}
}