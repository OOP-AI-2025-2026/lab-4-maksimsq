import ua.opnu.java.inheritance.point.Point;

public final class Point3D extends Point {
    private int z;

    public Point3D() {
        super();
        this.z = 0;
    }

    public Point3D(final int x, final int y, final int z) {
        super(x, y);
        this.z = z;
    }

    public void setLocation(final int x, final int y,final int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    @Override
    public void setLocation(final int x, final int y) {
        super.setLocation(x, y);
        this.z = 0;
    }

    public int getZ() {
        return z;
    }

    public double distance(Point3D p) {
        int dx = getX() - p.getX();
        int dy = getY() - p.getY();
        int dz = z - p.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double distanceFromOrigin() {
        return Math.sqrt(getX() * getX() + getY() * getY() + z * z);
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }
}
