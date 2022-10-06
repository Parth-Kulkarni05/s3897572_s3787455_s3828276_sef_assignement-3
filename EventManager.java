
public class EventManager extends Employee
{
    EventManager(String employeeId, String username, String password, String position) {
        super(employeeId, username, password, position);
    }
    
    public void viewQuery(Query queryobj) {
        queryobj.getQuery();
    }

    public void viewComplaint(Query queryobj) {
        ;
    }

    public void changeVenue() {
        ;
    }

    public void bookVenue() {
        
    }

    public void getOptions() {
        System.out.printf(
            "1. viewQuery\n"
            + "2. viewComplaint\n"
            + "3. changeVenue\n"
            + "4. logout\n"
            + "Select option: "
            );
    }
    
}
