package rs.itbootcamp.model;

/**
 * Project KitchenSQL, Package rs.itbootcamp.model, Class MealModel, Created by Milovan 14.9.2021.
 */
public class MealModel {
    private int mealId;
    private String mealName, mealDesc, mealDificulty;

    public MealModel(int mealId, String mealName, String mealDesc, String mealDificulty) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealDesc = mealDesc;
        this.mealDificulty = mealDificulty;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealDesc() {
        return mealDesc;
    }

    public void setMealDesc(String mealDesc) {
        this.mealDesc = mealDesc;
    }

    public String getMealDificulty() {
        return mealDificulty;
    }

    public void setMealDificulty(String mealDificulty) {
        this.mealDificulty = mealDificulty;
    }

    @Override
    public String toString() {
        return "Meal name: " + mealName;

    }
}

