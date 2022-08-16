package learning14.lab1;

public class CheckAccount extends Account{
    private double overdraft;//可透支限额

    public CheckAccount(int id,double balance,double annualInterestRate,double overdraft){
        super(id,balance,annualInterestRate);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount){
        if(amount <= getBalance()){
            setBalance(getBalance()-amount);
//            方式二：
//            super.withdraw(amount);
            System.out.println("取钱成功，余额为："+getBalance());
        }else if(amount > getBalance() + overdraft){
            System.out.println("用户超过可透支的限额,可透支额度为:" + overdraft);
        }else{
            overdraft = overdraft + getBalance() - amount;
            setBalance(0);
            System.out.println("取钱成功,余额为：" + getBalance() + "可透支额度为：" + overdraft);
        }
    }

}
