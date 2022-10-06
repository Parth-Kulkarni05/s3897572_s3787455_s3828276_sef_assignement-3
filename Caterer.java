import java.util.ArrayList;

public class Caterer extends Employee {
    // field
    private ArrayList<String> currentFoodMenu;
    
    // constructor
    Caterer(String employeeId, String username, String password, String position) {
        super(employeeId, username, password, position);
    }

    // order foodmenu for an event
    public void orderFoodMenu(Event event, int drink, int cutlery, float bill){
        // reset the booking status to original status 
        //before making booking for a new event
        this.isServieBooked = false;
        if (getLoginStatus() == true && isServieBooked() == false){
            // set the current event caterer is workin on
            setCurrentEventId(event);
            FoodMenu foodMenu = event.getFoodMenu();
            // book the foodmenu
            setCurrentFoodMenu(foodMenu.getMenu());
            // set number of drink
            foodMenu.orderDrink(drink);
            // set number of cutlery
            foodMenu.arrangeCutlery(cutlery);
            // add cost of food menu
            setBill(bill);
            // booking completed
            this.isServieBooked = true;       
            System.out.println("the food menu of event " + getCurrentEventId() + "is booked");
        } else{
            System.out.println("the food menu of this event is not booked yet, Please book!! ");
        }    
    }

    // add new items in foodmenu
    public void addFoodMenu(Event event, String newFood, float bill, float cost){
        if (getLoginStatus() == true && isServieBooked() == true){
            // get foodmenu
            FoodMenu foodmenu= event.getFoodMenu();
            // add new item in food menu
            foodmenu.addFood(newFood, cost);
            // update new cost for foodmenu
            setBill(bill);
            // print message
            System.out.println("new food is added for this event " + getCurrentEventId());
            System.out.println(foodmenu.getMenu());
        } else{
            System.out.println("the food menu of this event is not booked yet, Please book!! ");
        }    
    }

    // change food menu by postion
    public void changeFoodMenu(Event event, String newFood, int oldFoodPosition, float bill, float cost){
        if (getLoginStatus() == true && isServieBooked() == true){
            // get food menu
            FoodMenu foodmenu= event.getFoodMenu();
            // change item in food menu
            foodmenu.changeFood(newFood, oldFoodPosition, cost );
            // update new cost for foodmenu
            setBill(bill);
            // print message
            System.out.println("foodmenu is changed for this event "+ getCurrentEventId());
            System.out.println(foodmenu.getMenu());
        }else{
            System.out.println("the food menu of this event is not booked yet, Please book!! ");
        }     
    }

    // updated number of drink
    public void updatedDinkOrder(int drink, Event event){
        if (getLoginStatus() == true && isServieBooked() == true){
            FoodMenu foodmenu = event.getFoodMenu();
            foodmenu.orderDrink(drink);
        }
    }

    // updated number of cutlery
    public void updatedCutlery(int cutlery, Event event){
        if (getLoginStatus() == true && isServieBooked() == true){
            FoodMenu foodmenu = event.getFoodMenu();
            foodmenu.arrangeCutlery(cutlery);
    }
    }

    // getter
    public void setCurrentFoodMenu(ArrayList<String>  foodMenu){
        this.currentFoodMenu = foodMenu;
    }
    public ArrayList<String> getCurrentFoodMenu(){
        return this.currentFoodMenu;
    }
    
}
