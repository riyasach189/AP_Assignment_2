package org.example;
import java.util.Objects;
import java.util.Scanner;

import static org.example.Zoo.*;

public class Admin {

    private final String username = "admin";
    private final String password = "admin123";
    Scanner scanner = new Scanner(System.in);

    //no getters or setters

    //constructor
    public Admin(String username, String password) throws IncorrectPasswordException {

        if (!Objects.equals(username, this.username) | (!Objects.equals(password, this.password)))
        {
            throw new IncorrectPasswordException("Incorrect username or password!");
        }

    }

    @Override
    public String toString() {
        return "This is the admin.";
    }

    //methods
    public void manageAttractions()
    {
        int choice;

        while (true)
        {
            System.out.print("""
                    1. Add Attraction
                    2. View Attractions
                    3. Modify Attraction
                    4. Remove Attraction
                    5. Exit
                                        
                    Enter your choice:
                    """);

            choice = scanner.nextInt();

            if (choice == 1)
            {
                String attractionType;
                String status;
                String description;
                int price;

                scanner.nextLine(); //consume the newline character
                System.out.print("Enter Attraction Name: ");
                attractionType = scanner.nextLine();
                System.out.print("Enter Attraction Description: ");
                description = scanner.nextLine();
                System.out.print("Enter Attraction Status (Open/Closed): ");
                status = scanner.nextLine();
                System.out.print("Enter Attraction Price: ");
                price = scanner.nextInt();

                Attraction new_attraction = new Attraction(latest_attraction_id, attractionType, description, status, price);
                latest_attraction_id += 1;

                attractions.add(new_attraction);

                System.out.println("Attraction added successfully!\n");
            }

            else if (choice == 2)
            {
                for (Attraction attraction: attractions)
                {
                    System.out.println(attraction);
                }
                System.out.println("\n");
            }

            else if (choice == 3)
            {
                int attractionID;
                System.out.print("Enter Attraction ID of the attraction you want to modify: ");
                attractionID = scanner.nextInt();
                Attraction curr_attraction = null;

                for (Attraction attraction : attractions)
                {
                    if (attractionID == attraction.getAttractionID())
                    {
                        curr_attraction = attraction;
                        break;
                    }
                }

                if (curr_attraction == null)
                {
                    System.out.println("Invalid Attraction ID!\n");
                }

                else
                {
                    String attractionType;
                    String status;
                    int price;
                    String description;

                    scanner.nextLine(); //consume the newline character
                    System.out.print("Enter new Attraction Name: ");
                    attractionType = scanner.nextLine();
                    System.out.print("Enter new Attraction Description: ");
                    description = scanner.nextLine();
                    System.out.print("Enter new Attraction Status (Open/Closed): ");
                    status = scanner.nextLine();
                    System.out.print("Enter new Attraction Price: ");
                    price = scanner.nextInt();

                    curr_attraction.setAttractionType(attractionType);
                    curr_attraction.setStatus(status);
                    curr_attraction.setPrice(price);
                    curr_attraction.setDescription(description);

                    System.out.println("Attraction modified successfully!\n");
                }

            }

            else if (choice == 4)
            {
                int attractionID;
                System.out.println("Enter Attraction ID: ");
                attractionID = scanner.nextInt();
                Attraction curr_attraction = null;

                for (Attraction attraction : attractions)
                {
                    if (attractionID == attraction.getAttractionID())
                    {
                        curr_attraction = attraction;
                        break;
                    }
                }

                if (curr_attraction == null)
                {
                    System.out.println("Invalid Attraction ID!\n");
                }

                else
                {
                    attractions.remove(curr_attraction);
                    System.out.println("Attraction removed successfully!\n");
                }
            }

            else if (choice == 5)
            {
                return;
            }

            else
            {
                System.out.println("Please enter a number from 1 to 5!\n");
            }
        }
    }

    public void manageAnimals()
    {
        int choice;

        while (true)
        {
            System.out.print("""
                    1. Add Animal
                    2. View Animals
                    3. Update Animal Details
                    4. Remove Animal
                    5. Exit
                                        
                    Enter your choice:
                    """);

            choice = scanner.nextInt();

            if (choice == 1)
            {
                String animalName;
                int animalType;
                String animalSound;
                String animalDescription;

                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter Animal Name: ");
                animalName = scanner.nextLine();
                System.out.print("Enter Animal Sound: ");
                animalSound = scanner.nextLine();
                System.out.print("Enter Animal Description: ");
                animalDescription = scanner.nextLine();

                System.out.println("Enter Animal Type: ");
                System.out.print("""
                    1. Mammal
                    2. Amphibian
                    3. Reptile
                                        
                    Enter your choice:
                    """);
                animalType = scanner.nextInt();

                Animal new_animal;

                if (animalType == 1)
                {
                    new_animal = new Mammal(latest_animal_id, animalName, animalSound, animalDescription);
                }

                else if (animalType == 2)
                {
                    new_animal = new Amphibian(latest_animal_id, animalName, animalSound, animalDescription);
                }

                else if (animalType == 3)
                {
                    new_animal = new Reptile(latest_animal_id, animalName, animalSound, animalDescription);
                }

                else
                {
                    System.out.println("Invalid Animal Type!\n");
                    continue;
                }

                latest_animal_id += 1;

                animals.add(new_animal);

                System.out.println("Animal added successfully!\n");
            }

            else if (choice == 2)
            {
                for (Animal animal: animals)
                {
                    System.out.println(animal);
                }
                System.out.println("\n");
            }

            else if (choice == 3)
            {
                int animalID;
                System.out.println("Enter Animal ID of the animal whose details you want to update: ");
                animalID = scanner.nextInt();
                Animal curr_animal = null;

                for (Animal animal : animals)
                {
                    if (animalID == animal.getAnimalID())
                    {
                        curr_animal = animal;
                        break;
                    }
                }

                if (curr_animal == null)
                {
                    System.out.println("Invalid Animal ID!\n");
                }

                else
                {
                    String animalName;
                    String animalSound;
                    String animalDescription;

                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter new Animal Name: ");
                    animalName = scanner.nextLine();
                    System.out.print("Enter new Animal Sound: ");
                    animalSound = scanner.nextLine();
                    System.out.print("Enter new Animal Description: ");
                    animalDescription = scanner.nextLine();

                    curr_animal.setName(animalName);
                    curr_animal.setAnimalSound(animalSound);
                    curr_animal.setAnimalDescription(animalDescription);

                    System.out.println("Animal details updated successfully!\n");
                }

            }

            else if (choice == 4)
            {
                int animalID;
                System.out.println("Enter Animal ID: ");
                animalID = scanner.nextInt();
                Animal curr_animal = null;

                for (Animal animal : animals)
                {
                    if (animalID == animal.getAnimalID())
                    {
                        curr_animal = animal;
                        break;
                    }
                }

                if (curr_animal == null)
                {
                    System.out.println("Invalid Animal ID!\n");
                }

                else
                {
                    animals.remove(curr_animal);
                    System.out.println("Animal removed successfully!\n");
                }
            }

            else if (choice == 5)
            {
                return;
            }

            else
            {
                System.out.println("Please enter a number from 1 to 5!\n");
            }
        }
    }

    public void scheduleEvents()
    {
        int attractionID;
        System.out.print("Enter Attraction ID of the attraction you want to schedule: ");
        attractionID = scanner.nextInt();
        Attraction curr_attraction = null;

        for (Attraction attraction : attractions)
        {
            if (attractionID == attraction.getAttractionID())
            {
                curr_attraction = attraction;
                break;
            }
        }

        if (curr_attraction == null)
        {
            System.out.println("Invalid Attraction ID!\n");
        }

        else
        {
            String status;
            int price;

            scanner.nextLine(); //consume newline character
            System.out.print("Enter new Attraction Status (Open/Closed): ");
            status = scanner.nextLine();
            System.out.print("Enter new Attraction Price: ");
            price = scanner.nextInt();

            curr_attraction.setStatus(status);
            curr_attraction.setPrice(price);

            System.out.println("Attraction modified successfully!\n");
        }
    }

    public void setDiscounts()
    {
        int choice;

        while (true)
        {
            System.out.print("""
                    1. Add Discount
                    2. View Discounts
                    3. Modify Discount
                    4. Remove Discount
                    5. Exit
                                        
                    Enter your choice:
                    """);

            choice = scanner.nextInt();

            if (choice == 1)
            {
                String discountCategory;
                String discountCode;
                int discountPercentage;

                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter Discount Category: ");
                discountCategory = scanner.nextLine();

                System.out.print("Enter Discount Code: ");
                discountCode = scanner.nextLine();

                System.out.print("Enter Discount Percentage (e.g., 20 for 20%): ");
                discountPercentage = scanner.nextInt();

                Discount new_discount;

                try {
                    new_discount = new Discount(discountCode, discountCategory, discountPercentage);
                }

                catch (ArithmeticException e)
                {
                    System.out.println(e.getMessage());
                    continue;
                }

                discounts.add(new_discount);

                System.out.println("Discount added successfully!\n");
            }

            else if (choice == 2)
            {
                for (Discount discount: discounts)
                {
                    System.out.println(discount);
                }
                System.out.println("\n");
            }

            else if (choice == 3)
            {
                String discountCode;
                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter Discount Code of the discount you want to modify: ");
                discountCode = scanner.nextLine();
                Discount curr_discount = null;

                for (Discount discount : discounts)
                {
                    if (Objects.equals(discountCode, discount.getDiscountCode()))
                    {
                        curr_discount = discount;
                        break;
                    }
                }

                if (curr_discount == null)
                {
                    System.out.println("Invalid Discount Code!\n");
                }

                else
                {
                    String discountCategory;
                    int discountPercentage;

                    System.out.print("Enter new Discount Category: ");
                    discountCategory = scanner.nextLine();

                    System.out.print("Enter new Discount Percentage (e.g., 20 for 20%): ");
                    discountPercentage = scanner.nextInt();

                    curr_discount.setDiscountPercentage(discountPercentage);
                    curr_discount.setDiscountCategory(discountCategory);

                    System.out.println("Discount modified successfully!\n");
                }

            }

            else if (choice == 4)
            {
                String discountCode;
                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter Discount Code: ");
                discountCode = scanner.nextLine();
                Discount curr_discount = null;

                for (Discount discount : discounts)
                {
                    if (Objects.equals(discountCode, discount.getDiscountCode()))
                    {
                        curr_discount = discount;
                        break;
                    }
                }

                if (curr_discount == null)
                {
                    System.out.println("Invalid Discount Code!\n");
                }

                else
                {
                    discounts.remove(curr_discount);
                    System.out.println("Discount removed successfully!\n");
                }
            }

            else if (choice == 5)
            {
                return;
            }

            else
            {
                System.out.println("Please enter a number from 1 to 5!\n");
            }
        }
    }

    public void setSpecialDeals()
    {
        int choice;

        while (true)
        {
            System.out.print("""
                    1. Add Special Deal
                    2. View Special Deals
                    3. Modify Special Deals
                    4. Remove Special Deal
                    5. Exit
                                        
                    Enter your choice:
                    """);

            choice = scanner.nextInt();

            if (choice == 1)
            {
                int numTickets;
                int discountPercentage;

                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter No. of Tickets for Special Deal: ");
                numTickets = scanner.nextInt();

                System.out.print("Enter Discount Percentage (e.g., 20 for 20%): ");
                discountPercentage = scanner.nextInt();

                Special_Deal new_deal = new Special_Deal(latest_specialDeal_id, numTickets, discountPercentage);

                latest_specialDeal_id += 1;

                specialDeals.add(new_deal);

                System.out.println("Special Deal added successfully!\n");
            }

            else if (choice == 2)
            {
                for (Special_Deal deal: specialDeals)
                {
                    System.out.println(deal);
                }
                System.out.println("\n");
            }

            else if (choice == 3)
            {
                int dealID;
                System.out.println("Enter Special Deal ID of the deal you want to modify: ");
                dealID = scanner.nextInt();
                Special_Deal curr_deal = null;

                for (Special_Deal deal : specialDeals)
                {
                    if (dealID == deal.getSpecialDealID())
                    {
                        curr_deal = deal;
                        break;
                    }
                }

                if (curr_deal == null)
                {
                    System.out.println("Invalid Special Deal ID!\n");
                }

                else
                {
                    int numTickets;
                    int discountPercentage;

                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter new No. of Tickets for Special Deal: ");
                    numTickets = scanner.nextInt();

                    System.out.print("Enter new Discount Percentage (e.g., 20 for 20%): ");
                    discountPercentage = scanner.nextInt();

                    curr_deal.setDiscountPercentage(discountPercentage);
                    curr_deal.setNumTickets(numTickets);

                    System.out.println("Special Deal modified successfully!\n");
                }

            }

            else if (choice == 4)
            {
                int dealID;
                System.out.print("Enter Special Deal ID: ");
                dealID = scanner.nextInt();
                Special_Deal curr_deal = null;

                for (Special_Deal deal : specialDeals)
                {
                    if (dealID == deal.getSpecialDealID())
                    {
                        curr_deal = deal;
                        break;
                    }
                }

                if (curr_deal == null)
                {
                    System.out.println("Invalid Special Deal ID!\n");
                }

                else
                {
                    specialDeals.remove(curr_deal);
                    System.out.println("Special Deal removed successfully!\n");
                }
            }

            else if (choice == 5)
            {
                return;
            }

            else
            {
                System.out.println("Please enter a number from 1 to 5!\n");
            }
        }
    }

    public void viewVisitorStats()
    {
        System.out.println("Visitor Statistics: ");
        System.out.println("- Total Visitors: " + total_visitors);
        System.out.println("- Total Revenue: " + total_revenue);
        System.out.print("- Most Popular Attraction: ");

        try {
            Zoo.getMost_popular_attraction();
            System.out.println(most_popular_attraction.getAttractionType());
        }

        catch (Exception e)
        {
            System.out.println("No attractions in the zoo yet.");
        }
    }

    public void viewFeedback()
    {
        System.out.println("Feedback: ");

        for (String feedback: feedback)
        {
            System.out.println(feedback);
        }

        System.out.println("\n");
    }
}
