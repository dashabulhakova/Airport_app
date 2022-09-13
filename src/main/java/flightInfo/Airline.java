package flightInfo;

public enum Airline {
    DELTA(1, "Delta",176),
    SPIRIT(2, "Spirit",98),
    HAWAIIAN(3, "Hawaiian",250),
    UNITED_AIRLINES(4, "United Airlines",150),
    SOUTHWEST(5, "Southwest",275),
    FRONTIER(6, "Frontier",167),
    AMERICAN_AIRLINES(7, "American Airlines",138);

    private int id;
    private int index;
    private String name;
    private double fare;

    Airline () {}
    Airline(int index, String name, double fare) {
        this.index = index;
        this.name = name;
        this.fare = fare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
