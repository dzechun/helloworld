package learning3;
/*
*this关键字的使用
* 1.this可以用来修饰属性、方法、构造器
* 2.this理解为：当前对象 或 当前正在创建的对象
*
* 2.1在类的方法中，我们可以使用“this.属性”或“this.方法”的方式，调用当前对象属性或方法。但
* 通常情况下，我们都选择省略“this.”。特殊情况下，如果方法的形参和类的属性同名是，我们必须显式
* 的使用“this.变量”的方式，表明此变量是属性，而非形参
*
* 2.2在类的构造器中，我们可以使用“this.属性”或“this.方法”的方式，调用当前对象属性或方法。但
 * 通常情况下，我们都选择省略“this.”。特殊情况下，如果方法的形参和类的属性同名是，我们必须显式
 * 的使用“this.变量”的方式，表明此变量是属性，而非形参
*
* 3. this调用构造器
* 3.1 我们在类的构造器中，可以显示的使用“this（参数列表）”方式，调用本类中指定的其他构造器
* 3.2构造器中不能通过“this（形参列表）”方式调用自己
* 3.3如果一个类中有n个构造器，则最多有n-1构造器中使用了“this（形参列表）”
* 3.4构造器内部，最多只能声明一个“this（参数列表）”，用来调用其他的构造器
 */
public class PersonTest {
    public static void main(String[] args) {

        Person p1 = new Person();

        p1.setAge(1);
        System.out.println(p1.getAge());

        Person p2 = new Person("nick",18);
        System.out.println(p2.getAge());
    }
}
class Person{

    private String name;
    private int age;

    public Person(){
        String info = "Ready to dance";
        System.out.println(info);
    }

    public Person(String name){
        this();
        this.name = name;
    }

    public Person(String name, int age){
        this(name);
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

}