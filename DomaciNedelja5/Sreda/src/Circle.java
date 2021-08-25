/**
 * Project Sreda, Package PACKAGE_NAME, Class Circle, Created by Milovan 25.8.2021.
 */
public class Circle extends Shape {
    private double r;

    public Circle(String name, double r) {
        super(name);
        this.r = r;
    }

    @Override
    public double circumference() {
        return 2*Math.PI*r;
    }

    @Override
    public double area() {
        return Math.pow(r, 2)*Math.PI;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

