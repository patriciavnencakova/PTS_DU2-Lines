package connection;

import datatypes.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class ConnectionSearch {
    private final Lines lines;
    private final Stops stops;

    public ConnectionSearch(Lines lines, Stops stops) {
        this.lines = lines;
        this.stops = stops;
    }

    public ConnectionData search(StopName from, StopName to, Time time) {
        stops.setStartingStop(from, time);
        ArrayList<LineName> linesFrom = stops.getLines(from);
        lines.updateReachable(linesFrom, from, time);

        Optional<Pair<StopName, Time>> earliestReachableStopAfter = stops.earliestReachableStopAfter(time);
        if (earliestReachableStopAfter.isEmpty()) {
            //TODO neexistuje taka cesta
            return null;
        }

        while (earliestReachableStopAfter.isPresent() && earliestReachableStopAfter.get().getI() != to) {
            StopName earliestFromAfter = earliestReachableStopAfter.get().getI();
            Time earliestTimeAfter = earliestReachableStopAfter.get().getII();
            linesFrom = stops.getLines(earliestFromAfter);
            lines.updateReachable(linesFrom, earliestFromAfter, earliestTimeAfter);
            earliestReachableStopAfter = stops.earliestReachableStopAfter(earliestTimeAfter);
        }

        ArrayList<StopName> crossedStops = new ArrayList<>() {{
            add(to);
        }};

        StopName currentStopName = to;
        Time currentTime;
        LineName currentLineName;

        while (currentStopName != from) {
            Pair<Time, LineName> tmp = stops.getReachableAt(currentStopName);
            currentTime = tmp.getI();
            currentLineName = tmp.getII();
            if (currentTime == null || currentLineName == null) break;
            currentStopName = lines.updateCapacityAndGetPreviousStop(currentLineName, currentStopName, currentTime);
            crossedStops.add(currentStopName);
        }

        if (earliestReachableStopAfter.isEmpty()) {
            //TODO nieco
            return null;
        }

        lines.clean();
        stops.clean();

        Collections.reverse(crossedStops);
        return new ConnectionData(from, to, time, earliestReachableStopAfter.get().getII(), crossedStops);
    }
}
