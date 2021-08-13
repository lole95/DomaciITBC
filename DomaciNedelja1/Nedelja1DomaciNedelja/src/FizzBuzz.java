import java.util.Scanner;

/**
 * Project Nedelja1DomaciNedelja, Package PACKAGE_NAME, Class FizzBuzz, Created by Milovan 31.7.2021.
 */
public class FizzBuzz {
    //    Za uneti celobrojni nenegativan broj n, ispisati za sve brojeve od 1 do
//    i zakljucno sa n nisku "Fizz" ako je on deljiv sa 3,
//    nisku "Buzz" ako je on deljiv sa 5, a nisku "FizzBuzz" ako je on deljiv i sa 3 i sa 5.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter not negative integer number: ");
        int number = sc.nextInt();
        while (number < 0) {
            System.out.print("Enter not negative integer number: ");
            number = sc.nextInt();
        }
        for (int i = 1; i <= number; i++) {
            String message = i + ": ";
            if (i % 3 == 0) {
                message += "Fizz";
            }
            if (i % 5 == 0) {
                message += "Buzz";
            }
            System.out.println(message);
        }
        if(number == 0){
            System.out.println("You entered zero se there is no Fizz Buzz for you.");
        }
    }
}

