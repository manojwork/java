import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    
    static Bank bank = new Bank();

    public static void main(String[] args){
try{
        ArrayList<Account> accounts= returnAccount();
        loadAccount(accounts);
        ArrayList<Transaction> transactions = returnTransaction();
        loadTransactions(transactions);
        for(Account  account : accounts){
          System.out.println("\n\t\t\t\t\t Account\n\n\t"+account+"\n\n");
          transactionHistory(account.getId());
        }
}catch(FileNotFoundException e){
    System.out.println(e.getMessage());
}
    }
    
    

    public static Account createObject(String[] value){
       switch(value[0]){
            case "Chequing" : return new Chequing(value[1],value[2],Double.parseDouble(value[3]));
            case "Savings" : return new Saving(value[1],value[2],Double.parseDouble(value[3]));
            case "Loan" : return new Loan(value[1],value[2],Double.parseDouble(value[3]));
            default : return null;}
            }

        
       
    public static ArrayList<Account> returnAccount() throws FileNotFoundException{
      FileInputStream fis = new FileInputStream("accounts.txt");
      Scanner scanFile = new Scanner(fis);
    ArrayList<Account> account = new ArrayList<Account>();
      while(scanFile.hasNextLine()){
        account.add(createObject(scanFile.nextLine().split(",")));
      }
      scanFile.close();
    return account;
    }
    
    public static ArrayList<Transaction> returnTransaction() throws FileNotFoundException{
      FileInputStream fis = new FileInputStream("transactions.txt");
      Scanner scan = new Scanner(fis);
      ArrayList<Transaction> transactions = new ArrayList<Transaction>();

      while(scan.hasNextLine()){
      String[] value=  scan.nextLine().split(",");
        transactions.add(new Transaction(Transaction.Type.valueOf(value[1]),value[2],Double.parseDouble(value[3]),Long.parseLong(value[0])));
      }
      scan.close();
      Collections.sort(transactions);
      return transactions;
    }

    public static void loadAccount(ArrayList<Account> accounts){
        for(Account account : accounts){
            bank.addAccount(account);
        }
    }

    public static void loadTransactions(ArrayList<Transaction> transactions){
      for (Transaction transaction : transactions) {
        bank.executeTransaction(transaction);
      }
    }

    public static void transactionHistory(String id){
      System.out.println("\t\t\t\t TRANSACTION HISTORY\n\t");
      for (Transaction transaction :bank.getTransaction(id)) {
      System.out.println("\t"+transaction+"\n");
      }
      System.out.println("\t"+bank.getAccount(id)+"\n\n\n\n");;
    }
    }


