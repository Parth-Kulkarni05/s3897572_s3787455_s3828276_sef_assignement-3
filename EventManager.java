// EXPLANATION OF CLASS AND SEQUENCE DIAGRAM IMPLEMENTATION:
    // Extends employee as specified in class diagram.
    // Receives venue, event and query as input when needed.
    // As specified in 'event mgr final venue booking' sequence diagram, the class first receives the event object, then to confirm booking it calls 'venue.BookVenue' (~ line 80). 

import java.util.Scanner;

public class EventManager extends Employee{
    // Constructor
    EventManager(String employeeId, String username, String password, String position) {
        super(employeeId, username, password, position);
    }

    //Methods
    public void getOptions(Query query,  String userName, Event event, Venue venue) {
        Scanner scnr = new Scanner(System.in);
        String userSelect = "";
    
        System.out.printf("\nWelcome " + userName + ". Your options are: \n");
        while (!userSelect.equals("5") && !userSelect.equals("0")) { // If input is 4 (main exit) or 0 (exit after operation complete), stop while loop
            System.out.printf(
                "1. View Query\n"
                + "2. View Complaint\n"
                + "3. Confirm Venue Booking\n"
                + "4. Modify Event\n"
                + "5. Log Out\n"
                + "Select option: "
                );
                
                userSelect = scnr.nextLine();
                System.out.println();
                
                if (userSelect.equals("1")) { // View customer query
                    // This is the actual query made by the potential customer
                    query.getQuery();

                    System.out.print("Select an action (0 = CLOSE QUERY, 1 = RESPOND TO QUERY): ");
                    userSelect = scnr.nextLine();

                    if (userSelect.equals("1")) {
                        System.out.println("Enter response: ");
                        userSelect = scnr.nextLine();
                        query.setResponse(userSelect);

                    }
                }
                else if (userSelect.equals("2")) { // View customer complaint
                    query.getQuery();
                }
                else if (userSelect.equals("3")) { // Confirm venue
                    confirmVenue(venue, event);
                }
                else if (userSelect.equals("4")) { // Modify event
                    modifyEvent(event);
                }
                else if (userSelect.equals("5")) { // Logs the manager out and exits
                    this.logOut();
                    break;
                }
                System.out.print("Operation Complete. Select next action (0 = LOG OUT, 1 = SHOW EVENT MANAGER OPTIONS AGAIN: ");
                userSelect = scnr.nextLine();

            }
    }

    public void viewQuery(Query queryobj) { // View customer query
        queryobj.getQuery();
    }

    public void viewComplaint(Query queryobj) { // View customer complaint
        queryobj.getQuery();
    }

    public void confirmVenue(Venue venue, Event event) { // Confirm venue booking, as seen in sequence diagram
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please confirm the number of guests: ");
        String numGuests = scnr.nextLine();
        System.out.print("\nPlease confirm the booking date: ");
        String bookDate = scnr.nextLine();
        venue.bookVenue(Integer.parseInt(numGuests), bookDate);
    }

    public void modifyEvent(Event event) { // Modify event details
        Scanner scnr = new Scanner(System.in);
        System.out.println("What would you like to modify? ");
        System.out.print(
            "1. Price\n"
            + "2. Venue inspection\n"
            + "3. Event Music\n"
            + "4. Flower Decoration\n"
            + "5. Food Menu\n"
            + "6. Number of Guests\n"
            + "7. Event Date\n"
            + "Please enter your choice (select number): "
            );
            String userSelect = scnr.nextLine();

            if (userSelect.equals("1")) {
                System.out.print("Enter new price: ");
                userSelect = scnr.nextLine();
                event.changeAmount(Float.parseFloat(userSelect)); // Change event price
            } else {
                // Out of project scope to implement, first option demonstrates how it works for each.
            }
    }
    
}
