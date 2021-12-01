package connection;

import datatypes.*;

import java.util.ArrayList;

public class ConnectionSearch {
    private Lines lines;
    private Stops stops;

    public ConnectionSearch(Lines lines, Stops stops) {
        this.lines = lines;
        this.stops = stops;
    }

    public ConnectionData search(StopName from, StopName to, Time time) {
        stops.setStartingStop(from, time);
        ArrayList<LineName> linesFrom = stops.getLines(from);
        lines.updateReachable(linesFrom, from, time);
        return null;
    }
}
