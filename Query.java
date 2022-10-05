import java.time.*;
import java.util.Date;

public class Query {
    // field
    private String ID;
    private String customerName;
    private int phone;
    private String email;
    private Date date;
    private String query;

    //variables to log response from eventmgr
    private String response;
    private Date responseDate; 

    // constructor
    Query(String ID, String customerName, String query){ // constructor for existing customer
        Date currentDate = new Date(); // create a current date object

        this.ID = ID;
        this.customerName = customerName;
        this.date = currentDate;
        this.query = query;
    }

    Query(String customerName, int phone, String email, String query){ // constructor for potential customer
        Date currentDate = new Date(); // create a current date object

        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
        this.date = currentDate;
        this.query = query;
    }
    
    // methods
    public void getQuery() {
        System.out.printf("Query: ", this.ID,"\nDate: ", date);
        System.out.printf("Name: ", this.customerName, "\nEmail: ", this.email);
        System.out.printf("Body: ", query);
    }
    
    public void setResponse(String response) {
        this.response = response; // Save the managers response to the query object
        Date currentDate = new Date(); // create a current date object
        this.responseDate = currentDate; // save the current date object to the query object
    }

    public void getResponse() {
        System.out.printf("Response:\nDate:", this.responseDate, "Text: ", this.response); // ideally, would actually use smth like customer.responseNotification()
    }
}



