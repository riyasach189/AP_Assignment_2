package org.example;

public class Attraction {
    private final int attractionID;
    private String attractionType;
    private String description;
    private String status;
    private int price;
    private int ticketedVisitors;

    public Attraction(int attractionID, String attractionType, String description, String status, int price) {
        this.attractionID = attractionID;
        this.attractionType = attractionType;
        this.description = description;
        this.status = status;
        this.price = price;
    }

    public int getAttractionID() {
        return attractionID;
    }

    public String getAttractionType() {
        return attractionType;
    }

    public void setAttractionType(String attractionType) {
        this.attractionType = attractionType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTicketedVisitors() {
        return ticketedVisitors;
    }

    public void incrTicketedVisitors() {
        ticketedVisitors += 1;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return ("\nAttraction ID: " + attractionID + "\nAttraction Type: " + attractionType + "\nDescription: " + description + "\nStatus: " + status + "\nPrice: " + price);
    }
}