/**
 * Project Sreda, Package PACKAGE_NAME, Class Square, Created by Milovan 25.8.2021.
 */
public class Square extends Shape {
    private double a;

    /*Constructor*/

    public Square(String name, double a) {
        super(name);
        this.a = a;
    }
    /*Methods*/

    @Override
    public double circumference() {
        return 4*a;
    }

    @Override
    public double area() {
        return Math.pow(a, 2);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

