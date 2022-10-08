import java.util.Scanner;

public class Customer extends potentialCustomer {
    private String eventID;
    // Constructor
    Customer (String eventId) {
        this.eventID = eventId;
    }

    public Query makeQuery() {
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Enter your name: ");
        String name = scnr.nextLine();
        System.out.println("Enter your query: ");
        String query = scnr.nextLine();

        Query pC_query = new Query(eventID, name , query); // Make query object from input, then return this
        return pC_query;
    }

    public void eventCancel(Event event) {
        event.cancel();
    }
    
}
  