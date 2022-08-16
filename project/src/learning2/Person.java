package learning2;
/*
*1.创建程序，在其中定义两个类：Person和PersonTest类，定义如下：
* 用setAge（）设置人的合法年龄（），用getAge（）返回人的年龄
* 在PersonTest类中实例化Person类的对象b，调用setAge（）和getAge（）方法，体会java的封装性
*
*
* 练习2：
* 2.1.在卡面定义的Person类中添加构造器，利用构造器设置所有人的age属性初始值都为18
* 2，2.修改上题中类和构造器，增加name属性，使得每次创建Person对象的同时初始化对象的age属性
*
*
*
 */

public class Person {
    private int age;
    private String name;

    public Person(){

        String info = "Ready to dance";
        System.out.println(info);
    }

    public int getAge(){
        return age;
    }

    public Person(String name){
        this();
        this.name = name;
    }

    public Person(String name, int age){
        this(name);
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setAge(int n){
//        if(n>=0 && n<=130){
//            age = n;
//        }else{
//            age = -1;
//        }
        if(n < 0 || n > 130){
            System.out.println("传入的数据非法");
            return;
        }
    }
}
