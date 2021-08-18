import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Project Sreda, Package PACKAGE_NAME, Class Karatisti, Created by Milovan 18.8.2021.
 */
public class Karatisti {
//    String ime; Ime karatiste
//    int godine; Kolko karatista ima godina
//    String rang; Koji je njegov rang. Rangovi u karateu ide od 10Kyu, 9Kyu, ..., 1kyu, 1Dan, 2Dan, ..., 10Dan
//    String[] kata; Lista karate formi
//
//    Napraviti gettere i setter za sve ove atribute, ali paziti na validnost polja!
//    Napraviti metod napadni(int index), koja za prosledjeni indeks ispisuje poruku:
//    "Karatista {ime} napada sa {kata[index]} katom".
//    Napraviti metod vatreniNapad(), koja ispisuje istu poruku kao i napadni() metod, osim sto bira nasumicnu katu.
//    Napraviti metod log() koji ispisuje narednu prouku: "Karatistia: {ime],
//    {godine}, {rang} - zna naredne kate {kata}"

    private String ime;
    private int godine;
    private String rang;
    private String[] kata;

    public Karatisti(String ime, int godine, String rang, String[] kata) {
        this.ime = ime;
        this.rang = rang;
        checkRang(rang);
        if (godine <= 0) {
            System.out.println(ime + ": Nije validan unos godine za ovog karatistu. Godine postavljene na 1");
            this.godine = 1;
        } else this.godine = godine;
        this.kata = kata;

    }

    public void log(){
        System.out.println("Karatistia: " + ime + ", "+ godine +", "+ rang +
                " - zna naredne kate " + Arrays.toString(kata));
    }

    private void checkRang(String rang) {
        int numberSubstring = 0;
        if (Character.isDigit(rang.charAt(1))) {
            numberSubstring = 1;
        }
        if (!Character.isDigit(rang.charAt(0)) || (Integer.parseInt(rang.substring(0, numberSubstring + 1)) > 10
                || Integer.parseInt(rang.substring(0, numberSubstring + 1)) < 1)) {
            System.out.println("Rang nije validan za karatistu: " + ime + ". Rang je postavljen na 10Kyu");
            this.rang = "10Kyu";
            return;
        }
        if (!rang.substring(numberSubstring + 1).equals("Kyu") && !rang.substring(numberSubstring + 1).equals("Dan")) {
            System.out.println("Rang nije validan za karatistu: " + ime + ". Rang je postavljen na 10Kyu");
            this.rang = "10Kyu";
        }
    }

    public void napadni(int index) {
        System.out.println("Karatista " + ime + " napada sa " + kata[index] + " katom");
    }

    public void vatreniNapad() {
        System.out.println("Karatista " + ime + " napada sa " +
                kata[ThreadLocalRandom.current().nextInt(0, kata.length)] + " katom");
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        if (godine <= 0) {
            System.out.println(ime + ": Nije validan unos godine za ovog karatistu. Godine nisu promenjene!");
            return;
        }
        this.godine = godine;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
        checkRang(rang);
    }

    public String[] getKata() {
        return kata;
    }

    public void setKata(String[] kata) {
        this.kata = kata;
    }
}

