package models;

public class Passenger {
        private int id;
        private String fistName;
        private String lastName;
        private int memberId;
        private int bagId;
        private int mealId;

        public Passenger () {}

        public Passenger(String firstName, String lastName, int memberId, int bagId, int mealId) {
            this.fistName = firstName;
            this.lastName = lastName;
            this.memberId = memberId;
            this.bagId = bagId;
            this.mealId = mealId;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getBagId() {
        return bagId;
    }

    public void setBagId(int bagId) {
        this.bagId = bagId;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }
}
