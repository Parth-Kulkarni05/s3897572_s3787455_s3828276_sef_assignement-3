import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList; 

public class Main {
    public static void main(String[] args) throws ParseException {
        // Menu
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("beef stew");
        menu.add("pancakes");
        menu.add("ice cream");
        FoodMenu regMenu = new FoodMenu("regular", menu , 200);

        menu.set(0, "Vegetable Stew");
        FoodMenu vegMenu = new FoodMenu("vegetarian", null, 150);

        // 
        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome. Your options are:");
        System.out.print(
        "1. Make Booking\n"
        + "2. Make query\n"
        + "3. Venue inspection\n"
        + "4. Login with eventID\n"
        + "5. Manager login\n"
        + "Please enter your choice (select number): "
        );

        String userInp = scnr.nextLine();
        System.out.println();


        if (userInp.equals("1")){ // Making a booking

            potentialCustomerBookingProcess();

        }
        else if (userInp.equals("2")) { // Potential customer make query
            potentialCustomer p_customer = new potentialCustomer();
            Query pC_query = p_customer.makeQuery();
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
            managerLogin(userInp);
        }

        else if (userInp.equals("1")){
            potentialCustomerBookingProcess();

        }

    }   


    public static void managerLogin(String userInp){ //This method is called to handle event manager logins
        // Getting user input
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter Username: ");
        
        String userName = scnr.nextLine();
        System.out.println();

        System.out.print("Enter Password: ");
        String password = scnr.nextLine();
        System.out.println();

        
        if (userName.equals("eventManager")  && password.equals("admin123")) { // If the manager is an eventmanager
            // Creating new eventManager object and logging it in
            EventManager manager1 = new EventManager(userInp, userName, password, "Event Manager");
            manager1.logIn(userName, password);

            System.out.printf("\nWelcome " + userName + ". Your options are: \n");
            manager1.getOptions(); // Call eventmanager class getoptions() method to display the things it can do
            String userSelect = scnr.nextLine();
            System.out.println();
            
            
            if (userSelect.equals("1")) { // View customer query
                // Dummy query, this should really be created in the customer method and then passed to this method
                Query query1 = new Query(userName, 043212, "test@gmail", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam varius maximus feugiat. Aliquam pulvinar augue ut eros placerat ultrices in at risus. Cras tristique nunc in lobortis tempus. Suspendisse potenti. Sed maximus est eu urna vestibulum, at lacinia eros varius. Phasellus in nibh tortor. Pellentesque blandit nibh vel fringilla auctor."); 
                query1.getQuery();
            }
            else if (userSelect.equals("4")) { // Logs the manager out if that option is selected
                manager1.logOut();
            }

            else if (userName.equals("financeManager")  && password.equals("admin123")) {
                
            }
            else if (userName.equals("logisticManager")  && password.equals("admin123")) {
            

            }
            else if (userName.equals("caterer")  && password.equals("admin123")) {
                
            
            }

        }
    }
    


    public static void potentialCustomerBookingProcess() throws ParseException{

           Scanner scnr = new Scanner(System.in);

            int amount = 0;

            Packages package1 = new Packages(); // No constructor in there as of now 
            
            package1.displayPackages();

            HashMap<String, String> packageInfo = package1.setPackage();


            Venue venue = new Venue(packageInfo.get("name"), Float.parseFloat(packageInfo.get("priceRange")), Integer.parseInt(packageInfo.get("maxNumberofGuests")));

            venue.displayVenues(Integer.parseInt(packageInfo.get("choice")));

            venue.setVenue();


            System.out.println("Do you want to Add Optional Services To The Order? Type yes or no");

            String response = scnr.nextLine();


            if (response.equals("yes")){

                Music music = new Music("Mexican Band", 200.00f);

                FlowerDecoration flowerDecoration = new FlowerDecoration("Yellow Flower Service", 500.00f, "Pick-up");

                amount = amount + 200 + 500;


            }

            amount = amount + 1000;


            Payment payment = new Payment();

            payment.getDetails(amount);

            payment.issueInvoice();


          //  Event event = new Event(response, null, amount, venue, null)


    }

}



