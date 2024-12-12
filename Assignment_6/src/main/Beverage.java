package main;

public abstract class Beverage {
    private String name;
    private TYPE type;
    private SIZE size;
    private final double BASE_PRICE = 2.0;
    private final double SIZE_PRICE = 1.0;

    public Beverage(String name, TYPE type, SIZE size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public abstract double calcPrice();

    @Override
    public String toString() {
        return "Beverage{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Beverage beverage = (Beverage) obj;
        return name.equals(beverage.name) &&
                type == beverage.type &&
                size == beverage.size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public SIZE getSize() {
        return size;
    }

    public void setSize(SIZE size) {
        this.size = size;
    }

    public double getBasePrice() {
        return BASE_PRICE;
    }

    public double getSizePrice() {
        return SIZE_PRICE;
    }
}
