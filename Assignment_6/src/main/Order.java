package main;

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderNo;
    private int orderTime;
    private DAY orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    public Order(int orderTime, DAY orderDay, Customer customer) {
        this.orderNo = generateOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); // Deep copy
        this.beverages = new ArrayList<>();
    }

    private int generateOrderNumber() {
        Random random = new Random();
        return 10000 + random.nextInt(80001); // Generates a number between 10000 and 90000
    }

    public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    public void addNewBeverage(String bevName, SIZE size, boolean isWeekend) {
        beverages.add(new Alcohol(bevName, size, isWeekend));
    }

    public int findNumOfBeveType(TYPE type) {
        int count = 0;
        for (Beverage bev : beverages) {
            if (bev.getType() == type) {
                count++;
            }
        }
        return count;
    }

    public double calcOrderTotal() {
        double total = 0.0;
        for (Beverage bev : beverages) {
            total += bev.calcPrice();
        }
        return total;
    }

    public int getTotalItems() {
        return beverages.size();
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNo, other.orderNo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNo)
          .append("\nOrder Time: ").append(orderTime)
          .append("\nOrder Day: ").append(orderDay)
          .append("\nCustomer: ").append(customer.toString())
          .append("\nBeverages:\n");

        for (Beverage bev : beverages) {
            sb.append(bev.toString()).append("\n");
        }

        return sb.toString();
    }

    public int getOrderNo() {
        return orderNo;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public DAY getOrderDay() {
        return orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer); // Deep copy
    }

    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }

	@Override
	public boolean isWeekend() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		// TODO Auto-generated method stub
		
	}
}

