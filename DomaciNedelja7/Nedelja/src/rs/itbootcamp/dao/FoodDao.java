package rs.itbootcamp.dao;

import rs.itbootcamp.model.FoodModel;

import java.util.List;

/**
 * Project KitchenSQL, Package rs.itbootcam.dao, Class FoodDao, Created by Milovan 14.9.2021.
 */
public interface FoodDao {
    void add(FoodModel fm);
    void addToFridge(int fridgeId, int foodId, double mass);
    void addToMeal(int mealID, int foodId, double mass);
    void delete(int id);
    void update(FoodModel fm);
    FoodModel getFood(int id);
    List<FoodModel> getAllFood();


}
