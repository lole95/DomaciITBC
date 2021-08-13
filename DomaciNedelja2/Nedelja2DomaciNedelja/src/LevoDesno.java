import java.util.Scanner;

/**
 * Project Nedelja2DomaciNedelja, Package PACKAGE_NAME, Class LevoDesno, Created by Milovan 6.8.2021.
 */
public class LevoDesno {
    public static void main(String[] args) {
        System.out.print("Enter lenght of array: ");
        Scanner sc = new Scanner(System.in);
        int arrayLenght = sc.nextInt();
        double[] unorederedList = new double[arrayLenght];
        for (int i = 0; i < arrayLenght; i++) {
            System.out.print("Enter " + i + ". member of the list: ");
            unorederedList[i] = sc.nextDouble();
        }
        arrayOutput(orderList(unorederedList));
    }

    public static double[] orderList(double[] array){
        double[] orderedArray = new double[array.length];
        int id = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == 0){
                    if(array[j] < 0){
                        orderedArray[id] = array[j];
                        id++;
                    }
                }
                else if (i == 1){
                    if(array[j] == 0){
                        orderedArray[id] = array[j];
                        id++;
                    }
                }
                else {
                    if(array[j] > 0){
                        orderedArray[id] = array[j];
                        id++;
                    }
                }
            }
        }
        return orderedArray;
    }
    public static void arrayOutput(double[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

