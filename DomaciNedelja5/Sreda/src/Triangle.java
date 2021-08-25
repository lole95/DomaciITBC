/**
 * Project Sreda, Package PACKAGE_NAME, Class Triangle, Created by Milovan 25.8.2021.
 */
public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(String name, double a, double b, double c) {
        super(name);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double circumference() {
        return a + b + c;
    }

    @Override
    public double area() {
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

