import java.util.Arrays;
import java.util.Scanner;

/**
 * Project Nedelja2DomaciNedelja, Package PACKAGE_NAME, Class Parovi, Created by Milovan 6.8.2021.
 */
public class Parovi {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Lenght af array, has to be even number: ");

        int arrLenght = sc.nextInt();
        int[] firstArray = new int[arrLenght];
        for (int i = 0; i < arrLenght; i++) {
            System.out.print("Enter " + i +". element of array: ");
            firstArray[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(parovi(firstArray)));
    }
    public static int[] parovi(int[] arr){
        int[] par = new int[arr.length/2];
        int counter = 0;
        for (int i = 0; i < par.length; i++) {
            par[i] = arr[counter] + arr[counter + 1];
            counter += 2;
        }
        return par;
    }

}

