import java.util.Scanner;

public class VenueInspection {
    
    private String name;
    private String address;
    private String date;
    private String time;


    public void getCustomerDetails(){
        
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Enter your name: ");
        this.name = scnr.nextLine();
    
    }

    public void bookDate(){

        // Here we have chosen to dummy the venue selections, 
        // by adding a print statment that shows the user has picked the following venue insepction and date

        System.out.println("We have the following venue inspection available on the following dates ");

        System.out.println("1 - Chester Road - 15 People Capacity - Approx cost $300");
        System.out.println("Available for 15/11/2022, 30/11/2022");

        System.out.println();

        System.out.println("2 - King Road - 50 People Capacity - Approx cost $500");
        System.out.println("Available for 6/11/2022, 8/11/2022");

        System.out.println();

        System.out.println("3 - Queen Road - 150 People Capacity - Approx cost $900");
        System.out.println("Available for 30/10/2022, 19/10/2022");

        System.out.println();


        System.out.println("You have picked Chester Road - 15 People Capacity - Approx cost $300 for 15/11/2022");

        this.address = "Chester Road";

        this.date = "15/11/2022";
    

    }

    public void bookTime(){

        // We have created a dummy time as well, and instead of letting the user through input set up a time and date, we have
        // done it manually using print statements and hard-coding values to variables.

        System.out.println("Lets pick a time for Chester Road - 15 People Capacity - Approx cost $300 for 15/11/2022");

        System.out.println();

        System.out.println("We have the following time's avaliable: ");

        System.out.println("10:00 AM to 10:30 AM, 5:00PM to 5:30 PM");

        System.out.println();

        System.out.println("You have picked 10:00 AM to 10:30 AM for Chester Road, on 15/11/2022 for venue inspection");

        this.time = "10:00 AM to 10:30AM";

        System.out.println();



    }
    
}
