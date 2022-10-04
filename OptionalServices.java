abstract class OptionalServices {
    private String serviceName;
    private float cost;
    private boolean isOrdered = false;
    private boolean isCanceled = false;

    // constructor
    OptionalServices(String serviceName, float cost){
        this.serviceName = serviceName;
        this.cost = cost;
    }

    // methods
    //hire music band or flower descoration
    public void order(){
        // reset original status for new order
        this.isOrdered = false;
        if (isOrdered() == false){
            this.isOrdered = true;
            System.out.println("ordered is " + this.isOrdered);
        }     
    }

    // cancel order
    public void cancelOrder(){
        // validation if ordered then, we can cancel
        if (isCanceled() == false){
            this.isOrdered = true;
            System.out.println("order is canceled");
        } else{ 
            System.out.println("not order yet");
        }      
    }


    // geter

    public String getServiceName() {
        return this.serviceName;
    }
    public float getCost(){
        return this.cost;
    }
    public boolean isOrdered(){
        return this.isOrdered;
    }
    public boolean isCanceled(){
        return this.isCanceled;
    }
}
