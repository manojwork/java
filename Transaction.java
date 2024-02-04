import java.text.SimpleDateFormat;
import java.util.Date;
public class Transaction implements Comparable<Transaction>{
    public enum Type{WITHDRAW,DEPOSIT};
    private Type type;
   private String id;
   private double amount;
   private long timeStamp; 


    public Transaction( Type type, String id, double amount,long timeStamp) {
        this.type = type;
        this.id = id;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }

    public Transaction(Transaction source) {
        this.type = source.type;
        this.id = source.id;
        this.amount = source.amount;
        this.timeStamp = source.timeStamp;
    }


    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public int compareTo(Transaction o) {
        return Double.compare(this.timeStamp,o.timeStamp);
    }

    public String returnDate(){
        Date date=new Date(this.timeStamp*1000);
        return new SimpleDateFormat("dd-mm-yyyy").format(date);
    }

    @Override
    public String toString() {
        return  
            " type='" + getType() + "'" +
            ", id='" + getId() + "'" +
            ", amount='" + getAmount() + "'" +
            ", Date='" +returnDate() + "'" 
          ;
    }

}