package org.example;

public class Ticket{
    private final Attraction attraction;

    public Ticket(Attraction attraction) {
        this.attraction = attraction;
    }

    public Attraction getAttraction() {
        return attraction;
    }
}
