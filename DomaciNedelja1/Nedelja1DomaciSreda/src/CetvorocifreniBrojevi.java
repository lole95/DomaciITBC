import java.util.Scanner;

/**
 * Project Domaci_1.Nedela_Sreda, Package PACKAGE_NAME, Class CetvorocifreniBrojevi, Created by Milovan 26.7.2021.
 */
public class CetvorocifreniBrojevi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter four digit number");
        int number = sc.nextInt();
        if(number >= 1000 && number <= 9999){
            int j = number % 10;
            int d = (number/10) % 10;
            int s = (number/100) % 10;
            int h = (number/1000) % 10;
            int res = h*s - (d + j);
            System.out.println(res);
        }
        else {
            System.out.println(" ERROR!!! You didn't enter four digit number!!");
        }
    }
}

