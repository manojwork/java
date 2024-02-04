public class Loan extends Account {
   public static final double LOAN_MAX=10000;
   public static final double LOAN_TAX=0.02;
    public Loan(String id,String name,double amount){
        super(id,name,amount);
    }

    public Loan(Loan source){
        super(source);
    }
@Override
public Account clone() {
    return new Loan(this);
}
    @Override
    public boolean withdraw(double amount) {
     if(super.getBalance()+amount>LOAN_MAX){
        return false;
     }
     else {
       super.setBalance(Math.round((super.getBalance()+amount)+(amount*LOAN_TAX)));
     }
        return true;
    }

    @Override
    public boolean deposit(double amount) {
        super.setBalance(Math.round(super.getBalance()-amount));
        return true;
    }
}
