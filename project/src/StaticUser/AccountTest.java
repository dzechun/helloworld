package StaticUser;

public class AccountTest {
    public static void main(String[] args) {


        Account.setMinimumBalance(0.0);
        Account a1 = new Account("123456",110.3,0.0045);
        Account a2 = new Account("234567",3000.5,0.0043);
        Account a3 = new Account("345678",12.4,0.0044);

        System.out.println("账户为："+ a1.getId() + "密码为：" + a1.getPassword() + "余额为：" + a1.getBalance() + "年利率为："+a1.getAnnualInterestRate());
        System.out.println("账户为：" + a2.getId() + "密码为：" + a2.getPassword() + "余额为：" + a2.getBalance() + "年利率为：" + a2.getAnnualInterestRate());
        System.out.println("账户为："+ a3.getId() + "密码为：" + a3.getPassword() + "余额为：" + a3.getBalance() + "年利率为："+a3.getAnnualInterestRate());

    }
}
