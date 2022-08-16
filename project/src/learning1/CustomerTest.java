package learning1;
/*
*类中方法的声明和使用
*
* 方法：描述类应具有的功能
* 比如：Math类：sqrt（）、random（）
*      Scanner类:nextXXX（）
*       Array类：sort()
*
* 1.举例：
* public void eat(){}
*public void sleep(int hour){}
* public String getName(){}
* public String getNation(String nation){}
*
* 2.方法的声明：权限修饰符 返回值类型 方法名（形参列表）{
*                  方法体
*               }
*   static final abstract 来修饰的方法
*
* 说明：
*   关于权限修饰符：默认方法的权限修饰符先都使用public
*   private\public\缺省、protected--->封装性再细讲
*
*   返回值类型：有返回值的 vs 无返回值的
*       如果方法有返回值，则必须在方法声明时，指定返回值的类型。同时，方法中需要使用
*       return关键字来返回指定类型的变量或常量"return 数据"
*
*       如果方法没有返回值，则方法声明时，使用void来表示。通常，没有返回值的方法中中，就不需要
*       使用return，但是，如果使用的话，只能“return”，表示结束此方法的意思。
*
*       我们定义方法该不该有返回值？
*       题目要求
*
* 方法名：命名规则，见名知意
*
* 形参列表：0个、1个，或多个形参
* 格式：
* 我们定义方法时，该不该定义形参
*
* return关键字的使用：
*   使用范围，使用在方法体中
*   作用：1.结束方法2.针对于有返回值的方法，使用“return 数据”
*   注意点：return关键字后面不可以声明执行语句
*
* 方法的使用中，可以调用当前类的属性或方法
*   特殊的：方法A中又调用了方法A，递归方法
*
 */

public class CustomerTest {
    public static void main(String[] args) {
        Customer cust1 = new Customer();

        cust1.eat();
        cust1.sleep(8);
    }
}
//客户类
class Customer{

    //属性
    String name;
    int age;
    boolean isMale;

    //方法
    public void eat(){
        System.out.println("eat");
    }

    public void sleep(int hour){
        System.out.println("sleep"+hour+"hour");
        eat();
    }

    public String getName(){
        if(age > 18){
            return name;
        }else{
            return "tom";
        }
    }

    public String getNation(String nation){
        String info = "nation is:" + nation;
        return info;
    }
}