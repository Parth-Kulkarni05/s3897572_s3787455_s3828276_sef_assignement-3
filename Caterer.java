import java.util.ArrayList;
import java.util.Scanner;

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
    
    
    public void getOptions(Event dummyEvent) {
        Scanner scnr = new Scanner(System.in);
        String userSelect = "";
    
        System.out.printf("\nWelcome " + this.getUsername() + ". Your options are: \n");
        while (!userSelect.equals("4") && !userSelect.equals("0")) { // If input is 4 (main exit) or 0 (exit after operation complete), stop while loop
            System.out.printf(
                "1. Order Food Menu\n"
                + "2. Add Food Menu\n"
                + "3. Change Food Menu\n"
                + "4. Update Drink Order\n"
                + "5. Update Cutlery\n"
                + "6. Log Out\n"
                + "Select option: "
                );
                userSelect = scnr.nextLine();
                
                if (userSelect.equals("1")) { // Order Food Menu
                    System.out.println("Enter number of drinks: ");
                    int drinks = Integer.parseInt(scnr.nextLine());

                    System.out.println("Enter number of cutlery: ");
                    int cutlery = Integer.parseInt(scnr.nextLine());
                    
                    System.out.println("Enter bill amount: ");
                    float bill = Float.parseFloat(scnr.nextLine());

                    orderFoodMenu(dummyEvent, drinks, cutlery, bill);
                }
                else if (userSelect.equals("2")) { // Add Food Menu
                    System.out.println("Enter new food name: ");
                    String foodName = scnr.nextLine();

                    System.out.println("Enter new food cost: ");
                    float cost = Float.parseFloat(scnr.nextLine());
                    
                    System.out.println("Enter bill amount: ");
                    float bill = Float.parseFloat(scnr.nextLine());

                    addFoodMenu(dummyEvent, foodName, bill, cost);
                }
                else if (userSelect.equals("3")) { // Change Food Menu
                    System.out.println("Enter new food name: ");
                    String foodName = scnr.nextLine();

                    System.out.println("Enter integer position of old food item: ");
                    int oldFood = Integer.parseInt(scnr.nextLine());

                    System.out.println("Enter new food cost: ");
                    float cost = Float.parseFloat(scnr.nextLine());
                    
                    System.out.println("Enter bill amount: ");
                    float bill = Float.parseFloat(scnr.nextLine());

                    changeFoodMenu(dummyEvent, foodName, oldFood, bill, cost);
                }
                else if (userSelect.equals("4")) { // Update Drink Amount
                    System.out.println("Enter new Drink amount: ");
                    int drink = Integer.parseInt(scnr.nextLine());

                    updatedDinkOrder(drink, dummyEvent);
                }
                else if (userSelect.equals("5")) { // Update Cutlery Amount
                    System.out.println("Enter new Cutlery amount: ");
                    int cutlery = Integer.parseInt(scnr.nextLine());

                    updatedCutlery(cutlery, dummyEvent);
                }
                else if (userSelect.equals("6")) { // Log the manager out and exit
                    this.logOut();
                    break;
                }
                System.out.print("Operation Complete. Select next action (0 = LOG OUT, 1 = SHOW CATERER OPTIONS AGAIN): ");
                userSelect = scnr.nextLine();
        }
    }
}
