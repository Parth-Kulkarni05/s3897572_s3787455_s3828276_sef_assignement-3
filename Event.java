import java.util.Date;

public class Event {
    // field

    // call related classes here
    private String venue ; // DARIO .....need to change to class Venue
    private FoodMenu foodMenu; 
    private Music music; 
    private FlowerDecoration flower;
    private boolean isCanceled = false; // 
    private String payment; // PARTH .....payment class
    private String refund; // PARTH ....refund class

    // normal fields
    private String eventId;
    private Date eventDateTime;
    private int numberOfGuest;
    private boolean isPaid = true;
    private float totalCost; // this one = sum(all service's costs  venue.cost + food.cost...)

    //------------------------------------------------------------------------------------------------------------
    
    // constructors
        // for compusory services (venue, food)
        // DARIO! PUT YOUR VENUE OBJECT IN ALL CONSTRUCTORS 
    Event(String eventId, Date eventDateTime, 
        int numberOfGuest, FoodMenu foodMenu){  
        // set the date time, event id, foodmenu, 
        setDateTime(eventDateTime);
        setEventId(eventId);
        setNumberOfGuest(numberOfGuest);
        setFoodMenu( foodMenu);

        // increament total cost here + venue ..
        float totalCost = foodMenu.getCost();
        setCost(totalCost);
    }

        // optional service - music band
    Event(String eventId, Date eventDateTime, 
        int numberOfGuest, FoodMenu foodMenu, Music music ){
        // set the date time, event id, foodmenu,music
        setDateTime(eventDateTime);
        setEventId(eventId);
        setNumberOfGuest(numberOfGuest);
        setFoodMenu( foodMenu);
        setMusic(music);
        // increament total cost here + venue ..
        float totalCost = foodMenu.getCost()+ music.getCost();
        setCost(totalCost);
    }

        // optional service flower decoration
    Event(String eventId, Date eventDateTime, int numberOfGuest,
            FoodMenu foodMenu, FlowerDecoration flower ){
                
            // set the date time, event id, foodmenu, flower
        setDateTime(eventDateTime);
        setEventId(eventId);
        setNumberOfGuest(numberOfGuest);
        setFoodMenu( foodMenu);
        setFlowerDecoration(flower);
          // increament total cost here + venue ..
        float totalCost = foodMenu.getCost()+ flower.getCost();
        setCost(totalCost);
    }

        // optional service flower decoration and music band
    Event(String eventId, Date eventDateTime, int numberOfGuest, FoodMenu foodMenu,
             Music music, FlowerDecoration flower ){

        // set the date time, event id, foodmenu,music, flower
        setDateTime(eventDateTime);
        setEventId(eventId);
        setNumberOfGuest(numberOfGuest);
        setFoodMenu( foodMenu);
        setFlowerDecoration(flower);
        setMusic(music);
          // increament total cost here + venue ..
        float totalCost = foodMenu.getCost()+ music.getCost()+ flower.getCost();
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

    public void setDateTime(Date dateTime){
        this.eventDateTime = dateTime;
    }
    public Date getDateTime(){
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
