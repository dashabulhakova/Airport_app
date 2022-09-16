package models;

import java.util.Objects;

public class Staff {
        private int id;
        private String position;
        // constructors / standard setters / getters
        public Staff() {}

        public Staff(String position) {
            this.position = position;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;
        Staff staff = (Staff) o;
        return getId() == staff.getId() && Objects.equals(getPosition(), staff.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPosition());
    }
}
