package exer;

class Account{
    private double balance;

    public Account(double balance){
        this.balance = balance;
    }

    public void deposit(double income){
        balance += income;
    }
}

class Customer implements Runnable{

    private Account acct;

    public Customer(Account acct){
        this.acct = acct;
    }

    @Override
    public void run() {
        for(int i = 0;i <=3;i++){
            Account act = new Account(0);
        }
    }
}

public class AccountTest1 {
    public static void main(String[] args) {
        Account acct = new Account(0);
    }
}
