import java.util.Scanner;

/**
 * Project Nedelja2DomaciSreda, Package PACKAGE_NAME, Class Faktorijel, Created by Milovan 3.8.2021.
 */
public class Faktorijel {
    public static void main(String[] args) {
        faktorijal(numberBiggerThanZero());
    }

    public static int numberBiggerThanZero() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number bigger than zero: ");
        int number = sc.nextInt();
        while (number <= 0) {
            System.out.print("Enter number bigger than zero: ");
            number = sc.nextInt();
        }
        return number;
    }
    public static void faktorijal(int x){
        int fact = 1;
        for (int i = x; i > 0; i--) {
            fact *= i;
        }
        System.out.println("Factorial of number " + x + " is: " + fact);
    }


}

