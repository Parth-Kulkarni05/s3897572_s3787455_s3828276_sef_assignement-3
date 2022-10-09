// EXPLANATION OF CLASS AND SEQUENCE DIAGRAM IMPLEMENTATION:
    // Customer has a makeQuery method, as well as cancelEvent as seen on class diagram

import java.util.Scanner;

public class Customer extends potentialCustomer {
    private String eventID;
    // Constructor
    Customer (String eventId) {
        this.eventID = eventId; // Sets the customer's eventID. This is essentially the customer_id
    }

    public Query makeQuery() {
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Enter your name: ");
        String name = scnr.nextLine();
        System.out.println("Enter your query: ");
        String query = scnr.nextLine();

        Query pC_query = new Query(eventID, name , query); // Make query object from input, then return this obj so it can be passed to eventmgr
        return pC_query;
    }

    public void eventCancel(Event event) { // Call the cancel method in event
        event.cancel();
    }
    
}
  