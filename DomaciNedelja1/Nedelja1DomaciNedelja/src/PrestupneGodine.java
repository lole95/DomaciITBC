import java.util.Scanner;

/**
 * Project Nedelja1DomaciNedelja, Package PACKAGE_NAME, Class PrestupneGodine, Created by Milovan 31.7.2021.
 */
public class PrestupneGodine {
    public static void main(String[] args) {
//        Godina je prestupna ako je deljiva sa 4 i vazi
//        da nije deljiva sa 100 ili je deljiva sa 400.
//        Korisnik unosi dve godine strogo vece od 0. Ispisati broj godina koje su prestupne
//        u zadatom intervalu ukljucujuci i te dve.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter fist year that's bigger than zero: ");
        int firstYear = sc.nextInt();
        System.out.print("Enter second year that's bigger than zero: ");
        int secondYear = sc.nextInt();

        while (firstYear <= 0 || secondYear <= 0) {
            if (firstYear <= 0) {
                System.out.print("Enter fist year that's bigger than zero: ");
                firstYear = sc.nextInt();
            }
            if (secondYear <= 0) {
                System.out.print("Enter second year that's bigger than zero: ");
                secondYear = sc.nextInt();
            }
        }

        int numberOfLeapYears = 0;
        for (int i = firstYear; i <= secondYear; i++) {
            if ((i % 4 == 0) && (i % 100 != 0 || i % 400 == 0)) {
                numberOfLeapYears++;
            }
        }
        System.out.println("number of leap years: " + numberOfLeapYears);

    }
}

