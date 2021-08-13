import java.util.Scanner;

/**
 * Project Domaci_1.Nedela_Sreda, Package PACKAGE_NAME, Class Signatura, Created by Milovan 26.7.2021.
 */
public class Signatura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 integers: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        if ((x < 0 && y < 0) || (x > 0 && y > 0) ){
            System.out.println("Numbers " + x + " and " + y + " are of the same signature.");
        }
        else {
            System.out.println("Numbers " + x + " and " + y + " are of the different signature.");
        }
    }
}

