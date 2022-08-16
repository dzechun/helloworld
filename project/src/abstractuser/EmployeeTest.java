package abstractuser;

public class EmployeeTest {
    public static void main(String[] args) {

        Manager m1 = new Manager("nick",101,10000,8000);
        CommonEmployee c1 = new CommonEmployee();
        m1.work();
        c1.work();
    }
}
