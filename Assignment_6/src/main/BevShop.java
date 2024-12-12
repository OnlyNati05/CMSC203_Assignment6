package main;

import java.util.ArrayList;

public class BevShop implements BevShopInterfce {
    private ArrayList<Order> orders;
    private int alcoholCount;
    private static final int MAX_ALCOHOL = MAX_ORDER_FOR_ALCOHOL;
    private static final int MIN_AGE_FOR_ALCOHOL = 21;

    public BevShop() {
        orders = new ArrayList<>();
        alcoholCount = 0;
    }

    @Override
    public boolean validTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public boolean eligibleForMore() {
        return alcoholCount < MAX_ALCOHOL;
    }

    @Override
    public boolean validAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
        alcoholCount = 0;
        orders.add(new Order(time, day, new Customer(customerName, customerAge)));
    }

    @Override
    public void processAlcoholOrder(String bevName, SIZE size) {
        if (eligibleForMore()) {
            Order currentOrder = getCurrentOrder();
            currentOrder.addNewBeverage(bevName, size, isWeekend(currentOrder.getOrderDay()));
            alcoholCount++;
        }
    }

    @Override
    public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
        Order currentOrder = getCurrentOrder();
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        Order currentOrder = getCurrentOrder();
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0.0;
    }

    @Override
    public double totalMonthlySale() {
        double total = 0.0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public void sortOrders() {
        for (int i = 0; i < orders.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo()) {
                    minIndex = j;
                }
            }
            Order temp = orders.get(i);
            orders.set(i, orders.get(minIndex));
            orders.set(minIndex, temp);
        }
    }

    @Override
    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    private boolean isWeekend(DAY day) {
        return day == DAY.SATURDAY || day == DAY.SUNDAY;
    }

    private Order getCurrentOrder() {
        return orders.get(orders.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monthly Orders:\n");
        for (Order order : orders) {
            sb.append(order.toString()).append("\n");
        }
        sb.append("Total Monthly Sale: ").append(totalMonthlySale());
        return sb.toString();
    }
}




