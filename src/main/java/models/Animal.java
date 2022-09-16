package models;

import java.util.Objects;

public class Animal {
    private int id;
    private String animalType;
    private int size;
    private double fee;

    public Animal() {}
    public Animal(String animalType, int size, double fee) {
        this.animalType = animalType;
        this.size = size;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", animalType='" + animalType + '\'' +
                ", size=" + size +
                ", fee=" + fee +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return getId() == animal.getId() && getSize() == animal.getSize() && Double.compare(animal.getFee(), getFee()) == 0 && Objects.equals(getAnimalType(), animal.getAnimalType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAnimalType(), getSize(), getFee());
    }
}
