import java.sql.Date;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList; 

public class Main {
    public static void main(String[] args) throws ParseException {

        // ----------------- Initialize relevant class objects ----------------- \\
        FinanceManager financeMgr = new FinanceManager("default", "financeManager", "admin123", "Finance Manager"); // Creates finance manager object, so we can then also get the package object from it, since it's the one creating it
        Query query = new Query(null, 0, null, null);


        ArrayList<String> menu = new ArrayList<String>();
        menu.add("beef stew");
        menu.add("pancakes");
        menu.add("ice cream");

        FoodMenu regMenu = new FoodMenu("regular", menu , 200);


        // ----------------- Get base user selections, loop until user selects exit ----------------- \\
        String userInp = "";
        Scanner scnr = new Scanner(System.in);
        while (!userInp.equals("6") && !userInp.equals("0")) {
            System.out.println("\n\nWelcome. Your options are:");
            System.out.print(
            "1. Make Booking\n"
            + "2. Make query\n"
            + "3. Venue inspection\n"
            + "4. Login with eventID\n"
            + "5. Manager login\n"
            + "6. Exit\n"
            + "Please enter your choice (select number): "
            );

            userInp = scnr.nextLine();
            System.out.println();

        // ----------------- Check which option selected, call relevant class  ----------------- \\
            if (userInp.equals("1")){ // Making a booking
                potentialCustomerBookingProcess(financeMgr, regMenu);
            }
            else if (userInp.equals("2")) { // Potential customer make query
                potentialCustomer p_customer = new potentialCustomer();
                query = p_customer.makeQuery();
            }
            else if (userInp.equals("3")) { // Venue inspection
                System.out.println("Please enter venue name: ");
                String venueName = scnr.nextLine();

            }
            else if (userInp.equals("4")) { 
                System.out.println("Please enter your event id: ");
                String eventID = scnr.nextLine();
            }
            else if (userInp.equals("5")) {
                managerLogin(userInp, financeMgr, query);
            }
            else if (userInp.equals("6")){
               break;
            }

            System.out.print("Operation Complete. Select next action (0 = EXIT, 1 = SHOW ALL OPTIONS AGAIN): ");
            userInp = scnr.nextLine();
        }
    }   


    public static void managerLogin(String userInp, FinanceManager financeMgr, Query query){ //This method is called to handle event manager logins. customer query and financemgr objects are passed in for use

        // ----------------- Get manager login info  ----------------- \\
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter Username: ");
        
        String userName = scnr.nextLine();
        System.out.println();

        System.out.print("Enter Password: ");
        String password = scnr.nextLine();
        System.out.println();

        // ----------------- Check login credentials & log in if match  ----------------- \\
        if (userName.equals("eventManager")  && password.equals("admin123")) { // If the manager is an eventmanager
            // Creating new eventManager object and logging it in
            EventManager eventmanager = new EventManager(userInp, userName, password, "Event Manager");
            eventmanager.logIn(userName, password);
            eventmanager.getOptions(query, userName);
        }
        else if (userName.equals("financeManager")  && password.equals("admin123")) { // Finance Manager section
            System.out.printf("\nWelcome " + userName + ". Your options are: \n");
            financeMgr.getOptions();
        }
        else if (userName.equals("logisticManager")  && password.equals("admin123")) {
        
        }
        else if (userName.equals("caterer")  && password.equals("admin123")) {


            
        }
    }
    


    public static void potentialCustomerBookingProcess(FinanceManager financeMgr, FoodMenu regMenu) throws ParseException{

           Scanner scnr = new Scanner(System.in);

            int amount = 0;

            //NOTE: I have made the package object be declared by the finance manager (gets returned by the fin manager, and set to package1)
            Packages package1 = financeMgr.getPackages();
            package1.displayPackages();

            HashMap<String, String> packageInfo = package1.setPackage();

            // Passing information from package to venue... 

            // But not able to retrieve that information from venue.... 

            // unless we make getter methods within venue, but then event expects the constructor....


            Venue venue = new Venue(packageInfo.get("name"), Float.parseFloat(packageInfo.get("priceRange")), Integer.parseInt(packageInfo.get("maxNumberofGuests")));

            venue.displayVenues(Integer.parseInt(packageInfo.get("choice")));

            venue.setVenue();



            System.out.println("Do you want to Add Optional Services To The Order? Type yes or no");

            String response = scnr.nextLine();

            // Food Menu has already been initalised above. 

            if (response.equals("yes")){

                Music music = new Music("Mexican Band", 200.00f);

                FlowerDecoration flowerDecoration = new FlowerDecoration("Yellow Flower Service", 500.00f, "Pick-up");

                amount = amount + 200 + 500;

                amount = amount + 1000;

                Payment payment = new Payment();

                payment.getDetails(amount);

                payment.issueInvoice();

                Event event = new Event("1234", "5/10/2022", 65, venue, regMenu, music, flowerDecoration);

            }

            amount = amount + 1000;

            Payment payment = new Payment();

            payment.getDetails(amount);

            payment.issueInvoice();
  
            Event event = new Event("1234", "5/10/2022", 65, venue, regMenu, null , null);


            }

    }





