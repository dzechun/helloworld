package learning14.lab1;

public class CheckAccountTest {
    public static void main(String[] args) {

        CheckAccount checkaccount = new CheckAccount(1122,20000,0.045,5000);
        checkaccount.withdraw(5000);
        checkaccount.withdraw(18000);
        checkaccount.withdraw(3000);

    }
}
