package learning22;
/*
*abstract关键字的使用
* 1.abstract：抽象的
* 2.abstract可以用来修饰的结构：类、方法
*3.abstract修饰类：抽象类
*   3.1此类不能实例化
*   3.2抽象类中一定有构造器，便于子类对象实例化的时候调用（涉及：子类对象实例化全过程）
*   3.3开发中，都会提供抽象类的子类，让子类对象实例化，完成相关操作。
*
*
* 4.abstract修饰方法：抽象方法
*   4.1抽象方法只有方法的声明，没有方法体
*   4.2包含抽样方法的类，一定是一个抽象类。反之，抽象类中可以没有抽象方法的。
*   4.3若子类重写了父类中的所有的抽象方法后，此子类方可实例化
*   4.4若子类没有重写父类中的所有的抽象方法，则此子类也是一个抽象类，需要使用abstract修饰
 */
public class AbstractTest {
    public static void main(String[] args) {

//        一旦Person类抽象了，就不可实例化
//        Person person = new Person();
//        person.eat();

    }
}

abstract class Person{
    String name;
    int age;

    public Person(){

    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    //抽象方法
    public abstract void eat();

    public void walk(){
        System.out.println("walk");
    }
}

class Student extends Person{

    public Student(){

    }

    public void eat(){
        System.out.println("学生多吃有营养的食物");
    }
}