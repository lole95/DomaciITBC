package rs.itbootcamp.dao;

import rs.itbootcamp.connection.DatabaseConnection;
import rs.itbootcamp.model.FoodModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Project KitchenSQL, Package rs.itbootcam.dao, Class FoodDaoSQL, Created by Milovan 14.9.2021.
 */
public class FoodDaoSQL implements FoodDao {
    private static final Connection conn = DatabaseConnection.getConnection();
    static PreparedStatement st;
    @Override
    public void add(FoodModel fm) {
        try {
            st = conn.prepareStatement("INSERT INTO food VALUES(?, ?, ?, ?, ?, ?)");
            st.setInt(1, fm.getFoodId());
            st.setString(2, fm.getFoodName());
            st.setDouble(3, fm.getFoodKcal());
            st.setDouble(4, fm.getFoodProteins());
            st.setDouble(5, fm.getFoodCarbohydrates());
            st.setDouble(6, fm.getFoodFat());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addToFridge(int fridgeId, int foodId, double mass) {
        try {
            st = conn.prepareStatement("INSERT INTO fridgefood VALUES(?, ?, ?) " +
                    " ON CONFLICT (fridge_id, food_id) DO UPDATE SET mass = (SELECT mass FROM fridgefood" +
                    " WHERE fridge_id = ? AND food_id = ?) + ?");
            st.setInt(1, fridgeId);
            st.setInt(2, foodId);
            st.setDouble(3, mass);
            st.setDouble(4, fridgeId);
            st.setDouble(5, foodId);
            st.setDouble(6, mass);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addToMeal(int mealID, int foodId, double mass) {
        try {
            st = conn.prepareStatement("INSERT INTO mealfood VALUES(?, ?, ?)");
            st.setInt(1, mealID);
            st.setInt(2, foodId);
            st.setDouble(3, mass);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            st = conn.prepareStatement("DELETE FROM food WHERE food_id = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(FoodModel fm) {
        try {
            st = conn.prepareStatement("UPDATE food SET food_name = ?, food_kcal = ?, " +
                    "food_proteins = ?,food_carbs = ?," +
                    " food_fat = ? " +
                    "WHERE food_id = ?");

            st.setString(1, fm.getFoodName());
            st.setDouble(2, fm.getFoodKcal());
            st.setDouble(3, fm.getFoodProteins());
            st.setDouble(4, fm.getFoodCarbohydrates());
            st.setDouble(5, fm.getFoodFat());
            st.setInt(6, fm.getFoodId());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FoodModel getFood(int id) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food WHERE food_id = " + id);
            rs.next();
            FoodModel fm = new FoodModel(rs.getInt(1),
                    rs.getString(2), rs.getDouble(3),
                    rs.getDouble(4),rs.getDouble(5),rs.getDouble(6));
            return fm;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FoodModel> getAllFood() {
        List<FoodModel> foodList = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food");
            while (rs.next()){
                FoodModel fm = new FoodModel(rs.getInt(1),
                        rs.getString(2), rs.getDouble(3),
                        rs.getDouble(4),rs.getDouble(5),rs.getDouble(6));
                foodList.add(fm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foodList;
    }
}

