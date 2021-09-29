import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Project Sreda, Package PACKAGE_NAME, Class Main, Created by Milovan 29.9.2021.
 */
public class Main {
    public static void main(String[] args) {
        // Prvi zadatak
        List<Integer> nubers = Arrays.asList(1, 2, 3, 5, 6, 4, 7, 8, 14, 12, 11,22, 25, 24, 93, 99, 60);
        List<Integer> zadatak1 = nubers.stream().map(x -> x % 3 == 0 ? x + 2 : x).collect(Collectors.toList());
        System.out.println(zadatak1);

        // Drugi zadatak
        // nisam sigurad da li treba da se svi dupliraju pa da se
        // izbace oni koji su deljivi sa tri, ili treba da probamo da dupliramo i da vidimo da li su deljivi sa tri
        // plus samo oni brojevi koji su prvobitno deljivi sa tri ce biti i kad se dupliraju
        List<Integer> zadatak2 = nubers.stream().filter(x -> x % 3 != 0).map(x -> x*2).collect(Collectors.toList());
        System.out.println(zadatak2);


        // Treci zadatak
        Set<Integer> zadatak3 = nubers.stream().map(x -> x % 2 != 0 ? x * 2 : x).collect(Collectors.toSet());
        System.out.println(zadatak3);
    }
}

