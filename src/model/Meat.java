package model;

import java.time.LocalDate;

public class Meat extends Material implements Discount {
    public static final int DISCOUTMARK_1 = 5;
    public static final double DISCOUNTRATEMARK_1 = 0.7;
    public static final double REGULARDISCOUNTRATE = 0.9;
    public static final int EXPIRYPERIOD = 7;
    private double weight;

    public Meat() {
    }

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        double amount = weight * cost;
        return amount;
    }

    @Override
    public LocalDate getExpiryDate() {
        LocalDate manufacturingDate = getManufacturingDate();
        LocalDate expiryDate = manufacturingDate.plusDays(EXPIRYPERIOD);
        return expiryDate;
    }

    @Override
    public double getRealMoney() {
        LocalDate todayDate = LocalDate.now();
        int today = todayDate.getDayOfMonth();
        LocalDate expiryDate = getExpiryDate();
        int expiryDateDay = expiryDate.getDayOfMonth();
        double amount = getAmount();
        double realMoney;

        if (today + DISCOUTMARK_1 >= expiryDateDay) {
            realMoney = amount * DISCOUNTRATEMARK_1;
        }
        else {
            realMoney = amount * REGULARDISCOUNTRATE;
        }
        return realMoney;
    }
}
