package learning2;
/*
*类的结构之三：构造器（构造方法constructor）的使用
*
* 一.构造器的作业
* 1.创建对象
* 2.初始化对象的属性
*
*
* 说明：
* 1.如果没有显示的定义类的构造器的话，则系统默认提供一个空参的构造器
* 2.定义构造器的格式：权限修饰符 类名（形参列表）{}
* 3.一个类中定于的多个构造器，彼此构成重载
* 4.一旦我们显示的定义了类的构造器之后，系统就不再提供默认的空参构造器
* 5.一个类中，至少有一个构造器
*
 */
public class PersonTest {
    public static void main(String[] args) {
        PersonTwo nick = new PersonTwo();
        nick.eat();
        nick.study();

        PersonTwo p2 = new PersonTwo("Tom");
        System.out.println(p2.name);

        Person p1 = new Person("nick");
        System.out.println(p1.getName());
    }
}

class PersonTwo{
    //属性
    String name;
    int age;
    //构造器
    public PersonTwo(){
        System.out.println("PersonTwo()...");
    }

    public PersonTwo(String n){
        name = n;
    }

    public PersonTwo(String n,int a){
        name = n;
        age = a;
    }
    //方法
    public void eat(){
        System.out.println("人吃饭");
    }

    public void study(){
        System.out.println("人学习");
    }
}