import java.util.Arrays;

/**
 * Project Nedelja3DomaciSreda, Package PACKAGE_NAME, Class Zadatak2, Created by Milovan 11.8.2021.
 */
public class Zadatak2 {
    public static void main(String[] args) {
        String poruka = "Jedi #$%^ !@#$!!!@# mali!";
        System.out.println(decoder(poruka));
    }
    public static String decoder(String s) {
        // funkcija vraca String.
        // funkcija prima String.
        // Ovaj zadatak nisam bas najbolje odradio. Na casu ce mo videti kako stvarno treba da se radi.
        // Razlog zasto nije najbolje odradjen je zato sto uopste ne koristim ove nizove. osim sto mi
        // daju informaciju koji kljuc oznava koju rec
        // npr: "#$%^" je ustvari ==> "pite"
        String[] kljuc = {"#$%^", "!@#$!!!@#"};
        String[] decode = {"pite", "moroncinu"};
        s = s.replaceAll("#\\$%\\^", "pite");
        s= s.replaceAll("!@#\\$!!!@#", "moroncinu");
        // Isto kao i prosli zadatak, samo sto sada menjamo kljuc sa
        // pravom reci. Kao sto vidis i znak "^" je specijalan i mora
        // da se koriste dve kose crte "\\^" da bi ga java procitala.
        return s; // Vracamo String
    }
}

