import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {
    ArrayList<Account> accounts;
    ArrayList<Transaction> transactions;

    public Bank(){
        this.accounts = new ArrayList<Account>();
        this.transactions = new ArrayList<Transaction>();    }


      public void addAccount(Account account){
         this.accounts.add(account.clone());
        }

        private  void addTransaction(Transaction transaction){
            transactions.add(new Transaction(transaction));
        }

        public void executeTransaction(Transaction transaction){
            switch(transaction.getType()){
                case WITHDRAW : withdrawTransaction(transaction); break;
                case DEPOSIT : depositTransaction(transaction); break;
            }
        }

        private void withdrawTransaction(Transaction transaction){
            if(getAccount(transaction.getId()).withdraw(transaction.getAmount())){
                addTransaction(transaction);
            }
        }

        private void depositTransaction(Transaction transaction){
            getAccount(transaction.getId()).deposit(transaction.getAmount());
            addTransaction(transaction);
        }

        public Transaction[] getTransaction(String accountid){
          List<Transaction> list=transactions.stream()
                  .filter((transaction)->transaction.getId().equals(accountid))
                  .collect(Collectors.toList());
                return list.toArray( new Transaction[list.size()]);        
        }
        public Account getAccount(String transactionId){
         return   accounts.stream()
                    .filter((account)->account.getId().equals(transactionId))
                    .findFirst()
                    .orElse(null);
        }
}
