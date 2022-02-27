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
        LocalDate todayDate = LocalDate.now();
        int todayMonth = todayDate.getMonthValue();
        LocalDate expiryDate = getExpiryDate();
        int expiryDateMonth = expiryDate.getMonthValue();
        double amount = getAmount();
        double realMoney;

        if (todayMonth + DISCOUNTMARK_1 >= expiryDateMonth) {
            realMoney = amount * DISCOUNTRATEMARK_1;
        }
        else if (todayMonth + DISCOUNTMARK_2 >= expiryDateMonth) {
            realMoney = amount * DISCOUNTRATEMARK_2;
        }
        else {
            realMoney = amount * REGULARDISCOUNTRATE;
        }
        return realMoney;
    }
}
