import java.util.ArrayList;

public class Caterer extends Employee {
    // field
    private boolean isBooked= false;
    private ArrayList<String> currentFoodMenu;
    
    // constructor
    Caterer(String employeeId, String username, String password, String position) {
        super(employeeId, username, password, position);
    }

    // order foodmenu for an event
    public void orderFoodMenu(Event event){
        // reset the booking status to original status 
        //before making booking for a new event
        this.isBooked = false;
        if (getIsbooked() == false){
            // set the current event caterer is workin on
            setCurrentEventId(event);
            FoodMenu foodMenu = event.getFoodMenu();
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

    // add new items in foodmenu
    public void addFoodMenu(Event event, String newFood, float cost){
        if (getIsbooked() == true){
            // get foodmenu
            FoodMenu foodmenu= event.getFoodMenu();
            // add new item in food menu
            foodmenu.addFood(newFood);
            // update new cost for foodmenu
            foodmenu.setCost(cost);
            // print message
            System.out.println("new food is added for this event " + getCurrentEventId());
            System.out.println(foodmenu.getFoodMenu());
        } else{
            System.out.println("the food menu of this event is not booked yet, Please book!! ");
        }    
    }

    // change food menu by postion
    public void changeFoodMenu(Event event, String newFood, int oldFoodPosition, float cost){
        if (getIsbooked() == true){
            // get food menu
            FoodMenu foodmenu= event.getFoodMenu();
            // change item in food menu
            foodmenu.changeFood(newFood, oldFoodPosition);
            // update new cost for foodmenu
            foodmenu.setCost(cost);
            // print message
            System.out.println("foodmenu is changed for this event "+ getCurrentEventId());
            System.out.println(foodmenu.getFoodMenu());
        }else{
            System.out.println("the food menu of this event is not booked yet, Please book!! ");
        }     
    }

    // getter
    public void setCurrentFoodMenu(ArrayList<String>  foodMenu){
        this.currentFoodMenu = foodMenu;
    }
    public ArrayList<String> getCurrentFoodMenu(){
        return this.currentFoodMenu;
    }
    public boolean getIsbooked(){
        return this.isBooked;
    }

}
