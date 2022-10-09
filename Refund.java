public class Refund{

    private boolean isCanellationAfter2Days = false;
    private float refundAmount = 0.0f;
    private String refund_date;

    public void setRefund(String event_date, String cancled_date, float refundAmount){

        this.refundAmount = refundAmount;

        this.refund_date = cancled_date;

        this.refund_date = this.refund_date.substring(0,2);

        int parsed_date = Integer.parseInt(this.refund_date);

        event_date = event_date.substring(0,2);

        int event_date_parsed = Integer.parseInt(event_date);

        if ((event_date_parsed - parsed_date) > 2 ){

            this.isCanellationAfter2Days = true;

        }

        if (this.isCanellationAfter2Days == true){
            this.issue95refund(this.refundAmount);
        }

        else{
            this.issue100refund(this.refundAmount);
        }
    }

    public void issue95refund(float refundAmount){

        this.refundAmount = 0.90f * refundAmount;

        System.out.println("Issuing a refund of..." + String.valueOf(this.refundAmount));

    }

    public void issue100refund(float refundAmount){

        System.out.println("Issuing a refund of..." + String.valueOf(this.refundAmount));


    }

}