import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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

    public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> repartition = new HashMap<>();
        repartition.put("Star", 0);
        repartition.put("Planet", 0);
        repartition.put("Other", 0);

        for (CelestialObject obj : celestialObjects) {
            if (obj instanceof Star) {
                repartition.put("Star", repartition.get("Star") + obj.getMass());
            } else if (obj instanceof Planet) {
                repartition.put("Planet", repartition.get("Planet") + obj.getMass());
            } else {
                repartition.put("Other", repartition.get("Other") + obj.getMass());
            }
        }
        return repartition;
    }
}