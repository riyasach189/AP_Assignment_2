package org.example;

public class Special_Deal implements Combo {
    private final int specialDealID;
    private int numTickets;
    private int discountPercentage;

    public Special_Deal(int specialDealID, int numTickets, int discountPercentage) {
        this.specialDealID = specialDealID;
        this.numTickets = numTickets;
        this.discountPercentage = discountPercentage;
    }

    public int getSpecialDealID() {
        return specialDealID;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
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
        return ("\nSpecial Deal ID: " + specialDealID + "\nBuy " + numTickets + " and get " + discountPercentage + "% off.");
    }
}
