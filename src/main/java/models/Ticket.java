package models;

import java.util.Objects;

public class Ticket {
    private int id;
    private int price;
    private int seat;

    public Ticket() {}
    public Ticket(int price, int seat) {
        this.price = price;
        this.seat = seat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", seat=" + seat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return getId() == ticket.getId() && getPrice() == ticket.getPrice() && getSeat() == ticket.getSeat();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getSeat());
    }
}
