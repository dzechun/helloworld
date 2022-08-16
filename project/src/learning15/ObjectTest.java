package learning15;
/*
*java.lang.Object类
* 1.Object类是所有java类的根父类
* 2.如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.Object
* 3.Object类中的功能（属性、方法）就具有通用性。
* 属性；无
* 方法：equals（）、同String（）、个体Class（）、哈市Code（）、clone（）、finalize（）
* 4.Object类只声明了一个空参的构造器
*
* 面试题；
* final\finally\finalize的区别？
*
 */
public class ObjectTest {
    public static void main(String[] args) {

        Order order = new Order();
        System.out.println(order.getClass().getSuperclass());
    }
}

class Order{

}