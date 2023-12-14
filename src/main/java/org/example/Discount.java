package org.example;

public class Discount implements Combo {
    private final String discountCode;
    private String discountCategory;
    private int discountPercentage;

    public Discount(String discountCode, String discountCategory, int discountPercentage) throws ArithmeticException{
        this.discountCode = discountCode;
        this.discountCategory = discountCategory;

        if (discountPercentage > 100)
        {
            throw new ArithmeticException("Discount Percentage must be less than 100!");
        }

        else
        {
            this.discountPercentage = discountPercentage;
        }
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public String getDiscountCategory() {
        return discountCategory;
    }

    public void setDiscountCategory(String discountCategory) {
        this.discountCategory = discountCategory;
    }

    @Override
    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String toString() {
         return ("\nDiscount Code: " + discountCode + "\nDiscount Category: " + discountCategory + "\nDiscount Percentage: " + discountPercentage);
    }
}
