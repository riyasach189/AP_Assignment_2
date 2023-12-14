Assumptions:

Zoo
- class that contains all lists
- instantiated in the main class
- constructor automatically adds 3 attractions, 3 discount types, 2 special deals and 6 animals to the zoo which can be modified by admin later
- Animal/Discount/Deal/Attraction IDs can be seen by the 'View Animals/Discounts/Deals/Attractions' option
- Total Visitors shows the no. of visitors registered in the zoo, even if they have not visited any attraction or animal or purchased membership

Admin
- username: admin
- password: admin123
- 'Schedule event' lets admin change the open/closed status and price of attractions

Attraction
- Attraction status (Open/Closed) is case-sensitive. Changing the capital/small letters might lead to unexpected behaviour
- The number of ticketed visitors is incremented even if a Premium member visits the attraction, because the popularity of an attraction is gauged by its ticketed visitors. An attraction is deemed popular even if it is visited by Premium members

Discount
- Discount percentage cannot be more than 100
- Discount category is case-sensitive. Changing the capital/small letters might lead to unexpected behaviour

Visitor
- Visitors must specify their discount category at the time of registration (case-sensitive)
- Discount categories Minor and Senior Citizen are only applied if visitor lies in the required age bracket
- Visitors need to purchase at least basic membership to access anything inside the zoo
- Basic membership costs Rs.20
- Premium membership costs Rs.50
- Discount is given only when Discount Code matches Discount Category of the visitor (all case-sensitive)
- Premium members cannot buy tickets to attractions
- Multiple discounts are not supported

Main
- 'View Special Deals' option shows both special deals and discounts

HOME_FOLDER = AP_Assignment_2
All the commands should be run on the terminal in the HOME_FOLDER unless otherwise specified.

0) Download the src code folder from Classroom and unzip
1) Open the terminal in the folder "AP_Assignment_2" or cd into that folder. Please open terminal in the innermost folder "AP_Assignment_2", not the outer one that is created when we extract a zipped file.
2) mvn clean
3) mvn compile
4) mvn package
5) cd into the target folder
6) java -jar AP_Assignment_2-1.0.jar (or type java -jar and press tab key to autofill)
7) interact with the program when it asks for prompts