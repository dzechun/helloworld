package StaticUser;
/*
*编写一个类实现银行账户的概念，包含的属性有“账号”、“密码”、“存款余额”、“利率”、“最小余额”，
* 定义封装这些属性的方法。账号要自动生成。
* 编写主类，使用银行账户类，输入、输出3个储户的上述信息
* 考虑，哪些属性可以设计成static属性
*
*
 */
public class Account {
    private int id;
    private String password;
    private double balance;
    private double annualInterestRate;
    private static double minimumBalance;
    private static int init = 1000;

    public Account(){
        id = init++;
    }

    public Account(String password,double balance,double annualInterestRate){
        this();
        this.annualInterestRate = annualInterestRate;
        this.password = password;
        this.balance = balance;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public  void setBalance(double balance){
        this.balance = balance;
    }

    public void  setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public static void setMinimumBalance(double minimumBalance){
        Account.minimumBalance = minimumBalance;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public static double getMinimumBalance(){
        return minimumBalance;
    }

    public String getPassword(){
        return password;
    }

    public double getBalance(){
        return balance;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
}
