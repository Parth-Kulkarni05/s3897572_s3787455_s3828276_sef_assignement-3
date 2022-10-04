public class LogisticManager extends Employee{
    // field
    private boolean isBooked= false;
    private String currentOptionalServiceName ;
    

    // constructor
    LogisticManager(String employeeId, String username, 
                       String password, String position) {
        super(employeeId, username, password, position);
    }

    // method
    public void hireMusic(Event event){
        // reset the booking status to original status 
        //before making booking for a new event
        this.isBooked = false;
        if (getIsbooked() == false){
            // set the current event caterer is workin on
            setCurrentEventId(event);
            Music music= event.getOp();
            // book the foodmenu
            setCurrentFoodMenu(foodMenu.getFoodMenu());
            // add cost of food menu
            setBill(foodMenu.getCost());
            // booking completed
            this.isBooked = true;       
            System.out.println("the food menu of event " + getCurrentEventId() + "is booked");
        } else{
            System.out.println("the food menu of this event is not booked yet, Please book!! ");
        }    
    }


    // getter
    public boolean getIsbooked(){
        return this.isBooked;
    }


}