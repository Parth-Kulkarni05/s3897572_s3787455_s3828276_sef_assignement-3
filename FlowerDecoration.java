class FlowerDecoration extends OptionalServices{
    private String pickupOrDelivery;
    private boolean isPickedupOrDeliveried =false;

    // constructor
    FlowerDecoration(String serviceName, float cost, String method) {
        super(serviceName, cost);
        setPickupOrDeliveryMethod(method);       
    }

    

    // update status after order is picked up or delivered
    public void updatePickupedOrDelivered(){
        if (getIspickedupOrDeliveried() == false){
            this.isPickedupOrDeliveried = true;
            System.out.println("order is deliveried/picked up");
        }       
    }

    // geter
    public void setPickupOrDeliveryMethod(String method){
        this.pickupOrDelivery = method;
    }
    public String isPickupOrDelivery(){
        return this.pickupOrDelivery;
    }

    public boolean getIspickedupOrDeliveried(){
        return this.isPickedupOrDeliveried;
    }

}