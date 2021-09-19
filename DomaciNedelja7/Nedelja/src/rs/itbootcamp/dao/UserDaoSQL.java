package rs.itbootcamp.dao;

import rs.itbootcamp.connection.DatabaseConnection;
import rs.itbootcamp.model.MealModel;
import rs.itbootcamp.model.UserModel;

import java.sql.*;
import java.util.Scanner;

/**
 * Project KitchenSQL, Package rs.itbootcamp.dao, Class UserDaoSQL, Created by Milovan 16.9.2021.
 */
public class UserDaoSQL implements UserDao {
    private static final Connection conn = DatabaseConnection.getConnection();
    static PreparedStatement st;

    @Override
    public void add(UserModel user) {
        try {
            st = conn.prepareStatement("INSERT INTO users VALUES(?, ?, ?, ?, ?)");
            st.setInt(1, user.getUserId());
            st.setString(2, user.getUserName());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setBoolean(5, user.isAdmin());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            st = conn.prepareStatement("DELETE FROM users WHERE user_id = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(UserModel user) {
        try {
            st = conn.prepareStatement("UPDATE users " +
                    " SET username = ?," +
                    " email = ?, " +
                    "user_password = ?," +
                    "user_admin = ? " +
                    "WHERE user_id = ?");

            st.setString(1, user.getUserName());
            st.setString(2, user.getEmail());
            st.setString(3, user.getPassword());
            st.setBoolean(4, user.isAdmin());
            st.setInt(5, user.getUserId());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserModel getUser(int id) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE user_id = " + id);
            rs.next();
            UserModel user = new UserModel(rs.getInt(1),
                    rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getBoolean(5));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addMealGrade(int userId, int mealId, int grade) {
//        INSERT INTO usermeal (user_id, meal_id, grade)
//        VALUES (1, 1, 6) ON CONFLICT (user_id, meal_id)
//        DO UPDATE SET grade = 6;
        try {
            st = conn.prepareStatement("INSERT INTO usermeal VALUES(?,?,?) ON " +
                    " CONFLICT (user_id, meal_id) DO UPDATE SET grade = ?");
            st.setInt(1, userId);
            st.setInt(2, mealId);
            st.setInt(3, grade);
            st.setInt(4, grade);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean login(String userNameOrEmail, String password) {
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT user_password FROM users " +
                    "WHERE username = '" + userNameOrEmail + "' OR email = '" + userNameOrEmail + "';");
            if (rs.next() && rs.getString(1).equals(password)){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


