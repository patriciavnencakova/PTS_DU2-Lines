package factories;

import datatypes.LineName;
import datatypes.StopName;
import interfaces.FactoryInterface;
import interfaces.LineInterface;
import interfaces.StopInterface;

import java.util.Optional;

public class DatabaseFactory implements FactoryInterface {
    @Override
    public Optional<StopInterface> createStop(StopName stopName) {
        return Optional.empty();
    }

    @Override
    public Optional<LineInterface> createLine(LineName lineName) {
        return Optional.empty();
    }
}
