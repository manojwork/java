public class Saving extends Account{

    public static final double WITHDRAW_TAX=5.00;
    public Saving(String id,String name,double balance){
        super(id,name,balance);
    }

    public Saving(Saving source){
        super(source);
    }
@Override
public Account clone() {
    return new Saving(this);
}
    @Override
    public boolean withdraw(double amount) {
         super.setBalance(Math.round((super.getBalance()-amount)-WITHDRAW_TAX));
        return true;
    }
    @Override
    public boolean deposit(double amount) {
        super.setBalance(Math.round(super.getBalance()+amount));
        return true;
    }
}
