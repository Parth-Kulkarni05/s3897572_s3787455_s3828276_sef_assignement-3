public class CostPlan {
    // create variables
    private String costPlanID;
    private float amount;
    private float eventmgrFunds;
    private float logisticmgrFunds;
    private float catererFunds;

    // Methods
    public void createCostPlan(String costPlanID, float amount) { // Create/initialize cost plan
        this.costPlanID = costPlanID;
        this.amount = amount;
    }

    public void updateCostPlan(float newAmount) { // Set new cost plan amount
        this.amount = newAmount;
    }

    public void viewCostPlan() { // Print this cost plan
        System.out.println("ID: " + this.costPlanID + "\nAmount: " + this.amount);
    }

    public float viewAmount() { // So finance manager can calculate profits
        return this.amount;
    }

    public void allocateMoney(float eventmgrFunds, float logisticmgrFunds, float catererFunds) { // Allocate funds to different people to use for the event
        this.eventmgrFunds = eventmgrFunds;
        this.logisticmgrFunds = logisticmgrFunds;
        this.catererFunds = catererFunds;
    }
    
}
