package factories;

import datatypes.LineName;
import datatypes.StopName;
import inMemory.Stop;
import interfaces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class InMemoryFactory implements FactoryInterface {
    private HashMap<StopName, ArrayList<LineName>> inMemoryStops;

    public InMemoryFactory(HashMap<StopName, ArrayList<LineName>> inMemoryStops) {
        this.inMemoryStops = inMemoryStops;
    }

    @Override
    public Optional<StopInterface> createStop(StopName stopName) {
        if (!inMemoryStops.containsKey(stopName)) return Optional.empty();
        return Optional.of(new Stop(stopName, inMemoryStops.get(stopName)));
    }

    @Override
    public Optional<LineInterface> createLine(LineName lineName) {
        return null;
    }

}
