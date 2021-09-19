import rs.itbootcamp.dao.*;
import rs.itbootcamp.model.FoodModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Project KitchenSQL, Package PACKAGE_NAME, Class Main, Created by Milovan 14.9.2021.
 */
public class Main {
    static FoodDao fd = new FoodDaoSQL();
    static MealDao md = new MealDaoSQL();
    static int fridge_id = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(md.getMealNames("bif as"));
        mainMenu(sc);
    }

    public static ArrayList<String> exclude(ArrayList<String> list, String stringToRemove){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toLowerCase().contains(stringToRemove.toLowerCase())){
                list.remove(list.get(i));
                i--;
            }
        }
        return list;
    }

    public static ArrayList<String> startWith(ArrayList<String> list, String startWith){
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).toLowerCase().startsWith(startWith.toLowerCase())){
                list.remove(list.get(i));
                i--;
            }
        }
        return list;
    }

    public static void listAll(ArrayList<String> list, int numbOfitemsOnPage, Scanner sc, Boolean searchAll){
        int maxPage = 0;
        if (list.size() == 0){
            System.out.println("No results.");
        }
        String choice = "";
        int currentPage = 1;
        while (!choice.equals("b")) {
            boolean isPreviousPossible = false;
            boolean isNextPossible = false;
            if (list.size() % numbOfitemsOnPage == 0) {
                maxPage = list.size() / numbOfitemsOnPage;
            }
            else {
                maxPage = list.size() / numbOfitemsOnPage + 1;
            }
            for (int i = numbOfitemsOnPage * (currentPage - 1); i < currentPage * numbOfitemsOnPage; i++) {
                System.out.println(list.get(i));
                if (i == list.size() - 1){
                    break;
                }
            }
            if (currentPage > 1){
                isPreviousPossible = true;
                System.out.print("  p -> [PREVIUS PAGE]   ");
            }
            if (currentPage < maxPage){
                isNextPossible = true;
                System.out.print("  n -> [NEXT PAGE]   ");
            }
            System.out.print("b -> [BACK]");
            if (searchAll){
                sc.skip("[\r\n]+");
                searchAll = false;
            }

            choice = sc.nextLine();
            String [] arrayChoice = choice.split(" ");
            switch (arrayChoice[0]){
                case "p":
                    if (isPreviousPossible)
                        currentPage--;
                    break;
                case "n":
                    if (isNextPossible)
                        currentPage++;
                    break;
                case "-exclude":
                    list = exclude(list, arrayChoice[1]);
                    break;
                case "-page":
                    numbOfitemsOnPage = Integer.parseInt(arrayChoice[1]);
                    break;
                case "-startWith":
                    list = startWith(list, arrayChoice[1]);
                    break;
                default:
                    break;

            }
        }
    }

    public static void seearchMeals(Scanner sc){
        int choice;
        do {
            System.out.println("Search meals: ");
            System.out.println("-------------");
            System.out.println("1: All meals");
            System.out.println("2: Search by name or description");
            System.out.println("0: Back");

            choice = sc.nextInt();
            int numOfPages = 3;
            int x = 0;
            switch (choice) {
                case 1:
                    listAll(md.getAllMealNames(), numOfPages, sc, true);
                    break;
                case 2:
                    System.out.println("Enter your search string: ");
                    sc.skip("[\r\n]+");
                    String s = sc.nextLine();
                    listAll(md.getMealNames(s),numOfPages, sc, false);
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }

    private static void addFoodToFridge(Scanner sc) {
        int choice = -1;
        while (choice != 0) {
            List<FoodModel> foodList = fd.getAllFood();
            for (int i = 0; i < foodList.size(); i++) {
                System.out.println(i + 1 + ": " + foodList.get(i).getFoodName());
            }
            System.out.println("0: back");

            choice = sc.nextInt();
            if (choice > 0 && choice <= foodList.size()) {
                System.out.println("How much in grams.");
                double mass = sc.nextDouble();
                fd.addToFridge(fridge_id, foodList.get(choice - 1).getFoodId(), mass);
                System.out.println("uspesno");
            }
        }

    }

    private static void removeFoodFromFridge(Scanner sc){
        int choice = -1;
        while (choice != 0){

        }
    }

    private static void fridgeMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("My fridge: ");
            System.out.println("-------------");
            System.out.println("1: Add food");
            System.out.println("2: Remove");
            System.out.println("3: All food");
            System.out.println("4: Add new food");
            System.out.println("0: Back");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addFoodToFridge(sc);
                    break;
                case 2:
                    removeFoodFromFridge(sc);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }

    private static void mealMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("My meals: ");
            System.out.println("-------------");
            System.out.println("1: Search meal");
//            System.out.println("2: Remove");
//            System.out.println("3: All food");
//            System.out.println("4: Add new food");
            System.out.println("0: Back");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    seearchMeals(sc);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }

    private static void mainMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("Main menu: ");
            System.out.println("-------------");
            System.out.println("1: My Fridge");
            System.out.println("2: Meals");
            System.out.println("3: All food");
            System.out.println("4: Add new food");
            System.out.println("0: Exit");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    fridgeMenu(sc);
                    break;
                case 2:
                    mealMenu(sc);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    break;
                default:
                    break;

            }
        }
        while (choice != 0);


    }
}

