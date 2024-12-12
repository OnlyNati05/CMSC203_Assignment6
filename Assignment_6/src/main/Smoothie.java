package main;

public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean proteinAdded;
    private final double PROTEIN_COST = 1.50;
    private final double FRUIT_COST = 0.50;

    public Smoothie(String name, SIZE size, int numOfFruits, boolean proteinAdded) {
        super(name, TYPE.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.proteinAdded = proteinAdded;
    }

    @Override
    public double calcPrice() {
        double price = getBasePrice();
        if (getSize() == SIZE.MEDIUM) {
            price += getSizePrice();
        } else if (getSize() == SIZE.LARGE) {
            price += 2 * getSizePrice();
        }
        price += numOfFruits * FRUIT_COST;
        if (proteinAdded) {
            price += PROTEIN_COST;
        }
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + " Smoothie{" +
                "numOfFruits=" + numOfFruits +
                ", proteinAdded=" + proteinAdded +
                ", price=" + calcPrice() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Smoothie smoothie = (Smoothie) obj;
        return numOfFruits == smoothie.numOfFruits && proteinAdded == smoothie.proteinAdded;
    }

    public int getNumOfFruits() {
        return numOfFruits;
    }

    public void setNumOfFruits(int numOfFruits) {
        this.numOfFruits = numOfFruits;
    }

    public boolean isProteinAdded() {
        return proteinAdded;
    }

    public void setProteinAdded(boolean proteinAdded) {
        this.proteinAdded = proteinAdded;
    }
}

