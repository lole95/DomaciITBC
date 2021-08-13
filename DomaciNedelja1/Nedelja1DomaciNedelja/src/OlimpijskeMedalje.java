import java.util.Scanner;

/**
 * Project Nedelja1DomaciNedelja, Package PACKAGE_NAME, Class OlimpijskeMedalje, Created by Milovan 31.7.2021.
 */
public class OlimpijskeMedalje {
    public static void main(String[] args) {
//        Na standardni ulaz se unose imena dva tima, a zatim i 6 celih pozitivnih brojeva koji oznacavaju broj
//        osvojenih zlatnih, srebrnih odnosno bronzanih medalja, tim redom. Prva 3 broja se odnose na prvi tim
//        a druga tri broja na drugi tim. Pobednicki tim je onaj koji ima vise osvojenih medalja, a u slucaju
//        da oba tima imaju isto onda se gleda ko ima vise osvojenih zlatnih medalja. Ako i tada nema pobednika
//        onda se gledaju srebrne medalje i na kraju bronzane. Na standarni izlazi ispisati ime pobednickog tima,
//        a ako oba tima imaju potpuno iste medalje, ispisati nisku "Nereseno".
        Scanner sc = new Scanner(System.in);

        System.out.println("Name of the first team: ");
        String teamOne = sc.nextLine();

        System.out.println("Name of the second team: ");
        String teamTwo = sc.nextLine();

        System.out.print("Gold medals of first team: ");
        int goldTeamOne = sc.nextInt();

        System.out.print("Silver medals of first team: ");
        int silverTeamOne = sc.nextInt();

        System.out.print("Bronze medals of first team: ");
        int bronzeTeamOne = sc.nextInt();

        System.out.print("Gold medals of second team: ");
        int goldTeamTwo = sc.nextInt();

        System.out.print("Silver medals of second team: ");
        int silverTeamTwo = sc.nextInt();

        System.out.print("Bronze medals of second team: ");
        int bronzeTeamTwo = sc.nextInt();

        int sumOfAllMedalsTeamOne = goldTeamOne + silverTeamOne + bronzeTeamOne;
        int sumOfAllMedalsTeamTwo = goldTeamTwo + silverTeamTwo + bronzeTeamTwo;

        String winnerTeamOne = "Winner is team: " + teamOne;
        String winnerTeamTwo = "Winner is team: " + teamTwo;

        if (sumOfAllMedalsTeamOne > sumOfAllMedalsTeamTwo) {
            System.out.println(winnerTeamOne);
        } else if (sumOfAllMedalsTeamTwo > sumOfAllMedalsTeamOne) {
            System.out.println(winnerTeamTwo);
        } else {
            if (goldTeamOne > goldTeamTwo) {
                System.out.println(winnerTeamOne);
            } else if (goldTeamTwo > goldTeamOne) {
                System.out.println(winnerTeamTwo);
            } else {
                if (silverTeamOne > silverTeamTwo) {
                    System.out.println(winnerTeamOne);
                } else if (silverTeamTwo > silverTeamOne) {
                    System.out.println(winnerTeamTwo);
                } else {
                    if (bronzeTeamOne > bronzeTeamTwo) {
                        System.out.println(winnerTeamOne);
                    } else if (bronzeTeamTwo > bronzeTeamOne) {
                        System.out.println(winnerTeamTwo);
                    } else {
                        System.out.println("It's draw between " + teamOne + " and " + teamTwo + ".");
                    }
                }
            }
        }
    }
}

