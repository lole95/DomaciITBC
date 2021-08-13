import java.util.Scanner;

/**
 * Project Nedelja1DomaciNedelja, Package PACKAGE_NAME, Class ProsecnaVrednost, Created by Milovan 31.7.2021.
 */
public class ProsecnaVrednost {
    public static void main(String[] args) {
//        Korisnik unosi cene proizvoda koje je kupio sve dok se ne unese 0.
//        Na standardni izlaz ispisati prosecnu cenu proizvoda. Ukoliko korisnik unese
//        negativnu vrednost za cenu proizvoda, onda taj unos treba zanemariti
//        i nastaviti sa unosom.

        Scanner sc = new Scanner(System.in);
        double price = -1;
        double numberOfItems = 0;
        double sumOfPrices = 0;

        while (price != 0) {
            if (price > 0) {
                numberOfItems++;
                sumOfPrices += price;
            }
            System.out.print("Enter price of item: ");
            price = sc.nextDouble();
        }
        double averagePrice = sumOfPrices / numberOfItems;
        System.out.println("Average price is: " + averagePrice + ".");
    }
}

