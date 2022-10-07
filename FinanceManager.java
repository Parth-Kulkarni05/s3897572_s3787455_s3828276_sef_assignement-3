// ALL IMPLEMENTED PARTS ARE WORKING, PLEASE DO NOT MODIFY

import java.util.Scanner;

public class FinanceManager extends Employee {
    private CostPlan costplan = new CostPlan(); // create global costplan variable, so all methods can access it

    // Manager fund allocation
    private float eventMgrAlloc;
    private float logisticMgrAlloc;
    private float catererAlloc;

    FinanceManager(String employeeId, String username, String password, String position) {
        super(employeeId, username, password, position);
    }

    public void getOptions() { // Allow finance manager to select what to do
        Scanner scnr = new Scanner(System.in);
        String userOption = "";

        while (!userOption.equals("7") && !userOption.equals("0")) {
            System.out.printf(
            "\n1. Update Package\n"
            + "2. Create Cost Plan\n"
            + "3. Change Cost Plan\n"
            + "4. View Cost Plan\n"
            + "5. Allocate Money\n"
            + "6. Pay Staff\n"
            + "7. Exit\n"
            + "Select option: "
            );
            userOption = scnr.nextLine();
            System.out.println();
            
            if (userOption.equals("1")) {
                updatePackage();
            }
            else if (userOption.equals("2")) {
                createCostPlan();
            }
            else if (userOption.equals("3")) {
                updateCostPlan();
            }
            else if (userOption.equals("4")) {
                viewCostPlan();
            }
            else if (userOption.equals("5")) {
                allocateMoney();
            }
            else if (userOption.equals("6")) {
                payStaff();
            }

            System.out.print("Operation Complete. Select next action (0 = EXIT, 1 = SHOW ALL OPTIONS AGAIN): ");
            userOption = scnr.nextLine();
        }
        
        scnr.close();
    }

    public void updatePackage() { // TODO: Update package, get Parth to implement package.update()
        ;
    }

    public void createCostPlan() { // Enter cost plan details and fill in cost plan object
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter Cost Plan ID: ");
        String costplanID = scnr.nextLine();

        System.out.print("Enter Cost Amount: ");
        float cost = scnr.nextFloat();
        costplan.createCostPlan(costplanID, cost);
    }

    public void updateCostPlan() { // Update cost plan object price
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter New Cost Amount: ");
        float cost  = scnr.nextFloat();
        costplan.updateCostPlan(cost);
    }

    public void viewCostPlan() { // Print out cost plan
        costplan.viewCostPlan();
    }

    public void allocateMoney() { // Allocate money to different managers for the event, this is saved in cost plan
        Scanner scnr = new Scanner(System.in);

        System.out.print("Amount to allocate to Event Manager: ");
        float EMcost  = scnr.nextFloat();

        System.out.print("Amount to allocate to Logistic Manager: ");
        float LMcost  = scnr.nextFloat();

        System.out.print("Amount to allocate to Caterer: ");
        float Ccost  = scnr.nextFloat();

        costplan.allocateMoney(EMcost, LMcost, Ccost);
    }

    public void payStaff() { // TODO: Pay the different employees based on their bill amounts
        System.out.println("PAYMENTS:");
        System.out.println(eventMgrAlloc);
    }

    public CostPlan getCostPlan() { // This is so we can get the cost plan object to other classes, eg main
        return costplan;
    }

    private void printConfirm() {
        
    }
}