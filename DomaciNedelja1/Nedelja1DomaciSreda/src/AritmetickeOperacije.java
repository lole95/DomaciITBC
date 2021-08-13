import java.util.Scanner;

/**
 * Project Domaci_1.Nedela_Sreda, Package PACKAGE_NAME, Class AritmetickeOperacije, Created by Milovan 26.7.2021.
 */
public class AritmetickeOperacije {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 integers: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        int sum = x + y;
        int reductuon = x - y;
        int mult = x * y;
        int div = x / y;
        int mod = x % y;

        System.out.println(sum);
        System.out.println(reductuon);
        System.out.println(mult);
        System.out.println(div);
        System.out.println(mod);
    }
}

