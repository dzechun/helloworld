package java01;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/*
 *jdk 8中日期时间API的测试
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate() {
        Date date1 = new Date(2022, 6, 15);
        System.out.println(date1);
    }

    /*
    LocalDate\LocalTime\LocalDateTime
    说明：
    1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高


     */

    @Test
    public void testTime(){
//now():获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);


//        0f():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 6, 15, 11, 56);
        System.out.println(localDateTime1);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //体现不可变形
//        withXxx():设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime ldt = localDateTime.withDayOfYear(212);
        System.out.println(ldt);
        System.out.println(localDateTime);

        //不可变性
        LocalDateTime ldt2 =  localDateTime.plusMonths(3);
        System.out.println(ldt2);
        System.out.println(localDateTime);

    }
    /*
    Instant的使用
    类似于java.util.Date类
     */
    @Test
    public void test2(){
        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例
        Instant instant1 = Instant.ofEpochMilli(559582800);
    }

    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
     */

    @Test
    public void test3(){
        //方式一：预定义的标准格式
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);
        //解析：字符串--->日期
        TemporalAccessor parse = formatter.parse("2022-06-15T17:24:55.9519968");
        System.out.println(parse);

//        //方式二：本地化相关的格式。如：ofLocalizedDateTime()
//        //FormatStyle.LONG/FormatStyle.MEDIUM/FormatStyle.SHORT:适用于LocalDateTime
//        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
//        //格式化
//        String str2 = formatter1.format(localDateTime);
//        System.out.println(str2);

        //重点：方式三:自定义的格式。如：ofPattern("yyyy-MM-dd hh:mm:ss E")
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format = formatter2.format(LocalDateTime.now());
        System.out.println(format);
        //解析
        TemporalAccessor parse1 = formatter2.parse("2022-06-16 22:13:13");
    }
}
