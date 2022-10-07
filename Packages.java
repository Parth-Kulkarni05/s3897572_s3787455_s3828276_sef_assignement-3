import java.util.HashMap;
import java.util.Scanner;


public class Packages {

    private String first_package_name = "Family Events";
    private int first_package_max_people = 15;
    private int first_package_priceRange = 400;

    private String second_package_name = "Party Events";
    private int second_package_max_people = 50;
    private int second_package_priceRange = 800;

    private String third_package_name = "Grand Events";
    private int third_package_max_people = 150;
    private int third_package_priceRange = 1200;


    
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

            packageinfo.put("choice", String.valueOf(packageChoice));
            packageinfo.put("name", this.first_package_name);
            packageinfo.put("maxNumberofGuests", String.valueOf(this.first_package_max_people));
            packageinfo.put("priceRange", String.valueOf(this.first_package_priceRange));

        }
        
        else if (packageChoice == 2){
            packageinfo.put("choice", String.valueOf(packageChoice));
            packageinfo.put("name", this.second_package_name);
            packageinfo.put("maxNumberofGuests", String.valueOf(this.second_package_max_people));
            packageinfo.put("priceRange", String.valueOf(this.second_package_priceRange));

         
        }
        
        else{

            packageinfo.put("choice", String.valueOf(packageChoice));
            packageinfo.put("name", this.third_package_name);
            packageinfo.put("maxNumberofGuests", String.valueOf(this.third_package_max_people));
            packageinfo.put("priceRange", String.valueOf(this.third_package_priceRange));


        }



        return packageinfo;
    
        

    } 


    // Methods the finance manager can use to update the packages


    public void updatePackage1(String packageName, int maxNumberOfGuests, int priceRange){
        this.first_package_name = packageName;
        this.first_package_max_people = maxNumberOfGuests;
        this.first_package_priceRange = priceRange;


    }

    public void updatePackage2(String packageName, int maxNumberOfGuests, int priceRange){
        this.second_package_name = packageName;
        this.second_package_max_people = maxNumberOfGuests;
        this.second_package_priceRange = priceRange;


    }

    public void updatePackage3(String packageName, int maxNumberOfGuests, int priceRange){
        this.third_package_name = packageName;
        this.third_package_max_people = maxNumberOfGuests;
        this.third_package_priceRange = priceRange;


    }



}


