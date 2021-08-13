import java.util.Scanner;

/**
 * Project Nedelja1DomaciNedelja, Package PACKAGE_NAME, Class SkriveniBroj, Created by Milovan 31.7.2021.
 */
public class SkriveniBroj {
    public static void main(String[] args) {
//        Skriveni broj broja n je broj dobijen ponavljanjem postupka sabiranja
//        svih njegovih cifara dokle god nije jednocifren. Napisati program koji
//        za uneti celobrojni pozitivan broj racuna njegov skriven broj. Npr.
//        skriveni broj broja 4567 je 4 jer je 4567 --> 4+5+6+7 = 22 --> 2+2 = 4;
//        broja 9999 je 9 jer je 9999 --> 9+9+9+9 = 36 --> 3+6 = 9.

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter positive integer: ");
        int number = sc.nextInt();
        while (number <= 0) {
            System.out.print("Enter positive integer: ");
            number = sc.nextInt();
        }

        int hiddenNumber = number; // In case input is 1 digit number
        while (hiddenNumber / 10 != 0) {
            hiddenNumber = 0;
            while (number != 0) {
                hiddenNumber += number % 10;
                number /= 10;
            }
            number = hiddenNumber; // in case hidden number is not 1 digit number yet
        }
        System.out.println("Hidden number: " + hiddenNumber);
    }
}

