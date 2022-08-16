package java01;

import org.junit.Test;

import java.util.Date;

/*
JDK 8之前日期和是时间的API测试
 */
public class DateTimeTest {
    /*
    java.util.Date类
    1.两个构造器的使用
    >构造器一：Date():创建一个对应当前时间的Date对象、
    >构造器二：获取当前Date对象对应的毫秒数。（时间戳）
    2.两个方法的使用
    toString():显示当前的年、月、日、时、分、秒
    getTime()：获取当前date对象对应的毫秒数。（时间戳）
    3.Java.sql.Date对应着数据库的日期类型的变量
    >如何实例化
    >如何将java.util.Date对象转换为java.sql.Date对象

     */

    //1.System类中的currentImeMillis()
    @Test
    public void test2(){
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Sun Jun 12 10:47:28 CST 2022

        System.out.println(date1.getTime());//1654958732780

        //构造器二：
        Date date2 = new Date(1654958732780L);
        System.out.println(date2.toString());

//        创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(1654958732780L);
        System.out.println(date3);

//            情况一>如何将java.util.Date对象转换为java.sql.Date对象
//        Date date4 = new java.sql.Date(1654958732780L);
//         java.sql.Date date5 = (java.sql.Date)date4;
        // 情况二
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }

    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //称为时间戳
        System.out.println(time);
    }
}
