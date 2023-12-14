package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static org.example.Zoo.*;

public class Visitor {
    private final String name;
    private final int age;
    private final int phoneNumber;
    private int balance;
    private final String email;
    private final String password;
    private String membershipStatus;
    private String category = "None";
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    Scanner scanner = new Scanner(System.in);

    public Visitor(String name, int age, int phoneNumber, int balance, String email, String password, String category) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.membershipStatus = "None";

        if (Objects.equals(category, "Minor") & age < 18)
        {
            this.category = "Minor";
        }

        else if (Objects.equals(category, "Senior Citizen") & age > 60)
        {
            this.category = "Senior Citizen";
        }

        else if (!Objects.equals(category, "Minor") & !Objects.equals(category, "Senior Citizen"))
        {
            this.category = category;
        }

        else
        {
            this.category = "None";
        }

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //methods
    public void login(String email, String password) throws IncorrectPasswordException {
        if ((!Objects.equals(this.email, email)) | (!Objects.equals(this.password, password)))
        {
            throw new IncorrectPasswordException("Incorrect email or password!");
        }
    }

    public void exploreZoo()
    {
        if (Objects.equals(this.membershipStatus, "None"))
        {
            System.out.println("Please purchase membership to enter the Zoo.");
            return;
        }

        int choice;

        while (true) {
            System.out.print("""
                    1. View Attractions
                    2. View Animals
                    3. Exit
                                        
                    Enter your choice:
                    """);

            choice = scanner.nextInt();

            if (choice == 1)
            {
                for (Attraction attraction: attractions)
                {
                    System.out.println(attraction);
                }
                System.out.println("\n");
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
                return;
            }

            else
            {
                System.out.println("Please enter a number from 1 to 3!\n");
            }
        }
    }

    public void buyMembership()
    {
        int discountPercentage = 0;
        int amount;
        int choice;
        int price;
        String discountCode;

        System.out.print("""
                1. Basic membership (Rs.20)
                2. Premium membership (Rs.50)
                             
                Enter your choice:
                """);

        choice = scanner.nextInt();

        if (choice == 1)
        {
            price = 20;
        }

        else if (choice == 2)
        {
            price = 50;
        }

        else
        {
            System.out.println("Invalid option!");
            return;
        }


        System.out.println("Your discount category is " + category);

        System.out.print("Please enter the discount code (case sensitive): ");
        scanner.nextLine();
        discountCode = scanner.nextLine();

        for (Discount discount : discounts)
        {
            if (Objects.equals(discount.getDiscountCode(), discountCode))
            {
                if (Objects.equals(discount.getDiscountCategory(), this.category)) {
                    discountPercentage = discount.getDiscountPercentage();
                    break;
                }
            }
        }

        if (discountPercentage != 0)
        {
            System.out.println("Discount code validated!");
        }

        else
        {
            System.out.println("This discount does not apply to you or has been removed.");
            System.out.println("You may have entered an incorrect discount code.");
        }

        System.out.println("A discount of " + discountPercentage + "% will be applied.");

        amount = (price-(price*discountPercentage/100));

        System.out.println("Amount to be paid is Rs." + amount);
        System.out.println("Press 1 to cancel transaction or any other number to continue.");

        choice = scanner.nextInt();

        if (choice == 1)
        {
            System.out.println("Transaction cancelled. Your balance is " + balance);
        }

        else if (amount > balance)
        {
            System.out.println("Transaction cancelled. Your balance is insufficient.");
        }

        else
        {
            balance = balance - amount;
            total_revenue += amount;

            if (price == 20)
            {
                membershipStatus = "Basic";
            }

            else {
                membershipStatus = "Premium";
            }

            System.out.println("Transaction successful. Your balance is " + balance);
        }

    }

    public void buyTickets() {

        if (Objects.equals(this.membershipStatus, "None"))
        {
            System.out.println("Please purchase membership to enter the Zoo.");
            return;
        }

        if (Objects.equals(this.membershipStatus, "Premium"))
        {
            System.out.println("Premium members don't need to purchase tickets to attractions.");
            return;
        }

        int attractionID;

        System.out.println("Attractions: ");
        for (Attraction attraction: attractions)
        {
            System.out.println(attraction);
        }
        System.out.println("\n");

        System.out.println("Enter AttractionID whose tickets you want to buy: ");
        attractionID = scanner.nextInt();

        Attraction curr_attraction = null;

        for (Attraction attraction: attractions)
        {
            if (attractionID == attraction.getAttractionID())
            {
                curr_attraction = attraction;
                break;
            }
        }

        if (curr_attraction == null)
        {
            System.out.println("Invalid Attraction ID!");
        }

        else
        {
            int discountPercentage = 0;
            int amount;
            int choice;
            int price = curr_attraction.getPrice();
            String discountCode;

            System.out.println("The price of this attraction is Rs." + price);
            System.out.println("Your discount category is " + category);

            System.out.print("Please enter the discount code (case sensitive): ");
            discountCode = scanner.nextLine();

            for (Discount discount : discounts)
            {
                if (Objects.equals(discount.getDiscountCode(), discountCode))
                {
                    if (Objects.equals(discount.getDiscountCategory(), this.category)) {
                        discountPercentage = discount.getDiscountPercentage();
                        break;
                    }
                }
            }

            if (discountPercentage != 0)
            {
                System.out.println("Discount code validated!");
            }

            else
            {
                System.out.println("This discount does not apply to you or has been removed.");
                System.out.println("You may have entered an incorrect discount code.");
            }

            System.out.println("A discount of " + discountPercentage + "% will be applied.");

            amount = (price-(price*discountPercentage/100));

            System.out.println("Amount to be paid is Rs." + amount);
            System.out.println("Press 1 to cancel transaction or any other number to continue.");

            choice = scanner.nextInt();

            if (choice == 1)
            {
                System.out.println("Transaction cancelled. Your balance is " + balance);
            }

            else if (amount > balance)
            {
                System.out.println("Transaction cancelled. Your balance is insufficient.");
            }

            else
            {
                balance = balance - amount;
                total_revenue += amount;
                Ticket ticket = new Ticket(curr_attraction);
                tickets.add(ticket);
                System.out.println("Transaction successful. Your balance is " + balance);
            }
        }

    }

    public void viewDiscounts()
    {
        System.out.println("Discounts: ");

        for (Discount discount: discounts)
        {
            System.out.println(discount);
        }

        System.out.println("\n");
    }

    public void applySpecialDeals()
    {
        if (Objects.equals(this.membershipStatus, "None"))
        {
            System.out.println("Please purchase membership to enter the Zoo.");
            return;
        }

        if (Objects.equals(this.membershipStatus, "Premium"))
        {
            System.out.println("Premium members don't need to purchase tickets to attractions.");
            return;
        }

        int dealID;
        int attractionID;
        Special_Deal curr_deal = null;
        Attraction curr_attraction = null;

        System.out.println("Special Deals: ");

        for (Special_Deal deal: specialDeals)
        {
            System.out.println(deal);
        }

        System.out.println("\n");

        System.out.print("Enter the DealID of the deal you want to apply: ");
        dealID = scanner.nextInt();

        for (Special_Deal deal: specialDeals)
        {
            if (dealID == deal.getSpecialDealID())
            {
                curr_deal = deal;
                break;
            }
        }

        if (curr_deal == null)
        {
            System.out.println("Invalid DealID!");
        }

        else
        {
            System.out.println("Attractions: ");

            for (Attraction attraction: attractions)
            {
                System.out.println(attraction);
            }

            System.out.print("Enter the Attraction ID of the attraction whose tickets you wish to purchase: ");
            attractionID = scanner.nextInt();

            for (Attraction attraction: attractions)
            {
                if (attractionID == attraction.getAttractionID())
                {
                    curr_attraction = attraction;
                    break;
                }
            }

            if (curr_attraction == null)
            {
                System.out.println("Invalid AttractionID!");
            }

            else
            {
                int amount = curr_deal.getNumTickets() * curr_attraction.getPrice();
                amount -= amount * curr_deal.getDiscountPercentage()/ 100;

                System.out.println("Amount to be paid is Rs." + amount + " for " + curr_deal.getNumTickets() + " tickets.");
                System.out.println("Press 1 to cancel transaction or any number to continue.");

                int choice = scanner.nextInt();

                if (choice == 1)
                {
                    System.out.println("Transaction cancelled. Your balance is " + balance);
                }

                else if (amount > balance)
                {
                    System.out.println("Transaction cancelled. Your balance is insufficient.");
                }

                else
                {
                    balance = balance - amount;
                    total_revenue += amount;

                    for (int i = 0; i < curr_deal.getNumTickets(); i++)
                    {
                        Ticket ticket = new Ticket(curr_attraction);
                        tickets.add(ticket);
                    }

                    System.out.println("Transaction successful. Your balance is " + balance);
                }
            }

        }
    }

    public void visitAnimals()
    {
        if (Objects.equals(this.membershipStatus, "None"))
        {
            System.out.println("Please purchase membership to enter the Zoo.");
            return;
        }

        int animalID;
        Animal curr_animal = null;

        System.out.println("Animals: ");

        for (Animal animal: animals)
        {
            System.out.println(animal);
        }

        System.out.println("\n");

        System.out.print("Enter the Animal ID of the animal you want to visit: ");
        animalID = scanner.nextInt();

        for (Animal animal: animals)
        {
            if (animalID == animal.getAnimalID())
            {
                curr_animal = animal;
                break;
            }
        }

        if (curr_animal == null)
        {
            System.out.println("Invalid Animal ID!");
        }

        else
        {
            int choice;

            System.out.print("""
                    1. Feed animal
                    2. Read about animal
                                        
                    Enter your choice:
                    """);
            choice = scanner.nextInt();

            if (choice == 1)
            {
                curr_animal.feed();
            }

            else if (choice == 2)
            {
                curr_animal.read();
            }

            else
            {
                System.out.println("Invalid operation!");
            }

        }
    }

    public void visitAttractions()
    {
        if (Objects.equals(this.membershipStatus, "None"))
        {
            System.out.println("Please purchase membership to enter the Zoo.");
            return;
        }

        int attractionID;

        System.out.println("Attractions: ");
        for (Attraction attraction: attractions)
        {
            System.out.println(attraction);
        }
        System.out.println("\n");

        System.out.println("Enter AttractionID of the attraction you want ot visit: ");
        attractionID = scanner.nextInt();

        Attraction curr_attraction = null;

        for (Attraction attraction: attractions)
        {
            if (attractionID == attraction.getAttractionID())
            {
                curr_attraction = attraction;
                break;
            }
        }

        if (curr_attraction == null)
        {
            System.out.println("Invalid Attraction ID!");
        }

        else if (Objects.equals(curr_attraction.getStatus(), "Closed"))
        {
            System.out.println("Attraction is closed at the moment. Inconvenience is regretted.");
        }

        else if (Objects.equals(this.membershipStatus, "Premium"))
        {
            System.out.println("Welcome to " + curr_attraction.getAttractionType() + "!");
            curr_attraction.incrTicketedVisitors();
        }

        else
        {
            Ticket curr_ticket = null;

            for (Ticket ticket: this.tickets)
            {
                if (Objects.equals(curr_attraction.getAttractionType(), ticket.getAttraction().getAttractionType()))
                {
                    curr_ticket = ticket;
                    break;
                }
            }

            if (curr_ticket == null)
            {
                System.out.println("Please buy a ticket for this attraction or upgrade to Premium membership.");
            }

            else
            {
                System.out.println("Welcome to " + curr_attraction.getAttractionType() + "!");
                curr_attraction.incrTicketedVisitors();
                this.tickets.remove(curr_ticket);
            }
        }
    }

    public void leaveFeedback()
    {
        if (Objects.equals(this.membershipStatus, "None"))
        {
            System.out.println("Please purchase membership to enter the Zoo.");
            return;
        }

        String feedback;

        scanner.nextLine(); //to consume new line character
        System.out.println("Please enter your feedback: ");
        feedback = scanner.nextLine();
        System.out.println("Thank you for your feedback.");

        Zoo.feedback.add(feedback);
    }
}
