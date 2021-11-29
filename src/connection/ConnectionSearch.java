package connection;

import java.util.ArrayList;

public class ConnectionSearch {
    private Lines lines;
    private Stops stops;

    public ConnectionSearch() {
        this.lines = new Lines();
        this.stops = new Stops();
    }

    public ConnectionData search(StopName from, StopName to, Time time) {
        stops.setStartingStop(from, time);
        ArrayList<LineName> Lines = stops.getLines(from);
        lines.updateReachable(Lines, from, time);
        return null;
    }
}
