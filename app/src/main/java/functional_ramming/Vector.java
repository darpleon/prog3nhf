package functional_ramming;

public class Vector {
    private double x;
    private double y;

    public Vector(double a, double b) {
        x = a;
        y = b;
    }

    public Vector() {
        this.x = 0;
        this.y = 0;
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

    public double magnitude() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector add(Vector v) {
        return new Vector(x + v.x, y + v.y);
    }

    public Vector subtract(Vector v) {
        return new Vector(this.x - v.x, this.y - v.y);
    }

    public Vector scale(double m) {
        return new Vector(x * m, y * m);
    }

    public Vector normalize() {
        return this.scale(1 / this.magnitude());
    }

    public Vector swap() {
        return new Vector(y, x);
    }

    public Vector flip() {
        return new Vector(x, -y);
    }

    public double dotProduct(Vector v) {
        return x * v.x + y * v.y;
    }

}
