package functional_ramming;

public class Vector {
    private double x;
    private double y;

    public Vector(double a, double b) {
        x = a;
        y = b;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double a) {
        x = a;
    }

    public void setY(double b) {
        y = b;
    }

    public Vector add(Vector v) {
        return new Vector(x + v.x, y + v.y);
    }

    public Vector scale(double m) {
        return new Vector(x * m, y * m);
    }

}
