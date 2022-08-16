package learning14.lab1;

public class Account {
    private int id;//账号
    private double balance;//余额
    private double annualInterestRate;//年利率

    public Account(){}

    public Account(int id, double balance,double annualInterestRate){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId(){
        return id;
    }

    public double getBalance(){
        return balance;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest(){
        return annualInterestRate / 12;
    }

    public void withdraw(double amount){
        int isFlag = 0;
        while(isFlag < 3) {
            if(amount <= 0){
                System.out.println("请重新输入：");
                isFlag++;
            }else if(amount > balance){
                System.out.println("余额不足");
                isFlag++;
            }else{
                balance -= amount;
                System.out.println("取钱成功");
                isFlag = 3;
            }
            System.out.println("您的余额为：" + balance);
        }
    }

    public void deposit(double amount){
        boolean isFlag = true;
        while(isFlag){
            if(amount < 0){
                System.out.println("请重新输入");
            }else{
                balance += amount;
                System.out.println("存钱成功,余额为：" + balance);
                isFlag = false;
            }
        }

    }
}
