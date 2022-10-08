import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        

        System.out.print("The venue is available for the following dates:05-AUG-2022");

        System.out.println("Enter the date you want to commence event in exact formatting..(E.g: 30-October-10)");;

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

}

