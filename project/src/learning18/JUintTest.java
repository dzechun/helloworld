package learning18;

import org.junit.Test;

import java.util.Date;

/*
*Java中的JUnit单元测试
* 步骤：
* 1.导入JUnit包
* 2.创建Java类，进行单元测试
*   此时的Java类要求：2.1此类是public的2.2此类提供公共的无参的构造器
* 3.此类中声明单元测试方法
*   此时的单元测试方法：方法的权限是public，没有返回值，没有形参
* 4.此单元测试方法上需要声明注解：@Test,并在单元测试类中导入import org.junit.Test;
*
* 5.声明好单元测试方法以后，就可以在方法体内测试相关的代码
*
* 说明：
* 1.如果执行结果没有任何异常：绿条
* 2.如果执行结果出现异常：红条
 */
public class JUintTest {

    int num = 10;

    @Test
    public void testEquals(){
        String s1 = "MM";
        String s2 = "MM";
        System.out.println(s1.equals(s2));
        //类型转换异常
//        Object obj = new String("GG");
//        Date date = (Date)obj;

        System.out.println(num);
    }

    @Test
    public void testToString(){
        String s2 = "MM";
        System.out.println(s2.toString());
    }
}
