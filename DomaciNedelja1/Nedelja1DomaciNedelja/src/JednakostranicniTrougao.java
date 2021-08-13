import java.util.Scanner;

/**
 * Project Nedelja1DomaciNedelja, Package PACKAGE_NAME, Class JednakostranicniTrougao, Created by Milovan 31.7.2021.
 */
public class JednakostranicniTrougao {
    //    Potrebno je nacrtati u konzoli pomocu znaka * jednakostranicni
    //    trougao proizvoljne duzine stranice, kao u test primerima.
    public static void main(String[] args) {
        //
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String star = "* "; // U zadatku se vidi da posle svake zvezde ide razmak. Zato pravimo string sa zvezdom i razmakom posle nje

        String space = " "; // Svaki red osim poslednjeg pocinje sa nekim brojem razmaka. Tome sljuzi ovaj string

        String triangle = ""; // Ovaj string sam lose imenovao, trebalo je da se zove triangleRow. Njemo dodajemo prva dva stringa dole u for petlji.

        for (int i = 0; i < number; i++) { // Ovo nam oznacava na kom smo redu trougla. 0 - prvired, 1 - drugi ... number je broj koji korisnik upise, i toliko ce mo redova imati
            for (int j = 0; j < number - i - 1; j++) {
                triangle += space;
                //Ovde dodajemo razmake nasem Stringu triange. Svaki  put kad udjemo u ovu for petlju mi dodajemo jedan razmak.
                // Jer svaki red trougla ce imati sve manje i manje razmaka, , moramo da smanjimo broj puta ulazimo u petlju.
                // Tome sluzi ovo (number - i) Zamisli da ne postoji ovo - 1.
                // Primer: Korisnik je uneo broj 6. Prvo ide ona gore for petlja. uspesno prodje jer i koje je 0, manje je od 6.
                // onda udje u ovu nasu petlju koja ide ovako. j = 0; j < number(6) - i(0); j++. Kod ce proci 6 puta kroz ovu petlju i dodati 6 razmaka u nas String.
                // Posle toga, on izvrsava kod ispod, pa opet ulazi u gornju petlju i menja vrednosti i u 1.
                //onda udje u ovu petlju: j= 0; j< number(6) - i(1); j++. kod ce sad proci 5 puta, sto znaci 5 razmaka u nasem Stringu.
            }
            for (int j = 0; j < i + 1; j++) {
                triangle += star;
                //Slicno kao gore, svaki red ima drugaciji broj zvezda. prvi jednu, drugi dve ...
                // tako da tokom prvog reda ide: j = 0; j < i(0) + 1; j++.
            }
            System.out.println(triangle); // Ispisemo nas String recimo "      * " - to je prvi red.
            triangle = ""; // vracamo nas string na pocetno stanje, tj. da ne sadrzi nista. jer zelimo za svaki red da ga popunjavamo sve ispocetka
        }


    }
}

