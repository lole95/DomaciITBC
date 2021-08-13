/**
 * Project Nedelja2DomaciSreda, Package PACKAGE_NAME, Class BID, Created by Milovan 3.8.2021.
 */
public class BID {
    public static void main(String[] args) {
        bid(false, 50, 20.4);
        bid(false, 48, 5);
        bid(true, 20, 41.1);
        bid(false, 20, 40.9);
    }
    public static void bid(boolean b, int i, double d){
        if(!b){
            System.out.print("Boolean. ");
        }
        if(i > 49){
            System.out.print("Integer. ");
        }
        if(Math.floor(d) > i * 2){
            System.out.print("Double. ");
        }
        System.out.println();
    }
}

