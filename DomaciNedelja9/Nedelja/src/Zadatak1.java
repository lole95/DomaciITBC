import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * Project Nedelja, Package PACKAGE_NAME, Class Zadatak1, Created by Milovan 2.10.2021.
 */
public class Zadatak1 {
    private static int[] zeroToLastPosition(int[] a){
        int[] x = new int[a.length];
        int index = 0;
        for (int i = 0; i < x.length; i++) {
            if (a[i] != 0){
                x[index] = a[i];
                index++;
            }
        }
        return x;
    }
    private static int[] generateArray(){
        Random rd = new Random();
        int lenght = rd.nextInt(50);
        int[] randArray = new int[lenght];
        for (int i = 0; i < randArray.length; i++) {
            randArray[i] = rd.nextInt(10);
        }
        return randArray;
    }

    //assertEquals(new int[]{---}, imeFunkcije(new int[]{...});

    public static void main(String[] args) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("OverOneThousand.txt"));
            String begining = "assertEquals(new int[]{";
            String midle = "}, zeroToLastPosition(new int[]{";
            String end = "});";
            for (int i = 0; i <1000 ; i++) {
                StringBuilder sb = new StringBuilder();
                int[] randA = generateArray();
                String randArrString = Arrays.toString(randA).substring(1, Arrays.toString(randA).length()-1);
                int[] result = zeroToLastPosition(randA);
                String reslulString = Arrays.toString(result).substring(1, Arrays.toString(result).length()-1);
                sb.append(begining);
                sb.append(reslulString);
                sb.append(midle);
                sb.append(randArrString);
                sb.append(end);
                writer.write(sb.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(Arrays.toString(generateArray()));
    }
}

