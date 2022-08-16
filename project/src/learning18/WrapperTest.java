package learning18;

import org.junit.Test;

/*
 *包装类的使用：
 *
 * 2.掌握的：基本数据类型、包装类、String三者质检的相互转换
 *
 */
public class WrapperTest {

//    String类型-->基本数据类型、包装类:调用包装类的parseXxx()
    @Test
    public void test5(){
        String str1 = "123";
        int p1 = Integer.parseInt(str1);
        System.out.println(p1);
//可能会报NumberFormatException
        String str2 = "true1";
        boolean b1 = Boolean.parseBoolean(str2);
        System.out.println(b1);
    }
    //基本数据类型、包装类-->String类型，调用String重载的valueOf()
    @Test
    public void test4(){
        int num1 = 10;
        //方式一:连接运算
        String str1 = num1 + "";
        //方式二：调用String的valueOf(xxx)
        float f1 = 12.3f;
        String str2 = String.valueOf(f1);

        Double d1 = 12.4d;
        String str3 = String.valueOf(d1);
        System.out.println(str2);
        System.out.println(str3);
    }

    /*
    *JDK 5.0新特性：自动装箱与自动拆箱
     */
    @Test
    public void test3(){
//        int num1 = 10;
//        //基本数据类型-->包装类的对象
//        method(num1);
//自动装箱：
        int num2 = 10;
        Integer in1 = num2;
        //自动拆箱:包装类-->基本数据类型
        System.out.println(in1.toString());
        int num3 = in1;//自动拆箱
    }


    public void method(Object obj){
        System.out.println(obj);
    }

    //包装类--->基本数据类型：调用包装类Xxx的xxxValue()
    @Test
    public void test2(){
        Integer in1 = new Integer(12);
        int i1 = in1.intValue();
        System.out.println(i1 + 1);

        Float f1 = new Float(12.3);
        float f2 = f1.floatValue();
        System.out.println(f2);
    }

    //基本数据类型-->包装类
    @Test
    public void test1(){

        int num1 = 10;
//        System.out.println(num1.toString());
        Integer in1 = num1;
        System.out.println(in1.toString());

        Integer in2 = 12;
        System.out.println(in2.toString());

//        Integer in3 = new Integer("12as");
//        System.out.println(in3.toString());
//
//        Float f1 = new Float(1.2);
//        System.out.println(f1.toString());
//
//        Boolean b1 = new Boolean(true);
//        Boolean b2 = new Boolean("true");
//        Boolean b3 = new Boolean("true123");
//        System.out.println(b3);

        Order order = new Order();
        System.out.println(order.isMale);
        System.out.println(order.isFemale);
    }


}

class Order{

    boolean isMale;
    Boolean isFemale;
}
