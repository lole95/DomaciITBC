package rs.itbootcamp.model;

/**
 * Project KitchenSQL, Package rs.itbootcamp.model, Class FridgeModel, Created by Milovan 17.9.2021.
 */
public class FridgeModel {
    private int fridge_id;
    private int user_id;

    public FridgeModel(int fridge_id, int user_id) {
        this.fridge_id = fridge_id;
        this.user_id = user_id;
    }

    public int getFridge_id() {
        return fridge_id;
    }

    public void setFridge_id(int fridge_id) {
        this.fridge_id = fridge_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Fridge: " + fridge_id + " User: " + user_id;
    }
}

