public class Cancellation {

    private String eventName;
    private String canceled_date;
    private String event_date;
    private float refundAmount;

    public void cancel(float refundAmount, String cancled_date, String event_date){

        this.refundAmount = refundAmount;
        this.canceled_date = cancled_date;
        this.event_date = event_date;

        Refund r = new Refund();
        r.setRefund(this.event_date, this.canceled_date, this.refundAmount);

    }
    




    
}
