// ALL IMPLEMENTED PARTS ARE WORKING, PLEASE DO NOT MODIFY

import java.util.Scanner;

public class FinanceManager extends Employee {
    private CostPlan costplan = new CostPlan(); // create global costplan variable, so all methods can access it
    Packages packages = new Packages(); // creates package object, which finance manager can then update

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

            System.out.print("Operation Complete. Select next action (0 = EXIT, 1 = SHOW FINANCE MANAGER OPTIONS AGAIN): ");
            userOption = scnr.nextLine();
        }
    }

    private void updatePackage() { // Update packages. Note finance manager can only update the price, as per stakeholder requirements
        Scanner scnr = new Scanner(System.in);

        System.out.println("Current packages are: ");
        packages.displayPackages();                                         // Package object is created when finance manager is initialized, as per class diagram (package doesn't exist without finance mgr)
        System.out.print("Select package to update (1, 2 or 3): ");
        String packageSel = scnr.nextLine();

        System.out.print("\nEnter new package price: ");
        int pPrice = scnr.nextInt();

        if (packageSel.equals("1")) {
            packages.updatePackage1(pPrice);
        }
        else if (packageSel.equals("2")) {
            packages.updatePackage1(pPrice);
        }
        else if (packageSel.equals("3")) {
            packages.updatePackage1(pPrice);
        }
    }

    private void createCostPlan() { // Enter cost plan details and fill in cost plan object
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter Cost Plan ID: ");
        String costplanID = scnr.nextLine();

        System.out.print("Enter Cost Amount: ");
        float cost = scnr.nextFloat();
        costplan.createCostPlan(costplanID, cost);
    }

    private void updateCostPlan() { // Update cost plan object price
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter New Cost Amount: ");
        float cost  = scnr.nextFloat();
        costplan.updateCostPlan(cost);
    }

    private void viewCostPlan() { // Print out cost plan
        costplan.viewCostPlan();
    }

    private void allocateMoney() { // Allocate money to different managers for the event, this is saved in cost plan
        Scanner scnr = new Scanner(System.in);

        System.out.print("Amount to allocate to Event Manager: ");
        float EMcost  = scnr.nextFloat();

        System.out.print("Amount to allocate to Logistic Manager: ");
        float LMcost  = scnr.nextFloat();

        System.out.print("Amount to allocate to Caterer: ");
        float Ccost  = scnr.nextFloat();

        costplan.allocateMoney(EMcost, LMcost, Ccost);
    }

    public void payStaff() { // Pay the different employees based on their bill amounts
        //Using dummy values for staff bill amounts!
        float eventMgrBill = 300;
        float logistMgrBill = 200;
        float catererBill = 400;
        
        if (eventMgrBill == 0.0f | logistMgrBill == 0.0f | catererBill == 0.0f) {
            System.out.println("Error: One or more employees have not submitted their bills");
        }
        else {
            System.out.println("PAYMENTS:");
            System.out.println("Event Manager: " + eventMgrBill);
            System.out.println("Logistics Manager: " + logistMgrBill);
            System.out.println("Caterer: " + catererBill);
            System.out.println("Remaining Profits: " + (costplan.viewAmount() - catererBill - logistMgrBill - eventMgrBill));
        }
    }

    public CostPlan getCostPlan() { // This is so we can get the cost plan object to other classes, eg main
        return costplan;
    }

    public Packages getPackages() {
        return packages;
    }

}
