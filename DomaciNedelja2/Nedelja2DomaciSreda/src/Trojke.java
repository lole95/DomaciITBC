import java.util.Scanner;

/**
 * Project Nedelja2DomaciSreda, Package PACKAGE_NAME, Class Trojke, Created by Milovan 3.8.2021.
 */
public class Trojke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter tree real numbers: ");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double z = sc.nextDouble();
        minOfTreeNumbers(x, y, z);
    }

    public static void minOfTreeNumbers(double x, double y, double z) {
        System.out.println("Min number is: " + Math.min(Math.min(x, y), z));
    }
}

