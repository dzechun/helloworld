package learning5;
/*
*测试程序：
* 1.创建一个Customer，名字叫Jane Smith，他有一个账号为1000，余额为2000元，年利率为1.23%的账户
* 2.对Jane Smith操作。存入100元，再取出960元，再取出2000元
*
*
*
 */
public class CustomerTest {
    public static void main(String[] args) {
        Customer cus = new Customer("Jane","Smith");
        Account acc = new Account(1000,2000,0.0123);

        cus.setAccount(acc);
        cus.getAccount().deposit(100);
        cus.getAccount().withdraw(960);
        cus.getAccount().withdraw(2000);

    }
}
