package org.example;

import java.util.Objects;
import java.util.Scanner;

import static org.example.Zoo.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();
        int choice = 0;

        System.out.println("Welcome to ZOOtopia!\n");

        while(true) {
            System.out.print("""
                    1. Enter as Admin
                    2. Enter as a Visitor
                    3. View Special Deals
                    4. Leave ZOOtopia
                                        
                    Enter your choice:
                    """);

            choice = scanner.nextInt();

            if (choice == 1) {
                String username;
                String password;

                System.out.print("Enter Admin Username: ");
                username = scanner.next();
                System.out.print("Enter Admin Password: ");
                password = scanner.next();

                Admin admin;

                try {
                    admin = new Admin(username, password);
                } catch (IncorrectPasswordException e) {
                    System.out.println(e.getMessage() + "\n");
                    continue;
                }

                System.out.println("Logged in as Admin.\n");

                while (true) {
                    System.out.print("""
                            Admin Menu:
                            1. Manage Attractions
                            2. Manage Animals
                            3. Schedule Events
                            4. Set Discounts
                            5. Set Special Deal
                            6. View Visitor Stats
                            7. View Feedback
                            8. Exit
                                                    
                            Enter your choice:\s
                            """);

                    choice = scanner.nextInt();

                    if (choice == 1) {
                        admin.manageAttractions();
                    }

                    else if (choice == 2) {
                        admin.manageAnimals();
                    }

                    else if (choice == 3) {
                        admin.scheduleEvents();

                    }

                    else if (choice == 4) {
                        admin.setDiscounts();

                    }

                    else if (choice == 5) {
                        admin.setSpecialDeals();

                    }

                    else if (choice == 6) {
                        admin.viewVisitorStats();

                    }

                    else if (choice == 7) {
                        admin.viewFeedback();

                    }

                    else if (choice == 8) {
                        System.out.println("Logged out.\n");
                        break;
                    }

                    else {
                        System.out.println("Please enter a number from 1 to 8!\n");
                    }
                }

            }

            else if (choice == 2) {
                boolean logout = false;

                while (!logout) {
                    System.out.print("""
                            1. Register
                            2. Login
                                                
                            Enter your choice:
                            """);

                    choice = scanner.nextInt();

                    if (choice == 1) {
                        String name;
                        int age;
                        int phoneNumber;
                        int balance;
                        String email;
                        String password;
                        String category;

                        scanner.nextLine();  //consumes new line character
                        System.out.print("Enter Visitor Name: ");
                        name = scanner.nextLine();
                        System.out.print("Enter Visitor Email: ");
                        email = scanner.nextLine();
                        System.out.print("Enter Visitor Password: ");
                        password = scanner.nextLine();
                        System.out.print("Enter Visitor Age: ");
                        age = scanner.nextInt();
                        System.out.print("Enter Visitor Phone Number: ");
                        phoneNumber = scanner.nextInt();
                        System.out.print("Enter Visitor Balance: ");
                        balance = scanner.nextInt();

                        System.out.println("ZOOtopia may offer discounts for people of the following categories: ");
                        for (Discount discount: discounts)
                        {
                            System.out.println(discount.getDiscountCategory());
                        }

                        System.out.print("Enter the category that applies to you (case sensitive): ");
                        scanner.nextLine(); //consumes the newline character
                        category = scanner.nextLine();

                        Visitor visitor = new Visitor(name, age, phoneNumber, balance, email, password, category);
                        visitors.add(visitor);
                        total_visitors += 1;

                        System.out.println("Registration successful.\n");

                    }

                    else if (choice == 2) {

                        String email;
                        String password;

                        scanner.nextLine();  //consumes new line character
                        System.out.print("Enter Visitor Email: ");
                        email = scanner.nextLine();
                        System.out.print("Enter Visitor Password: ");
                        password = scanner.nextLine();

                        Visitor curr_visitor = null;

                        for (Visitor visitor : visitors) {
                            if (Objects.equals(visitor.getEmail(), email)) {
                                try {
                                    visitor.login(email, password);
                                } catch (IncorrectPasswordException e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }

                                curr_visitor = visitor;
                                System.out.println("Login successful.\n");
                            }
                        }

                        if (curr_visitor != null) {
                            while (true) {
                                System.out.print("""
                                        1. Explore the Zoo
                                        2. Buy Membership
                                        3. Buy Tickets
                                        4. View Discounts
                                        5. Apply Special Deals
                                        6. Visit Animals
                                        7. Visit Attractions
                                        8. Leave Feedback
                                        9. Log Out
                                                                         
                                        Enter your choice:
                                        """);

                                choice = scanner.nextInt();

                                if (choice == 1) {
                                    curr_visitor.exploreZoo();

                                }

                                else if (choice == 2) {
                                    curr_visitor.buyMembership();

                                }

                                else if (choice == 3) {
                                    curr_visitor.buyTickets();

                                }

                                else if (choice == 4) {
                                    curr_visitor.viewDiscounts();

                                }

                                else if (choice == 5) {
                                    curr_visitor.applySpecialDeals();

                                }

                                else if (choice == 6) {
                                    curr_visitor.visitAnimals();

                                }

                                else if (choice == 7) {
                                    curr_visitor.visitAttractions();

                                }

                                else if (choice == 8) {
                                    curr_visitor.leaveFeedback();

                                }

                                else if (choice == 9) {
                                    logout = true;
                                    System.out.println("Logged out.\n");
                                    break;
                                }

                                else
                                {
                                    System.out.println("Please enter a number from 1 to 9!\n");
                                }
                            }
                        }

                        else
                        {
                            System.out.println("Visitor record does not exist!\n");
                            break;
                        }
                    }

                    else {
                    System.out.println("Please enter either 1 or 2!\n");
                }
            }


            }

            else if (choice == 3)
            {
                System.out.println("Discounts: ");

                for (Discount discount: discounts)
                {
                    System.out.println(discount);
                }

                System.out.println("\n");

                System.out.println("Special Deals: ");

                for (Special_Deal special_deal: specialDeals)
                {
                    System.out.println(special_deal);
                }

                System.out.println("\n");
            }

            else if (choice == 4)
            {
                System.out.println("Thanks for visiting!\n");
                break;
            }

            else
            {
                System.out.println("Please enter a number from 1 to 4!\n");
            }
        }
    }
}