import java.text.ParseException;
import java.util.Scanner;

public class Venue {
    // field
    private String name;
    private float cost;


    private int numberOfGuest;
    private String date_venue;
    private boolean isBooked; // This is for the eventManager to confirm the booking

    // constructor
    Venue(String name, float cost, int numberOfGuest){
        this.name = name;
        this.cost = cost;
        this.numberOfGuest = numberOfGuest;
    }

    public void displayVenues(int PackageChoice){

        Scanner scnr = new Scanner(System.in);

        System.out.print("We have the following Venues tailored to your Package Selection");

        if (PackageChoice == 1){

            System.out.println("1 - The Family Plaza - Cost : $200.00");

            System.out.println("2 - The Family Venue - Cost: $350.00");

        }  

        else if (PackageChoice == 2){

            System.out.println("1 - The Party Plaza - Cost : $600.00");

            System.out.println("2 - The Party Venue - Cost: $750.00");

        }

        else{

            System.out.println("1 - The Grand Event Plaza - Cost : $1000.00");

            System.out.println("2 - The Grand Event Venue - Cost: $1199.00");
        
        }


        System.out.println("Do you want to view a virtual tour of above venues? Types yes or no (lowercase)");



        
        String virtualTourChoice = scnr.nextLine();

        if (virtualTourChoice.equals("yes")){
            VirtualTour virtual = new VirtualTour();

            System.out.println("Enter the name of Venue for Virtual Tour Link..");

            String venue_name_tour = scnr.nextLine();

            virtual.viewVirtualTour(venue_name_tour);

            System.out.println();

            System.out.println("Do you want to continue with the booking process? Types yes or no (lowercase)");

            String continue_booking = scnr.nextLine();

            if (continue_booking.equals("no")){
                System.out.println("Exiting Booking");
                System.exit(0);
            }

        }

    }

    public void setVenue() throws ParseException{

        Scanner userInput = new Scanner(System.in);

        // We have decided to set this values to default, to simplify and keeps things to point with the assignment.

        this.name = "The Grand Event Venue";
        this.cost = 1199.00f;

        System.out.println("Please enter the number of guests attending");

        String attendes = userInput.nextLine();

        int numberofAttendes = Integer.parseInt(attendes);


        while (numberofAttendes > this.numberOfGuest){
            System.out.println("Number Of Guests have to be less than " + String.valueOf(this.numberOfGuest));

            System.out.println("Please enter the number of guests attending");
            attendes = userInput.nextLine();
            numberofAttendes = Integer.parseInt(attendes);
        }

        this.numberOfGuest = numberofAttendes; // We are essentially replacing the maxNumberOfGuests to the number of attending. 
                                               // This reduces redundancy and no need to create new variables and follow class diagrams.

        

        System.out.print("The venue is available for the following dates:05/11/2022");

        System.out.println("Enter the date you want to commence event in exact formatting..(E.g: 15/10/2022)");;

        String str_date = userInput.nextLine().strip();

        this.date_venue = str_date; // Make this into a Date Object

        this.isBooked = true;

    }

    public String getName(){
        return this.name;
    }

    public String getVenueDate(){
        return this.date_venue;
    }

    public boolean getBookedStatus(){
        return this.isBooked;
    }

    public float getCost(){
        return this.cost;
    }

    public int getNumberOfGuest(){
        return this.numberOfGuest;
    }

    public float bookVenue(int numberOfGuest, String date) { // BookVenue method for eventManager to confirm booking
        this.numberOfGuest = numberOfGuest;
        this.date_venue = date;
        this.isBooked = true;
        return this.cost; //return the cost for the event manager to see
    }
}

