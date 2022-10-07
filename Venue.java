import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.Scanner;

public class Venue {
    // field
    private String name;
    private float cost;


    private int numberOfGuest;
    private Date date_venue;
    private boolean isBooked; //TODO: Check if this is needed, either venue obj is only created when venue is actually booked, or this is needed 

    // constructor
    Venue(String name, float cost, int numberOfGuest){
        this.name = name;
        this.cost = cost;
        this.numberOfGuest = numberOfGuest;
    }

    public void displayVenues(int PackageChoice){

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

        


    }


    public void setVenue() throws ParseException{

        Scanner venueChoice = new Scanner(System.in);

        Scanner numberofPeople_scnr = new Scanner(System.in);

        Scanner dateSelection = new Scanner(System.in);

        int venueUserChoice = venueChoice.nextInt();

        venueChoice.close();

        // We have decided to set this values to default, to simplify and keeps things to point with the assignment.

        this.name = "The Grand Event Venue";
        this.cost = 1199.00f;

        System.out.println("Please enter the number of guests attending");

        int numberofAttendes = numberofPeople_scnr.nextInt();

        numberofPeople_scnr.close();


        while (numberofAttendes < this.numberOfGuest){
            System.out.println("Number Of Guests have to be less than" + String.valueOf(this.numberOfGuest));
        }

        this.numberOfGuest = numberofAttendes; // We are essentially replacing the maxNumberOfGuests to the number of attending. 
                                               // This reduces redundancy and no need to create new variables and follow class diagrams.

        

        System.out.print("The venue is available for the following dates: 30-October-10, 5-September-09");

        System.out.println("Enter the date you want to commence event in exact formatting..(E.g: 30-October-10)");;

        String str_date = dateSelection.nextLine();

        dateSelection.close();

        DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
        
        this.date_venue = formatter.parse(str_date);


    }
    
    // methods
    public float bookVenue(int numberOfGuest, Date date) {
        this.numberOfGuest = numberOfGuest;
        this.date_venue = date;
        this.isBooked = true;
        return this.cost; //return the cost for the event manager to see???
    }
}

