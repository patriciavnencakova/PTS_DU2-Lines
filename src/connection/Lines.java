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
            if (!lines.containsKey(lineName)) continue;
           lines.get(lineName).updateReachable(time, stop);
        }
    }

    @Override
    public StopName updateCapacityAndGetPreviousStop(LineName line, StopName stop, Time time) {
        if (!lines.containsKey(line)) {
            //TODO error
        }
        return lines.get(line).updateCapacityAndGetPreviousStop(stop, time);
    }

    @Override
    public void clean() {
        lines = new HashMap<>();
    }
}