import java.util.Scanner; 

public class potentialCustomer {

    public Query makeQuery() {
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Enter your name: ");
        String name = scnr.nextLine();
        System.out.println("Enter your phone number: ");
        int phone = scnr.nextInt();
        System.out.println("Enter your email: ");
        String email = scnr.nextLine();
        System.out.println("Enter your query: ");
        String query = scnr.nextLine();

        Query pC_query = new Query(name, phone, email, query);
        scnr.close();
        return pC_query;
    }

}
