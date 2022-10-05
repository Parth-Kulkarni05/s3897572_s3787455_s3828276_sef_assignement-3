import java.time.*;
import java.util.Date;

public class Venue {
    // field
    private String name;
    private float cost;


    private int numberOfGuest;
    private Date date;
    private Date time;
    private boolean isBooked; //TODO: Check if this is needed, either venue obj is only created when venue is actually booked, or this is needed 

    // constructor
    Venue(String name, float cost, int numberOfGuest, Date date, Date time){
        this.name = name;
        this.cost = cost;
    }
    
    // methods
    public float bookVenue(int numberOfGuest, Date date, Date time) {
        this.numberOfGuest = numberOfGuest;
        this.date = date;
        this.time = time;
        this.isBooked = true;
        return this.cost; //return the cost for the event manager to see???
    }
}

