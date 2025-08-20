import java.util.Objects;

public class Planet extends CelestialObject {
    private Star centerStar;

    public Planet() {
        super();
        this.centerStar = new Star();
    }

    public Planet(String name, double x, double y, double z, Star centerStar) {
        super(name, x, y, z);
        this.centerStar = centerStar;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    @Override
    public String toString() {
        return String.format("%s circles around %s at the %.3f AU", getName(),
                centerStar.getName(),
                CelestialObject.getDistanceBetween(this, centerStar));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Planet other = (Planet) obj;
        return Double.compare(getX(), other.getX()) == 0 &&
                Double.compare(getY(), other.getY()) == 0 &&
                Double.compare(getZ(), other.getZ()) == 0 &&
                (getName() != null ? getName().equals(other.getName()) : other.getName() == null) &&
                (centerStar != null ? centerStar.equals(other.centerStar) : other.centerStar == null);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), centerStar);
    }
}