// EXPLANATION OF CLASS AND SEQUENCE DIAGRAM IMPLEMENTATION:
    // Potential customer has a makeQuery method, which then creates a new query object as is represented on the class diagram.

import java.util.Scanner; 

public class potentialCustomer {

    public Query makeQuery() { // Potential customer makes a query
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Enter your name: ");
        String name = scnr.nextLine();
        System.out.println("Enter your phone number: ");
        int phone = Integer.parseInt(scnr.nextLine()); // This is a workaround for a bug where having a nextLine() after a nextInt() will skip the nextLine() input 
        System.out.println("Enter your email: ");
        String email = scnr.nextLine();
        System.out.println("Enter your query: ");
        String query = scnr.nextLine();

        Query pC_query = new Query(name, phone, email, query); // Make query object from input, then return this
        return pC_query;
    }

}
