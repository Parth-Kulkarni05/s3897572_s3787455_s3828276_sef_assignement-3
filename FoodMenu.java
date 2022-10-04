import java.util.ArrayList;

public class FoodMenu {
    // field
    private String menu;
    private ArrayList<String> foodMenu = new ArrayList<String>();
    private float cost;
    private int numberOfCutlery;
    private int numberOfDrink;
    private String pickupOrDelivery;
    private boolean isPickupedOrDelivered = false;

    // constructor
    FoodMenu(String menu, ArrayList<String> foodMenu, float cost){
        this.menu = menu;
        this.foodMenu = foodMenu;
        setCost(cost);
    }
    
    // methods

     // change menulist
    public void changeFood(String newFood, int oldFoodPosition){
        if (oldFoodPosition < this.foodMenu.size() ){
            this.foodMenu.set(oldFoodPosition, newFood);
            System.out.println("updated food menu");
        } else{
            System.out.println("out of range");
        }    
    }
     // add food in menulist
    public void addFood(String newFood){
        this.foodMenu.add(newFood);
        System.out.println("add new food in food menu");
    }
    
    public void pickupOrDeliveryOrder(String method){
        this.pickupOrDelivery = method;
        System.out.println("Order will be " + this.pickupOrDelivery);
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

    public String getMenu(){
        return this.menu;
    }

    public ArrayList<String> getFoodMenu(){
        return this.foodMenu;
    }

    public void setCost(float cost){
        this.cost = cost;
    }
    public float getCost(){
        return this.cost;
    }

    
}
