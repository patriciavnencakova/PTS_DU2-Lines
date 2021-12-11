package factories;

import datatypes.*;
import connection.Line;
import connection.LineSegment;
import connection.Stop;
import interfaces.FactoryInterface;
import interfaces.LineInterface;
import interfaces.StopInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class InMemoryFactory implements FactoryInterface {
    private final HashMap<StopName, ArrayList<LineName>> stops;
    private final HashMap<LineName, Pair<ArrayList<Time>, StopName/*ArrayList<LineSegment>*/ >> lines;
    private final HashMap<LineName, Quadruple<Stop, TimeDiff, HashMap<Time, Integer>, Integer>> lineSegments;

    public InMemoryFactory(
            HashMap<StopName, ArrayList<LineName>> stops, HashMap<LineName,
            Pair<ArrayList<Time>, StopName>> lines,
            HashMap<LineName, Quadruple<Stop, TimeDiff, HashMap<Time, Integer>, Integer>> lineSegments) {
        this.stops = new HashMap<>(stops);
        this.lines = new HashMap<>(lines);
        this.lineSegments = new HashMap<>(lineSegments);
    }

    @Override
    public Optional<StopInterface> createStop(StopName stopName) {
        if (!stops.containsKey(stopName)) return Optional.empty();
        return Optional.of(new Stop(stopName, stops.get(stopName)));
    }

    @Override
    public Optional<LineInterface> createLine(LineName lineName) {
        if (!lines.containsKey(lineName)) return Optional.empty();
        return Optional.of(new Line(lineName, lines.get(lineName).getI(), lines.get(lineName).getII(), getLineSegments(lineName)));
    }

    public ArrayList<LineSegment> getLineSegments(LineName lineName) {
        ArrayList<LineSegment> result = new ArrayList<>();
        for (LineName l : lineSegments.keySet()) {
            if (l == lineName) {
                result.add(new LineSegment(lineSegments.get(l).getI(), lineSegments.get(l).getII(),
                        lineSegments.get(l).getIII(), lineSegments.get(l).getIV(), l));
            }
        }
        return result;
    }

}
