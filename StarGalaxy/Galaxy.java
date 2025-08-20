import java.util.List;
import java.util.ArrayList;

public class Galaxy {
    private List<CelestialObject> celestialObjects;

    public Galaxy() {
        celestialObjects = new ArrayList<>();
    }

    public void addCelestialObject(CelestialObject celestialObject) {
        celestialObjects.add(celestialObject);
    }

    public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }
}