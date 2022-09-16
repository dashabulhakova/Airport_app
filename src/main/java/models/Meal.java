package models;

public class Meal {
    private int id;
    private String mealType;
    private int option;

    Meal(int option, String mealType) {
        this.mealType = mealType;
        this.option = option;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }
}
