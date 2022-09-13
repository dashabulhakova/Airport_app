package flightInfo;

public enum MemberCard {
    BRONZE("Bronze", 1, 0.05),//years of membership, discount
    SILVER("Silver", 3, 0.1),
    GOLD("Gold", 5, 0.15);

    private int id;
    private String level;
    private int yearsAsMember;
    private double discount;

    MemberCard () {}
    MemberCard(String level, int yearsAsMember, double discount) {
        this.level = level;
        this.yearsAsMember = yearsAsMember;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getYearsAsMember() {
        return yearsAsMember;
    }

    public void setYearsAsMember(int yearsAsMember) {
        this.yearsAsMember = yearsAsMember;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
