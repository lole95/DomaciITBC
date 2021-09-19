package rs.itbootcamp.dao;

import rs.itbootcamp.connection.DatabaseConnection;
import rs.itbootcamp.model.FoodModel;
import rs.itbootcamp.model.FridgeModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Project KitchenSQL, Package rs.itbootcamp.dao, Class FridgeDaoSQL, Created by Milovan 17.9.2021.
 */
public class FridgeDaoSQL implements FridgeDao {
    private static final Connection conn = DatabaseConnection.getConnection();
    static PreparedStatement st;
    @Override
    public void add(FridgeModel f) {
        try {
            st = conn.prepareStatement("INSERT INTO fridge VALUES(?, ?)");
            st.setInt(1, f.getFridge_id());
            st.setInt(2, f.getUser_id());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            st = conn.prepareStatement("DELETE FROM fridge WHERE fridge_id = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(FridgeModel f) {
        try {
            st = conn.prepareStatement("UPDATE fridge SET user_id = ?" +
                    " WHERE fridge_id = ?");


            st.setInt(1, f.getUser_id());
            st.setInt(2, f.getFridge_id());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FoodModel> getAllFood(int fridgeId) {
        List<FoodModel> foodList = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM food f" +
                    " INNER JOIN fridgefood ff ON f.food_id = ff.food_id" +
                    " WHERE fridge_id = " + fridgeId);
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

