package learning14.lab1;

public class AccountTest {
    public static void main(String[] args) {

        Account account = new Account(1122, 20000, 0.045);
        account.withdraw(30000);
        account.withdraw(2500);
        account.deposit(3000);
        double monthlyInterestRate = account.getMonthlyInterest();
        System.out.println("月利率为:"+monthlyInterestRate);
    }
}
