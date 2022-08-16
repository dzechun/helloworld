package learning14;

import learning13.s1.Order;

public class SubOrder extends Order {
    public void method(){
        orderProtected = 1;
        orderPublic = 2;

        methodProtected();
        methodPublic();
    }
}
