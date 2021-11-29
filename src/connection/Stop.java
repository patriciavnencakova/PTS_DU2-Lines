package connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Stop {
    private StopName name;
    private Optional<Time> reachableAt;
    private Optional<LineName> reachableVia;
    private ArrayList<LineName> lines;

    public Stop(StopName name) {
        this.name = name;
//        this.reachableAt = reachableAt;
//        this.reachableVia = reachableVia;
//        this.lines = new ArrayList<>(lines);
    }

    public void updateReachableAt(Time time, Optional<LineName> line) {
        //zmenit internal state ??
    }

    public HashMap<Time,LineName> getReachableAt(){
        return null;
    }

    public ArrayList<LineName> getLines() {
        return null;
    }

}
