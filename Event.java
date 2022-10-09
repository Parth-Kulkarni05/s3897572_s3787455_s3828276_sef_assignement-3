import java.util.Date;

public class Event {
    // field

    // call related classes here
    private Venue venue ; 
    private FoodMenu foodMenu; 
    private Music music; 
    private FlowerDecoration flower;
    private boolean isCanceled = false; // 
    private String payment; // PARTH .....payment class
    private String refund; // PARTH ....refund class

    // normal fields
    private String eventId;
    private String eventDateTime;
    private int numberOfGuest;
    private boolean isPaid = true;
    private float totalCost; // this one = sum(all service's costs  venue.cost + food.cost...)

    //------------------------------------------------------------------------------------------------------------
    
    // constructors


    Event(String eventId, String eventDateTime, int numberOfGuest, Venue venue, FoodMenu foodMenu, Music music, FlowerDecoration flowerDecoration){     
        setDateTime(eventDateTime);
        setEventId(eventId);
        setNumberOfGuest(numberOfGuest);
        setFoodMenu( foodMenu);
        float totalCost;

        if (flowerDecoration == null && music == null) {
            // increament total cost here + venue ..
            totalCost = foodMenu.getCost()+ venue.getCost();
        }
        else if (flowerDecoration == null) {
            setMusic(music);

            // increament total cost here + venue ..
            totalCost = foodMenu.getCost()+ music.getCost() + venue.getCost();
        }
        else if (music == null) {
            setFlowerDecoration(flowerDecoration);

            // increament total cost here + venue ..
            totalCost = foodMenu.getCost()+ flowerDecoration.getCost() + venue.getCost();
        } 
        else {
            setMusic(music);
            setFlowerDecoration(flowerDecoration);

            // increament total cost here + venue ..
            totalCost = foodMenu.getCost()+ music.getCost()+ flowerDecoration.getCost() + venue.getCost();
        }

        setCost(totalCost);
            
    }

    // ---------------------------------------------------------------------------------------------

    //method

    // use when changin costplan 
    public void changeAmount(float newCost){
        setCost(newCost);
        System.out.println("Cost is updated");     
    }

    // cancel event
    public void cancel(){
        this.isCanceled = true;
    }

    // check cancelation status
    public boolean isCanceled(){
        return this.isCanceled;
    }

    // getter, setter

    public void setMusic(Music music){
        this.music = music;
    }

    public Music getMusic(){
        return this.music;
    }

    public void setFlowerDecoration(FlowerDecoration flower){
        this.flower = flower;
    }

    public  FlowerDecoration getFlowerDecoration(){
        return this.flower;
    }

    public void setFoodMenu(FoodMenu foodMenu){
        this.foodMenu = foodMenu;

    }
    public FoodMenu getFoodMenu(){
        return this.foodMenu;
    }

    public void setNumberOfGuest(int numberOfGuest){
        this.numberOfGuest = numberOfGuest;
    }
    public int getNumberOfGuest(){
        return this.numberOfGuest;
    }  

    private void setEventId(String eventId){ 
        this.eventId = eventId;
    }

    public String getEventId(){
        return this.eventId;
    }  

    public void setDateTime(String dateTime){
        this.eventDateTime = dateTime;
    }
    public String getDateTime(){
        return this.eventDateTime;
    }

    public void isPaid(){
        System.out.println(isPaid);
    }
    public void setCost(float totalCost){
        this.totalCost = totalCost;
    }
    public float getCost(){
        return this.totalCost;
    }
    
}
