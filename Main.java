import java.sql.Date;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParseException {

        // ----------------- Initialize relevant class objects ----------------- \\
        // Creates finance manager object, so we can then also get the package object from it, since it's the one creating it
        FinanceManager financeMgr = new FinanceManager("default", "financeManager", "admin123", "Finance Manager");
        // Initialize query object to be empty. This is updated to an actual query if customer makes one. 
        Query query = new Query(null, 0, null, null); 

        // Menu object
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("beef stew");
        menu.add("pancakes");
        menu.add("ice cream");

        FoodMenu regMenu = new FoodMenu("regular", menu , 200);


        // First, we need to init some dummy objects, since they aren't being returned correctly from their respective classes
        Venue dummyVenue = new Venue("DummyVenue", 1000, 80); // Dummy venue object
        Music dummyMusic = new Music("Rock band", 300);
        FlowerDecoration dummyFDecoration = new FlowerDecoration("Colourful Flowers", 140, "Pickup");
        Event dummyEvent = new Event("dummyEvent124", "11/10/2022", 32, dummyVenue, regMenu, dummyMusic, dummyFDecoration); // Since the eventobject created after customer payment is not returned, we are using a dummy event

        // ----------------- Get base user selections, loop until user selects exit ----------------- \\
        String userInp = "";
        Scanner scnr = new Scanner(System.in);
        while (!userInp.equals("6") && !userInp.equals("0")) {
            System.out.println("\n\nWelcome. Your options are:");
            System.out.print(
            "1. Make Booking\n"
            + "2. Make query\n"
            + "3. Make a Physical Venue Inspection\n"
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
                VenueInspection venueInspection = new VenueInspection();

                venueInspection.getCustomerDetails();

                venueInspection.bookDate();

                venueInspection.bookTime();
            }
            else if (userInp.equals("4")) {  // Login with eventID
                System.out.println("Please enter your event id: ");
                String eventID = scnr.nextLine();
                
                Customer customer = new Customer(eventID);
                String userSelect = "";
                
                System.out.println("Welcome, you are logged in with EventID: " + eventID + ". Please select an option:");
                while (!userSelect.equals("5") && !userSelect.equals("0")) {
                    System.out.print(
                        "1. Make Query\n"
                        + "2. Make Complaint\n"
                        + "3. Request Event Changes\n"
                        + "4. Request Event Cancellation\n"
                        + "5. Exit\n"
                        + "Please enter your choice (select number): "
                        );
                        userSelect = scnr.nextLine();

                        if (userSelect.equals("1") | userSelect.equals("2") | userSelect.equals("3")) {
                            query = customer.makeQuery();
                        } 
                        else if (userSelect.equals("4")) {

                            String curr_date = "10/10/2022";

                            Cancellation cancel = new Cancellation();

                            cancel.cancel(dummyEvent.getCost(),curr_date, dummyEvent.getDateTime());

                            customer.eventCancel(dummyEvent);
                        }
                        System.out.print("Operation Complete. Select next action (0 = LOG OUT, 1 = SHOW CUSTOMER OPTIONS AGAIN): ");
                        userSelect = scnr.nextLine();
                    }
            }
            else if (userInp.equals("5")) { // Manager login
                managerLogin(userInp, financeMgr, query, regMenu, dummyVenue, dummyEvent);
            }
            else if (userInp.equals("6")){ // Exit
               break;
            }

            System.out.print("Operation Complete. Select next action (0 = EXIT, 1 = SHOW ALL OPTIONS AGAIN): ");
            userInp = scnr.nextLine();
        }
    }   


    public static void managerLogin(String userInp, FinanceManager financeMgr, Query query, FoodMenu menu, Venue dummyVenue, Event dummyEvent){ //This method is called to handle event manager logins. customer query and financemgr objects are passed in for use

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
            eventmanager.getOptions(query, userName, dummyEvent, dummyVenue);
        }
        else if (userName.equals("financeManager")  && password.equals("admin123")) { // Finance Manager section
            System.out.printf("\nWelcome " + userName + ". Your options are: \n");
            financeMgr.logIn(userName, password);
            financeMgr.getOptions();
        }
        else if (userName.equals("logisticManager")  && password.equals("admin123")) {
            LogisticManager lManager = new LogisticManager(userInp, userName, password, "Logistic Manager");
            lManager.logIn(userName, password);
            lManager.getOptions(dummyEvent);
        }
        else if (userName.equals("caterer")  && password.equals("admin123")) {
            Caterer caterer = new Caterer(userInp, userName, password, "Caterer");
            caterer.logIn(userName, password);
            caterer.getOptions(dummyEvent);
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

                Event event = new Event("1234", "5/10/2022", venue.getNumberOfGuest(), venue, regMenu, music, flowerDecoration);

            }
            else {
                amount = amount + 1000;

                Payment payment = new Payment();
    
                payment.getDetails(amount);
    
                payment.issueInvoice();
      
                Event event = new Event("1234", "5/10/2022", venue.getNumberOfGuest(), venue, regMenu, null , null);
            }

        }
    
    



    }
