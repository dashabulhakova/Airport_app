package com.solvd.airport.models;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement(name = "meal")
@XmlType(propOrder = {"id", "mealType", "price"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Meal {
    @XmlAttribute
    private int id;
    @XmlElement
    private String mealType;
    @XmlElement
    private int price;

    public Meal() {}
    public Meal(String mealType, int price) {
        this.mealType = mealType;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", mealType='" + mealType + '\'' +
                ", price=" + price +
                '}';
    }

}
