import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome. Your options are:");
        System.out.println(
        "view packages\n"
        + "make query\n"
        + "venue inspection\n"
        + "login with eventID\n"
        + "manager login"
        );

        String userInp = scnr.nextLine();
        System.out.println();


        if (userInp.equals("manager login")){
            System.out.println("Enter Username");
            String userName = scnr.nextLine();
            System.out.println();
    
            System.out.println("Enter Password");
            String password = scnr.nextLine();
            System.out.println();

            EventManager manager1 = new EventManager(userInp, userName, password, password);
            manager1.logIn(userName, password);

            manager1.logOut();

            Query query1 = new Query(userName, 043212, "test@gmail", "this is a test");
            query1.getQuery();
            

            if (userName.equals("eventManager")  && password.equals("admin123")) {
                System.out.printf("welcome " + userName + ". Your options are: \n");
                EventManager.getOptions(); //Note: No event manager object, since it's not an instantiated class
            }
        } 
        else if (userInp.equals("login with eventID")) {
            System.out.println("Please enter your event id:");
            String eventID = scnr.nextLine();
        }

        scnr.close();

    }   
}
