/**
 * Project Nedelja3DomaciSreda, Package PACKAGE_NAME, Class SifrovaneReci, Created by Milovan 11.8.2021.
 */
public class SifrovaneReci {
    public static String bezCenzure(String decodeMessege, String[] key, String[] decode) {
//        String[] niz = poruka.split(" ");
//        String res = "";
//
//        for (int i = 0; i < niz.length; i++) {
//            for (int j = 0; j < key.length; j++) {
//                if(niz[i].equals(key[j])){
//                    niz[i] = decode[j];
//                }
//            }
//            res += niz[i].concat(" ");
//        }
//        return res;
        for (int i = 0; i < key.length; i++) {
            decodeMessege = decodeMessege.replaceAll(key[i], decode[i]);
        }
        return decodeMessege;
    }
//
//    public static void main(String[] args) {
//        String poruka = "Jedi #$%^ !@#$!!!@# mali!";
//        String[] kljuc = {"#$%^", "!@#$!!!@#"};
//        String[] decode = {"pite", "moroncicu"};
//        System.out.println(bezCenzure(poruka, kljuc, decode));
//    }
//public static String bezCenzure(String poruka, String[] kljuc, String[] decode) {
//    String[] niz = poruka.split(" ");
//    String res = "";

//    for (int i = 0; i < niz.length; i++) {
//        for (int j = 0; j < kljuc.length; j++) {
//
//            if(niz[i].equals(kljuc[j])){
//
//                niz[i] = decode[j];
//
//            }
//        }

//        res += niz[i].concat(" ");
//
//    }
//    return res;
//}

    public static void main(String[] args) {
        String[] kljuc = new String[]{"#\\$%\\^", " !@#\\$!!!@#"};
        String[] decode = new String[]{"pite", " moroncinu"};
        String poruka = "Jedi #$%^ !@#$!!!@# mali!";
        String res = bezCenzure(poruka,kljuc,decode);
        System.out.println(res);
    }
}


