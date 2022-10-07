// ALL IMPLEMENTED PARTS ARE WORKING, PLEASE DO NOT MODIFY

public class CostPlan {
    private String costPlanID;
    private float amount;
    private float eventmgrFunds;
    private float logisticmgrFunds;
    private float catererFunds;


    public void createCostPlan(String costPlanID, float amount) {
        this.costPlanID = costPlanID;
        this.amount = amount;
    }

    public void updateCostPlan(float newAmount) {
        this.amount = newAmount;
    }

    public void viewCostPlan() {
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
