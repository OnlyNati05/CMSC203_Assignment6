package main;

public class Alcohol extends Beverage {
    private boolean isWeekend;
    private final double WEEKEND_COST = 0.60;

    public Alcohol(String name, SIZE size, boolean isWeekend) {
        super(name, TYPE.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    @Override
    public double calcPrice() {
        double price = getBasePrice();
        if (getSize() == SIZE.MEDIUM) {
            price += getSizePrice();
        } else if (getSize() == SIZE.LARGE) {
            price += 2 * getSizePrice();
        }
        if (isWeekend) {
            price += WEEKEND_COST;
        }
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + " Alcohol{" +
                "isWeekend=" + isWeekend +
                ", price=" + calcPrice() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Alcohol alcohol = (Alcohol) obj;
        return isWeekend == alcohol.isWeekend;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }
}

