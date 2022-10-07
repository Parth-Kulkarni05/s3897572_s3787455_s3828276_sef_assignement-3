import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Packages {

    private String name;
    private int maxNumberOfGuests;
    private int priceRange;
    
    // constructor



    public void displayPackages() {

        System.out.println("We have the following packages available for you");

        System.out.println("1 - Family Events - Up to 15 People - $400");

        System.out.println("2 - Party Events - Up to 50 People - $800");

        System.out.println("3 - Grand Events - Up to 150 People - $1200");

    }

    public HashMap<String, String> setPackage() {

        HashMap<String, String> packageinfo = new HashMap<>();

        Scanner chosePackage = new Scanner(System.in);

        System.out.println("Please pick your Package Option");
        
        String packageChoice_ = chosePackage.nextLine();

        int packageChoice = Integer.parseInt(packageChoice_);

        if (packageChoice == 1){

            name = "Family Events";
            maxNumberOfGuests = 15;
            priceRange = 400;


        }
        
        else if (packageChoice == 2){

            name = "Party Events";
            maxNumberOfGuests = 50;
            priceRange = 800;

         
        }
        
        else{
            
            name = "Grand Events";
            maxNumberOfGuests = 150;
            priceRange = 1200;
        }

        packageinfo.put("choice", String.valueOf(packageChoice));
        packageinfo.put("name", name);
        packageinfo.put("maxNumberofGuests", String.valueOf(maxNumberOfGuests));
        packageinfo.put("priceRange", String.valueOf(priceRange));


        return packageinfo;
        
        

    


    } 


}


