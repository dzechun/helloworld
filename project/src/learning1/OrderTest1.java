package learning1;

public class OrderTest1 {
    public static void main(String[] args) {

        Order1 o1 = new Order1();
        o1.orderPublic = 3;
        o1.orderDefault = 2;
        //出了Order类之后，私有的结构就不可以调用了
//        o1.orderPrivate = 1;

        o1.methodDefault();
        o1.methodPublic();
    }
}
