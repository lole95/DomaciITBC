import java.util.Scanner;

/**
 * Project Nedelja2DomaciNedelja, Package PACKAGE_NAME, Class SumaCifaraBrojaPonovo, Created by Milovan 6.8.2021.
 */
public class SumaCifaraBrojaPonovo {
    public static void main(String[] args) {
        System.out.println("Enter number: ");
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        System.out.println("Sum of digits is: " + sumOfDigits(number));
    }

    public static int sumOfDigits(String num) {
        int sum = 0;
//        num.toCharArray();
        for (int i = 0; i < num.length(); i++) {
            int digit = Character.getNumericValue(num.charAt(i));
            sum += digit;
        }
        return sum;
    }

}

