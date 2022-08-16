package learning6;

public class Account {
    private double balance;//余额

    public Account(double inti_balance){this.balance = inti_balance;}
//    public void setBalance(double balance){this.balance = balance;}

    public double getBalance(){return balance;}
    //存钱操作
    public void deposit(double amt){
        if(amt > 0){
            balance += amt;
            System.out.println("deposit successful");
        }else{
            System.out.println("failure");
        }
    }
    //取钱操作
    public void withdraw(double amt){
        if(amt <= balance){
            balance -= amt;
            System.out.println("withdraw successful");
        }else{
            System.out.println("failure");
        }
    }
}
