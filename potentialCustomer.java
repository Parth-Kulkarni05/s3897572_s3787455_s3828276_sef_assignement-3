import java.util.Scanner; 

public class potentialCustomer {
    public static void makeQuery() {
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Enter your name: ");
        String name = scnr.nextLine();
        System.out.println("Enter your name: ");
        int phone = scnr.nextInt();
        System.out.println("Enter your email: ");
        String email = scnr.nextLine();
        System.out.println("Enter your query: ");
        String query = scnr.nextLine();

        Query query1 = new Query(name, phone, email, query);
        
    }
}
