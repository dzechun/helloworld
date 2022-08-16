package InnerClassTest;
/*
*类的内部成员之五：内部类
* 1.Java中允许将一个类A声明再另一个类B中，则类A就是内部类，类B称为外部类
*
* 2.内部类的分类：成员内部类(静态、非静态) VS 局部内部类（方法内、代码块内、构造器内）
*
* 3.成员内部类：
*       一方面，作为外部类的成员：
*           >调用外部类的结构
*           >可以被static修饰
*           >可以被4种权限修饰
*
*       另一方面，作为一个类：
*           >类内可以定义属性、方法、构造器等
*           >可以被final修饰，表示此类不能被继承
*           >可以被abstract修饰，表示此类不能实例化
*
* 4.关注如下的3个问题
*   4.1如何实例化成员内部类的对象
*   4.2如何在成员内部类种区分调用外部类的结构
*   4.3开发中局部内部类的使用,见InnerClassTest1.java
 */
public class InnerClassTest {
    public static void main(String[] args) {

        //创建Dog实例（静态的成员内部类）：
        Person.Dog dog = new Person.Dog();
        dog.show();
        //创建Bird实例（非静态的成员内部类）：
        Person p = new Person();
        Person.Bird bird = p.new Bird();
        bird.sing();
    }
}

class Person{
    String name;
    int age;

    public void eat(){
        System.out.println("eat");
    }
    //静态成员内部类
    static class Dog{
        String name;
        int age;

        public void show(){
            System.out.println("Dog");
        }
    }
    //非静态成员内部类
    class Bird{
        String name;

        public void sing(){
            System.out.println("bird");
            Person.this.eat();//调用类的对象的方法
        }
    }

    public void method(){
        class AA{

        }
    }
    {
        class BB{

        }
    }
    public Person(){
        //局部内部类
        class CC{

        }
    }
}