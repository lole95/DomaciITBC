/**
 * Project Nedelja3DomaciSreda, Package PACKAGE_NAME, Class Zadatak1, Created by Milovan 11.8.2021.
 */
public class Zadatak1 {
    public static void correctMessage(String s){
        // funkcija ne vraca nista zato je void.
        // Prima String koji treba da izmenimo da bi bio lep
        s = s.replaceAll("#", ""); // umesto svake tarabe("#") stavljamo nista("")
        s = s.replaceAll("@", ""); // umesto svakog monkey znaka("@") stavljamo nista("")
        s = s.replaceAll("\\$", ""); // umesto svakog dolar znaka("$") stavljamo nista("")
        // $ znak je specifican, tako da mora da se koristi "\\$" da bi ga java procitala kao "$".

        System.out.println(s); // Ispisujemo sad lep String s
    }
    public static void main(String[] args) {
        String oldMessage = "Vo$$$$$zsasd$ite $#@pazlj@i######vo!#";
        correctMessage(oldMessage);
    }
}

