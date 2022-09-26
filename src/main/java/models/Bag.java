package models;
import javax.xml.bind.annotation.*;
@XmlRootElement(name = "bag")
@XmlType(propOrder = {"id", "amount", "size", "weight"})
@XmlAccessorType(XmlAccessType.FIELD)
    public class Bag {
        private int id;
        private int amount;
        private int size;
        private int weight;

        public Bag() {};

        public Bag(int amount, int size, int weight) {
            this.amount = amount;
            this.size = size;
            this.weight = weight;

        }

        public int getId() {
            return id;
        }
    @XmlAttribute
        public void setId(int id) {
            this.id = id;
        }

    public int getAmount() {
        return amount;
    }
    @XmlElement
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSize() {
            return size;
        }
    @XmlElement
        public void setSize(int size) {
            this.size = size;
        }

        public int getWeight() {
            return weight;
        }
    @XmlElement
        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
