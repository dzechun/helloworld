package learning15;

import java.util.Date;

/*
*面试题：==和equals()区别
* 一、回顾==的使用：
* ==：运算符
* 1.可以使用在基本数据类型变量和引用数据类型变量中
* 2.如果比较的是基本数据类型变量：比较两个变量保存的数据是否相等。（不一定类型要相同）
*   如果比较的是引用数据类型变量：比较两个对象的地址值是否相同，即两个引用是否指向同一个对象实体
*   补充： == 符号使用时，左右两边的类型保持一致
* 二、equals()方法的使用：
* 1.是一个方法而非运算符
* 2.只能适用于引用数据类型
* 3.说明：Object类中定义的equals()和==的作用是相同的:比较两个兑现改的地址值是否相同，即两个引用是否指向
* 4.像String、Date、File、包装类等都重写了Object类中的equals()方法。重写以后，比较的不是两个引用的地址是否相同，而是比较两个对象的“实体内容”是否相同
* 5.通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个对象的“实体内容”是否相同。那么，我们就需要对Object类中的equals()方法进行重写
*   重写的原则：比较两个对象的实体内容（是否相同）
 */
public class EqualsTest {
    public static void main(String[] args) {

        int i = 10;
        int j = 10;
        double d = 10.0;
        System.out.println(i == j);
        System.out.println(i == d);

        char c = 10;
        System.out.println(i == c);

        char c1 = 'A';
        char c2 = 65;
        System.out.println(c1 == c2);//true

        Customer cust1 = new Customer("Tom",21);
        Customer cust2 = new Customer("Tom",21);
        System.out.println(cust1 == cust2);//false

        String str1 = new String("atguigu");
        String str2 = new String("atguigu");
        System.out.println(str1 == str2);//false
        //equals
        System.out.println("----equals----");
        System.out.println(cust1.getName());
        System.out.println(cust2.getName());
        System.out.println(cust1.equals(cust2));//false
        System.out.println(str1.equals(str2));//true

        Date date1 = new Date(324444);
        Date date2 = new Date(324444);
        System.out.println(date1.equals(date2));//true
    }
}
