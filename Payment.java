import java.time.*;
import java.util.Date;
import java.util.Scanner;

public class Payment {
    // field
    private String name;
    private int phone;
    private String email;
    private String paymentMethod;
    private Date paidDate;
    private float amount;

    // constructor

    public void getDetails(int venue_amount){

        this.amount = venue_amount;

        Scanner userInput = new Scanner(System.in);

        System.out.println("Please Enter Your Name");

        this.name = userInput.nextLine();

        System.out.println("Please Enter Your Phone Number");

        this.phone = Integer.parseInt(userInput.nextLine()); // This is a workaround for a bug where having a nextLine() after a nextInt() will skip the nextLine() input 

        System.out.println("Please Enter Your Email");

        this.email = userInput.nextLine();

        System.out.println("Please Enter Your Payment Method- Type Card or Debit for $" + String.valueOf(amount));

        this.paymentMethod = userInput.nextLine();

        System.out.print("Payment Successful");

        this.paidDate = new Date();
       
    }

    // methods
    public void issueInvoice() {
        System.out.println(" Invoice:");
        System.out.println("Name: " + this.name + "      " + "Phone: " + this.phone);
        System.out.println("Email: " + this.email + "      " + "Payment Method: " + this.paymentMethod);
        System.out.println("Payment Date: " + this.paidDate + "      " + "Amount: " + this.amount);
    }
}