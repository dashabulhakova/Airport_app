package models;

import java.util.Objects;

    public class Bag {
        private int id;
        private int size;
        private int weight;

        public Bag() {};

        public Bag(int size, int weight) {
            this.size = size;
            this.weight = weight;

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Bag{" +
                    "size=" + size +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Bag)) return false;
            Bag bag = (Bag) o;
            return getId() == bag.getId() && getSize() == bag.getSize() && getWeight() == bag.getWeight();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getSize(), getWeight());
        }
    }
