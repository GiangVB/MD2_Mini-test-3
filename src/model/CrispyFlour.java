package model;

import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount {
    public static final int DISCOUNTMARK_1 = 2;
    public static final int DISCOUNTMARK_2 = 4;
    public static final double DISCOUNTRATEMARK_1 = 0.6;
    public static final double DISCOUNTRATEMARK_2 = 0.8;
    public static final double REGULARDISCOUNTRATE = 0.95;
    public static final int EXPIRYPERIOD = 1;
    private int quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        int cost = getCost();
        int amount = quantity * cost;
        return amount;
    }

    @Override
    public LocalDate getExpiryDate() {
        LocalDate manufacturingDate = getManufacturingDate() ;
        LocalDate expiryDate = manufacturingDate.plusYears(EXPIRYPERIOD);
        return expiryDate;
    }

    @Override
    public double getRealMoney() {
        LocalDate today = LocalDate.now();
        LocalDate expiryDate = getExpiryDate();
        LocalDate firstDiscountMarkDate = expiryDate.minusMonths(DISCOUNTMARK_1);
        LocalDate secondDiscountMarkDate = expiryDate.minusMonths(DISCOUNTMARK_2);
        double amount = getAmount();
        double realMoney;

        if (today.isBefore(getExpiryDate()) &&
                (today.isAfter(firstDiscountMarkDate) ||
                        today.isEqual(firstDiscountMarkDate))) {
            realMoney = amount * DISCOUNTRATEMARK_1;
        }
        else if (today.isBefore(firstDiscountMarkDate) &&
                (today.isAfter(secondDiscountMarkDate) ||
                        today.isEqual(secondDiscountMarkDate))) {
            realMoney = amount * DISCOUNTRATEMARK_2;
        }
        else {
            realMoney = amount * REGULARDISCOUNTRATE;
        }
        return realMoney;
    }
    @Override
    public String toString() {
        return "M?? nguy??n li???u: " + getId() +
                ", T??n nguy??n li???u: " + getName() +
                ", Ng??y SX: " + getManufacturingDate() +
                ", Gi?? th??nh: " + cost +
                ", S??? l?????ng: " + quantity;
    }
}
