package main;

public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private final double EXTRA_COST = 0.50;

    public Coffee(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
        super(name, TYPE.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = getBasePrice();
        if (getSize() == SIZE.MEDIUM) {
            price += getSizePrice();
        } else if (getSize() == SIZE.LARGE) {
            price += 2 * getSizePrice();
        }
        if (extraShot) {
            price += EXTRA_COST;
        }
        if (extraSyrup) {
            price += EXTRA_COST;
        }
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + " Coffee{" +
                "extraShot=" + extraShot +
                ", extraSyrup=" + extraSyrup +
                ", price=" + calcPrice() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Coffee coffee = (Coffee) obj;
        return extraShot == coffee.extraShot && extraSyrup == coffee.extraSyrup;
    }

    public boolean hasExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean hasExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }
}

