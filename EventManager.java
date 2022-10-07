public class EventManager extends Employee
{
    EventManager(String employeeId, String username, String password, String position) {
        super(employeeId, username, password, position);
    }

    public static void viewQuery(Query queryobj) {
        queryobj.getQuery();
    }

    public static void viewComplaint(Query queryobj) {
        ;
    }

    public static void changeVenue() {
        ;
    }

    public static void bookVenue() {
        bookVenue();
        
    }

    public static void getOptions() {
        System.out.printf("viewQuery\nviewComplaint\nchangeVenue");
    }
}
