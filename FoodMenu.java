import java.util.ArrayList;

public class FoodMenu {
    // field
    private String menuId;
    private ArrayList<String> menu = new ArrayList<String>();
    private float cost;
    private int numberOfCutlery;
    private int numberOfDrink;
    private String pickupOrDelivery;
    private boolean isPickupedOrDelivered = false;

    // constructor
    FoodMenu(String menuId, ArrayList<String> menu, float cost){
        this.menuId= menuId;
        this.menu = menu;
        setCost(cost);
    }
    
    // methods

     // change menulist
    public void changeFood(String newFood, int oldFoodPosition, float cost){
        if (oldFoodPosition < this.menu.size() ){
            this.menu.set(oldFoodPosition, newFood);
            setCost(cost);
            System.out.println("updated food menu");
        } else{
            System.out.println("out of range");
        }    
    }
     // add food in menulist
    public void addFood(String newFood, float cost){
        this.menu.add(newFood);
        setCost(cost);
        System.out.println("add new food in food menu");
    }
    
    public void pickupOrDeliveryOrder(String method){
        this.pickupOrDelivery = method;
        System.out.println("Order will be " + this.pickupOrDelivery);
    }

    public void orderDrink(int drink){
        this.numberOfDrink = drink;
    }

    public void arrangeCutlery(int cutlery){
        this.numberOfCutlery = cutlery;
    }

    // getter, setter
    public void setPickupedOrDelivered(){
        this.isPickupedOrDelivered = true;
        System.out.println("order is delivered or picked up");   
    }

    public void getPickupedOrDelivered(){ 
        if (this.isPickupedOrDelivered == false)  {
            System.out.println("not yet delivered or picked up");
        } else{
            System.out.println("order is delivered or picked up");
        }         
    }

    

    public int getNumberOfDrink(){
        return this.numberOfDrink;
    }

    public int getCutlery(){
        return this.numberOfCutlery;
    }

    public String getMenuId(){
        return this.menuId;
    }

    public ArrayList<String> getMenu(){
        return this.menu;
    }

    public void setCost(float cost){
        this.cost = cost;
    }
    public float getCost(){
        return this.cost;
    }

    
}
