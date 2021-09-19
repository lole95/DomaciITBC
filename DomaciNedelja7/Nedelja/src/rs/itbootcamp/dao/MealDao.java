package rs.itbootcamp.dao;

import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Project KitchenSQL, Package rs.itbootcamp.dao, Class MealDao, Created by Milovan 14.9.2021.
 */
public interface MealDao {
    void add(MealModel mm);
    void delete(int id);
    void update(MealModel mm);
    MealModel getMeal(int id);
    List<MealModel> getAllMeals();
    ArrayList<String> getAllMealNames();
    ArrayList<String> getMealNames(String search);
    List<String> getFoodMealNames(int meal_id);
    List<FoodModel> getFoodMeal(int meal_id);

}
