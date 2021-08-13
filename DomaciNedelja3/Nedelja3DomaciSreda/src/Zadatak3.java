import java.util.Scanner;

/**
 * Project Nedelja3DomaciSreda, Package PACKAGE_NAME, Class Zadatak3, Created by Milovan 11.8.2021.
 */
public class Zadatak3 {
    public static boolean isPassworValid(String s){
        // Prima String
        // Vraca boolean
        if (s.length() <= 8){
            //Proveramo da li je nas password mani ili jednak od 8. Ako jeste odmah vracamo false, jer
            // znamo da nije validan ako ima manje ili jednako od 8 karaktera
            // Ako ima vise od 8 karaktera nastavljamo sa funkcijom.
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            // Prolazimo kroz ovu for petlju onoliko puta koliko je dugacan nas password
            if (Character.isUpperCase(s.charAt(i))){
                // Character.isUpperCase(s.charAt(i)) Ovaj deo koda citaj sa desno na levo

                // s.charAt(i) Ovaj deo koda nam vraca(daje) karakter
                // iz Stringa s(to je nas password koji smo prosledili fuknkcija) na poziciji: i
                // Kad je i=0 to je prvi karakter naseg Stringa, kad je i=2 to je drugi, ...

                // Character.isUpperCase(ovde je neki karakter koji smo dobili od: s.charAt(i))
                // Ovaj deo koda nam vraca(daje) boolean tj. true ili false
                // On pita da li je karakter veliko slovo, i vraca odgovarajuci boolean.
                // Ako nadjemo da je barem jedan karakter veliko slovo odmah citava funkcija vraca true
                // i zavrsava se. Ako nijedan karakter nije veliki nastavlja se funkcija
                return true;
            }
        }
        // Nijedan karakter nije veliki tako da vracamo false.
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (isPassworValid(sc.nextLine())){
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
}

