package org.example;

import java.util.ArrayList;

public class Zoo {
    public static ArrayList<Visitor> visitors = new ArrayList<Visitor>();
    public static ArrayList<String> feedback = new ArrayList<String>();
    public static ArrayList<Attraction> attractions = new ArrayList<Attraction>();
    public static ArrayList<Animal> animals = new ArrayList<Animal>();
    public static ArrayList<Discount> discounts = new ArrayList<Discount>();
    public static ArrayList<Special_Deal> specialDeals = new ArrayList<Special_Deal>();
    public static int latest_attraction_id = 0;
    public static int latest_animal_id = 0;
    public static int latest_specialDeal_id = 1;
    public static int total_visitors = 0;
    public static int total_revenue = 0;
    public static Attraction most_popular_attraction = null;

    public Zoo() {
        Discount discount = new Discount("NONE", "None", 0);
        discounts.add(discount);
        discount = new Discount("MINOR10", "Minor", 10);
        discounts.add(discount);
        discount = new Discount("SENIOR20", "Senior Citizen", 20);
        discounts.add(discount);

        Special_Deal specialDeal = new Special_Deal(latest_specialDeal_id, 2, 15);
        latest_specialDeal_id += 1;
        specialDeals.add(specialDeal);
        specialDeal = new Special_Deal(latest_specialDeal_id, 3, 30);
        latest_specialDeal_id += 1;
        specialDeals.add(specialDeal);

        Animal Lion = new Mammal(latest_animal_id, "Lion", "Roar", "This is a lion.");
        latest_animal_id += 1;
        Animal Deer = new Mammal(latest_animal_id, "Deer", "Bleat", "This is a deer.");
        latest_animal_id += 1;
        Animal Snake = new Reptile(latest_animal_id, "Snake", "Hiss", "This is a snake.");
        latest_animal_id += 1;
        Animal Lizard = new Reptile(latest_animal_id, "Lizard", "Lick", "This is a lizard.");
        latest_animal_id += 1;
        Animal Frog = new Amphibian(latest_animal_id, "Frog", "Croak", "This is a frog.");
        latest_animal_id += 1;
        Animal Newt = new Amphibian(latest_animal_id, "Newt", "Cluck", "This is a newt.");
        latest_animal_id += 1;
        animals.add(Lion);
        animals.add(Deer);
        animals.add(Snake);
        animals.add(Lizard);
        animals.add(Frog);
        animals.add(Newt);

        Attraction attraction = new Attraction(latest_attraction_id, "Jungle Safari", "This is a Jungle Safari.", "Open", 10);
        latest_attraction_id += 1;
        attractions.add(attraction);
        attraction = new Attraction(latest_attraction_id, "Botanical Garden", "This is a Botanical Garden.", "Open", 10);
        latest_attraction_id += 1;
        attractions.add(attraction);
        attraction = new Attraction(latest_attraction_id, "Jurassic Park", "This is a Jurassic Park.", "Open", 10);
        latest_attraction_id += 1;
        attractions.add(attraction);
    }

    public static void getMost_popular_attraction()
    {
        //sorting the list in descending order
        attractions.sort((attraction1, attraction2) -> Integer.compare(attraction2.getTicketedVisitors(), attraction1.getTicketedVisitors()));

        most_popular_attraction = attractions.get(0);
    }

}
