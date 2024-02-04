
public class Chequing extends Account implements Taxable{
    public static final double OVERDRAFT_FEE=-200;
    public static final double OVERDRAFT_RATE=5.50;
    public static final double TAX_MAX=3000;
    public static final double TAX_RATE=0.015;
    public Chequing(String id,String name,double balance)
    {
        super(id,name,balance);
    }

    public Chequing(Chequing source){
        super(source);
    }
@Override
public Account clone() {
return new Chequing(this);
}
    @Override
    public boolean withdraw(double amount) {
      if(super.getBalance()-amount<OVERDRAFT_FEE){
        return false;
      }
      else if(super.getBalance()-amount<0){
        super.setBalance(Math.round(super.getBalance()-amount-OVERDRAFT_RATE));
      }
      else{
        super.setBalance(Math.round(super.getBalance()-amount));

      }
      return true;
    }

    @Override
    public void tax(double income) {
        double tax=Math.max(0,income-TAX_MAX)*TAX_RATE;
        setBalance(Math.round((super.getBalance())-tax));
    }

    @Override
    public boolean deposit(double amount) {
        setBalance(Math.round((super.getBalance())+amount));
        return true;
    }
}
