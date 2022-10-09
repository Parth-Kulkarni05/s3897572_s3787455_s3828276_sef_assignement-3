import java.util.Scanner;
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
    public void getOptions(Event dummyEvent) {
        Scanner scnr = new Scanner(System.in);
        String userSelect = "";
    
        System.out.printf("\nWelcome " + this.getUsername() + ". Your options are: \n");
        while (!userSelect.equals("4") && !userSelect.equals("0")) { // If input is 4 (main exit) or 0 (exit after operation complete), stop while loop
            System.out.printf(
                "1. Hire Music\n"
                + "2. Order Flower Decoration\n"
                + "3. Cancel Service\n"
                + "4. Log Out\n"
                + "Select option: "
                );
                userSelect = scnr.nextLine();
                
                if (userSelect.equals("1")) { // Hire music
                    System.out.println("Enter bill amount: ");
                    userSelect = scnr.nextLine();
                    hireMusic(dummyEvent, Float.parseFloat(userSelect));
                }
                else if (userSelect.equals("2")) { // Order required flower decoration
                    System.out.println("Enter bill amount: ");
                    userSelect = scnr.nextLine();
                    orderFlowerDecoration(dummyEvent, Float.parseFloat(userSelect));
                }
                else if (userSelect.equals("3")) { // Cancel a service
                    System.out.println("Enter name of service to cancel: ");
                    userSelect = scnr.nextLine();
                    cancel(dummyEvent, userSelect);
                }
                else if (userSelect.equals("4")) { // Log the manager out and exit
                    this.logOut();
                    break;
                }
                System.out.print("Operation Complete. Select next action (0 = LOG OUT, 1 = SHOW LOGISTIC MANAGER OPTIONS AGAIN): ");
                userSelect = scnr.nextLine();
        }
    }

}