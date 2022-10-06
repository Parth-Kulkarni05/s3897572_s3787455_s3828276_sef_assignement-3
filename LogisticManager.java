public class LogisticManager extends Employee{
    // field
    
    private String currentOptionalServiceName ;
    

    // constructor
    LogisticManager(String employeeId, String username, 
                       String password, String position) {
        super(employeeId, username, password, position);
    }

    // method

    // hire music
    public void hireMusic(Event event, float bill){
        // reset the booking status to original status 
        //before making booking for a new event
        this.isServieBooked = false;
        if (getLoginStatus() == true && isServieBooked() == false){
           
            // set the current event caterer is workin on
            setCurrentEventId(event);
            Music music= event.getMusic();
            // hire music 
            this.currentOptionalServiceName = music.getServiceName();
            // send bill to Finance manager
            setBill(bill);
            // booking completed
            this.isServieBooked = true;       
            System.out.println( this.currentOptionalServiceName +" of "+ getCurrentEventId() + "is booked");
        } else{
            System.out.println("music service of this event is not booked yet, Please book!! ");
        }    
    }

    
    // flower arrangement
    public void orderFlowerDecoration(Event event, float bill){
        // reset the booking status to original status 
        //before making booking for a new event
        super.isServieBooked = false;
        if (getLoginStatus() == true && isServieBooked() == false){
           
            // set the current event caterer is workin on
            setCurrentEventId(event);
            FlowerDecoration flower = event.getFlowerDecoration();
            // hire music 
            this.currentOptionalServiceName = flower.getServiceName();
            // send bill to Finance manager
            setBill(bill);
            // booking completed
            this.isServieBooked = true;       
            System.out.println( this.currentOptionalServiceName +" of "+ getCurrentEventId() + "is booked");
        } else{
            System.out.println("flower decoration service of this event is not booked yet, Please book!! ");
        }    
    }

    // cancel service
    public void cancel(Event event, String optionalServiceName){
        // already booked, then can cancel
        if (getLoginStatus() == true && isServieBooked() == true){
            setCurrentEventId(event);
            // flower arrangement
            if(optionalServiceName == event.getFlowerDecoration().getServiceName()){
                event.getFlowerDecoration().cancelOrder();
                System.out.println(optionalServiceName + "is canceled for the event" + event.getEventId());
            }
            //music
            if(optionalServiceName == event.getMusic().getServiceName()){
                event.getMusic().cancelOrder();
                System.out.println(optionalServiceName + "is canceled for the event" + event.getEventId());
           } 
        } // hasnot booked, cannot cancel
        else{
            System.out.println("Optional Services of this event have not been booked. Please book!");
            }
    }

    // getter
    


}