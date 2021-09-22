package skup.zadaci;

import java.util.*;

public class Zadaci {


    /*
    * 1. Zajednicki elementi
    * Za dva zadata niza bojeva vratiti niz onih brojeva koji se nalaze i u jednom i u drugom nizu.
    *
    * NPR:
    * [1, 2, 3, 4, 5], [2, 4, 6, 8, 10] -> [2, 4]
    * */

    public static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b){
        if (a== null || b== null)
            return null;
        TreeSet<Integer> set = new TreeSet<>(b);
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer i : a){
            if (!set.add(i)){
                res.add(i);
            }
        }
        if (res.isEmpty())
            return null;
        return res;
    }

    /*
    * 2. Svi elementi
    * Za dva zadata niza brojeva vratiti niz svih brojeva iz oba niza bez ponavljanja.
    * */

    public static ArrayList<Integer> union(ArrayList<Integer> a, ArrayList<Integer> b){
        if (a == null && b == null){
            return null;
        }
        if (a == null){
            return b;
        }
        if (b == null){
            return a;
        }
        TreeSet<Integer> set = new TreeSet<>(a);
        set.addAll(b);
        return new ArrayList<>(set);
    }

    /*
    * 3. Razlika
    * Za dva zadata niza brojeva vratiti niz onih brojeva koji se nalaze u prvom
    * ali ne i u drugom nizu, bez ponavljanja.
    * */

    public static ArrayList<Integer> razlika(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a == null && b == null){
            return null;
        }
        if (a == null){
            return null;
        }
        if (b == null){
            return a;
        }
        TreeSet<Integer> set = new TreeSet<>(a);
        set.removeAll(b);
        if (set.isEmpty())
            return null;

        return new ArrayList<>(set);
    }

    /*
     * 4. Napisati funkciju koja broji koliko ima duplikata u zadatom nizu.
     *
     * [1, 2, 3, 4, 4, 2, 3, 5, 6] -> 3
     * [1, 2, 3] -> 0
     * [5, 5, 5, 5, 5, 6] -> 4
     * */

    public static int ponavljanjeBroj(int[] arr){
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (Integer i : arr)
            if (!set.add(i))
                count++;
        return count;
    }

    /*
     * 5. Provera permutacije
     * Za dva zadata niza brojeva proveriti da li moze da se jedan dobije od drugog.
     * Brojevi u nizu se ne ponavljaju
     *
     * NPR:
     * [1, 2, 221, 101], [101, 2, 221, 1] -> da
     * [1, 2, 3], [3, 1, 2, 4] -> ne
     * */

    public static boolean permutacija(ArrayList<Integer> p1, ArrayList<Integer> p2){
        Set<Integer> set1 = new HashSet<>(p1);
        Set<Integer> set2 = new HashSet<>(p2);
        return set1.equals(set2);
    }


    /*
    * 6. Neuparen element
    * Funkciji se prosledjuje niz ciji se svi elementi ponavljaju tacno dva puta,
    * osim jednog koji se ponavlja samo jednom.
    * Vratiti taj element
    *
    * Npr:
    * [1, 1, 2, 3, 3, 4, 4] -> 2
    * */

    public static int neuparen(int[] arr){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2= new HashSet<>();
        for (Integer i : arr) {
            if (!set1.add(i))
                set2.add(i);
        }
        set1.removeAll(set2);
        int x = 0;
        for (Integer i : set1)
            x = i;
        return x;
    }


    /*
    * 7. Anagram
    * Funkcija prima 2 String i daje odgovor da/ne u odnosu na to da li je
    * jedan String anagram drugog.
    *
    * NPR:
    * "panta redovno zakasni"
    * "neopravdan izostanak"
    * Da
    * */

    public static boolean anagram(String s1, String s2){
        s1 = s1.replaceAll(" ", "");
        s2 = s2.replaceAll(" ", "");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            int count = 0;
            for (int j = i; j < s1.length(); j++) {
                if (s1.charAt(i) == s1.charAt(j)){
                    count++;
                }
            }
            String s = Character.toString(s1.charAt(i));
            set.add(s.repeat(count));
            s1 = s1.replaceAll(Character.toString(s1.charAt(i)), "");
            if (s1.length() == 0)
                break;
            i--;
        }
        for (int i = 0; i < s2.length(); i++) {
            int count = 0;
            for (int j = i; j < s2.length(); j++) {
                if (s2.charAt(i) == s2.charAt(j)){
                    count++;
                }
            }
            String s = Character.toString(s2.charAt(i));
            if (!set.contains(s.repeat(count)))
                return false;
            s2 = s2.replaceAll(Character.toString(s2.charAt(i)), "");
            if (s2.length() == 0)
                break;
            i--;
        }

        return true;
    }


}
