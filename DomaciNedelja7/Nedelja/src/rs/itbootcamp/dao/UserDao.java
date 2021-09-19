package rs.itbootcamp.dao;

import rs.itbootcamp.model.UserModel;

/**
 * Project KitchenSQL, Package rs.itbootcamp.dao, Class UserDao, Created by Milovan 16.9.2021.
 */
public interface UserDao {
    void add(UserModel user);
    void delete(int id);
    void update(UserModel user);
    UserModel getUser(int id);
    void addMealGrade(int userId,int mealId, int grade); // upsert // update OR insert
    boolean login(String userNameOrEmail, String password);
}
