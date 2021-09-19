package rs.itbootcamp.dao;

import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.FridgeModel;

import java.util.List;

/**
 * Project KitchenSQL, Package rs.itbootcamp.dao, Class FridgeDao, Created by Milovan 17.9.2021.
 */
public interface FridgeDao {
    void add(FridgeModel f);
    void delete(int id);
    void update(FridgeModel f);
    List<FoodModel> getAllFood(int fridgeId);
}

