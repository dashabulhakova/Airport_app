package models;

public enum Meal {
    VE(1, "Vegan"),
    VG(2, "Vegetarian"),
    H( 3, "Halal"),
    SF(4, "Sea Food"),
    LF(5, "Lactose Free"),
    R( 6, "Regular"),
    D( 7, "Extra option");

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
