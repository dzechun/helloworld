package learning14.lab2;

/*
 *面向对象的特征三：多态性
 *
 *1. 理解多态性：可以理解为一个事物的多种形态
 * 2.何为多态性：
 *  对象的多态性：父类的引用指向子类的对象（或子类的对象赋给父类的引用）
 *
 * 3.多态的使用，虚拟方法调用
 * 有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是
 * 子类重写父类的方法。
 * 总结：编译，看左边；运行，看右边。
 *
 * 4.多态性的使用前提：
 * 4.1类的继承关系
 * 4.2方法的重写
 *
 * 5.对象的多态性，只适用于方法，不适用于属性。属性编译和运行都看左边。
 */
public class PersonTest {
    public static void main(String[] args) {

        Person p1 = new Person();
        p1.eat();

        Man man = new Man();
        man.eat();
        man.age = 18;
        man.earnMoney();

        //***********************的对象
        Person p2 = new Man();
//      Person p3 = new Woman();
//多态的使用，当调用子父类同名同参数的方法时，实际执行的时子类重写父类的方法--虚拟方法调用
        p2.eat();
        p2.walk();
        //对象多态性：父类的引用指向子类

        //p2.earnMoney();error
        //
        Man m1 = (Man)p2;
        m1.earnMoney();
        m1.isSmoking = true;


        //使用强转时，可能出现ClassCastException的异常
//        Woman w1 = (Woman)p2;
//        w1.goShopping();

        //instanceof关键字的使用
        /*
        *a instanceof A:判断对象a是否是类A的实例。如果是，返回true；如果不是，返回false
        * 使用情景，为了避免在向下转型时出现ClassCastException的移仓，我们在向下转型之前，先进行instanceof的判断，一旦返回true
        * 就进行向下转型，如果返回false，不进行向下转型。
        *
        * 如果a instanceof A返回true,则a instanceof B也返回true
        */

        if(p2 instanceof Woman){
            Woman w1 = (Woman)p2;
            w1.goShopping();
            System.out.println("woman");
        }

        if(p2 instanceof Man){
            Man m2 = (Man)p2;
//            m2.goShopping();
            System.out.println("man");
        }

        if(p2 instanceof Person){
            System.out.println("---person----");
        }

        if(p2 instanceof Object){
            System.out.println("object");
        }

        //练习：
        //问题一：编译通过，运行时不通过
        //举例一：
        Person p3 = new Woman();
        Man m3 = (Man)p3;
        //举例二：
        Person p4 = new Person();
        Man m4 = (Man)p4;

        //问题二：编译通过，运行时也通过
        Object obj = new Woman();
        Person p = (Person)obj;
    }
}
