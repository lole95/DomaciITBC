package rs.itbootcamp.dao;

import rs.itbootcamp.connection.DatabaseConnection;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.MealModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Project KitchenSQL, Package rs.itbootcamp.dao, Class MealDaoSQL, Created by Milovan 14.9.2021.
 */
public class MealDaoSQL implements MealDao {
    private static final Connection conn = DatabaseConnection.getConnection();
    static PreparedStatement st;

    @Override
    public void add(MealModel mm) {
        try {
            st = conn.prepareStatement("INSERT INTO meal VALUES(?, ?, ?, ?)");
            st.setInt(1, mm.getMealId());
            st.setString(2, mm.getMealName());
            st.setString(3, mm.getMealDesc());
            st.setString(4, mm.getMealDificulty());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            st = conn.prepareStatement("DELETE FROM meal WHERE meal_id = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(MealModel mm) {
        try {
            st = conn.prepareStatement("UPDATE meal" +
                    " SET meal_name = ?," +
                    " meal_desc = ?, " +
                    "meal_difficulty = ? " +
                    "WHERE meal_id = ?");

            st.setString(1, mm.getMealName());
            st.setString(2, mm.getMealDesc());
            st.setString(3, mm.getMealDificulty());
            st.setInt(4, mm.getMealId());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MealModel getMeal(int id) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM meal WHERE meal_id = " + id);
            rs.next();
            MealModel mm = new MealModel(rs.getInt(1),
                    rs.getString(2), rs.getString(3),
                    rs.getString(4));
            return mm;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MealModel> getAllMeals() {
        List<MealModel> mealList = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM meal");
            while (rs.next()) {
                MealModel mm = new MealModel(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4));
                mealList.add(mm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mealList;
    }

    @Override
    public List<String> getFoodMealNames(int meal_id) {
        List<String> foodNameList = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT food_name FROM food f" +
                    " INNER JOIN mealfood mf ON f.food_id = mf.food_id" +
                    " WHERE meal_id = " + meal_id);
            while (rs.next()) {
                foodNameList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodNameList;
    }

    @Override
    public List<FoodModel> getFoodMeal(int meal_id) {
        List<FoodModel> foodList = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food f" +
                    " INNER JOIN mealfood mf ON f.food_id = mf.food_id" +
                    " WHERE meal_id = " + meal_id);
            while (rs.next()) {
                FoodModel fm = new FoodModel(rs.getInt(1),
                        rs.getString(2), rs.getDouble(3),
                        rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
                foodList.add(fm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodList;
    }
}

