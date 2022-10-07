import java.time.*;
import java.util.Date;

public class Payment {
    // field
    private String name;
    private int phone;
    private String email;
    private String paymentMethod;
    private Date paidDate;
    private float amount;

    // constructor
    Payment(String name, int phone, String email, String paymentMethod, float amount){
        Date currentDate = new Date(); // create a current date object

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.paymentMethod = paymentMethod;
        this.paidDate = currentDate;
        this.amount = amount;
    }
    
    // methods
    public void issueInvoice() {
        System.out.println("Invoice:");
        System.out.println("Name: " + this.name + "      " + "Phone: " + this.phone);
        System.out.println("Email: " + this.email + "      " + "Payment Method: " + this.paymentMethod);
        System.out.println("Payment Date: " + this.paidDate + "      " + "Amount: " + this.amount);
    }
}