package models;
import javax.xml.bind.annotation.*;
@XmlRootElement(name = "bag")
@XmlType(propOrder = {"id", "size", "weight"})
@XmlAccessorType(XmlAccessType.FIELD)
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
    @XmlAttribute
        public void setId(int id) {
            this.id = id;
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
