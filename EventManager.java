import java.util.Scanner;

public class EventManager extends Employee
{
    EventManager(String employeeId, String username, String password, String position) {
        super(employeeId, username, password, position);
    }
    
    public void viewQuery(Query queryobj) {
        queryobj.getQuery();
    }

    public void viewComplaint(Query queryobj) {
        queryobj.getQuery();
    }

    public void changeVenue() {
        ;
    }

    public void bookVenue() {
        
    }

    public void getOptions(Query query,  String userName) {
        Scanner scnr = new Scanner(System.in);
        String userSelect = "";
    
        System.out.printf("\nWelcome " + userName + ". Your options are: \n");
        while (!userSelect.equals("4") && !userSelect.equals("0")) { // If input is 4 (main exit) or 0 (exit after operation complete), stop while loop
            System.out.printf(
                "1. viewQuery\n"
                + "2. viewComplaint\n"
                + "3. changeVenue\n"
                + "4. exit\n"
                + "Select option: "
                );
                
                userSelect = scnr.nextLine();
                System.out.println();
                
                if (userSelect.equals("1")) { // View customer query
                    // This is the actual query made by the potential customer
                    query.getQuery();
                }
                if (userSelect.equals("2")) { // View customer complaint
                    query.getQuery();
                }
                if (userSelect.equals("3")) { // Change venue
                    ;
                }
                else if (userSelect.equals("4")) { // Logs the manager out and exits
                    this.logOut();
                    break;
                }
                System.out.print("Operation Complete. Select next action (0 = EXIT, 1 = SHOW EVENT MANAGER OPTIONS AGAIN): ");
                userSelect = scnr.nextLine();
            }
    }
    
}
