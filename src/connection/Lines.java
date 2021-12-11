package connection;

import datatypes.LineName;
import datatypes.StopName;
import datatypes.Time;
import interfaces.FactoryInterface;
import interfaces.LineInterface;
import interfaces.LinesInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Lines implements LinesInterface {
    HashMap<LineName, LineInterface> lines;
    FactoryInterface factory;

    public Lines(FactoryInterface factory) {
        this.factory = factory;
    }

    @Override
    public void updateReachable(ArrayList<LineName> lineNames, StopName stop, Time time) {
        for (LineName lineName : lineNames) {
            if (!lines.containsKey(lineName)) addLine(lineName);
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

    public void addLine(LineName line) {
        Optional<LineInterface> s = factory.createLine(line);
        if (s.isEmpty()) {
            //TODO exception
        } else {
            lines.put(line, s.get());
        }
    }
}