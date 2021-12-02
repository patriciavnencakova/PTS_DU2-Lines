package datatypes;

import java.util.ArrayList;

public class ConnectionData {
    StopName from;
    StopName to;
    Time arrivalTime;
    Time departureTime;
    ArrayList<StopName> crossedStops;

    public ConnectionData(StopName from, StopName to, Time arrivalTime, Time departureTime, ArrayList<StopName> crossedStops) {
        this.from = from;
        this.to = to;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.crossedStops = crossedStops;
    }
}
