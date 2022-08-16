package java01;

import org.junit.Test;

import java.util.Locale;

public class StringMethodTest {

    @Test
    public void test2(){

        String s1 = "Helloworld";
        String s2 = "HelloWorld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);

        String s5 = "abc";
        String s6 = new String("abd");
        System.out.println(s5.compareTo(s6));//涉及到字符串排序
    }

    @Test
    public void test1(){
        String s1 = "hello world";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
//        s1 = "";
        System.out.println(s1.isEmpty());
        String s2 = s1.toLowerCase();
        System.out.println(s1);//s1不可变的，任然为原来的字符串
        System.out.println(s2);

        String s3 = "     he   llo world   ";
        String s4 = s3.trim();
        System.out.println("--"+s3);
        System.out.println("--"+s4);

        String s7 = "北京尚硅谷教育";
        String s8 = s7.substring(0);
        System.out.println(s7);
        System.out.println(s8);

        String s9 = s7.substring(2,5);
        System.out.println(s9);


    }

    @Test
    public void test3(){
        String str1 = "helloworld";
        boolean b1 = str1.endsWith("rld");
        System.out.println(b1);

        boolean b2 = str1.startsWith("Hel");
        System.out.println(b2);

        boolean b3 = str1.startsWith("11", 2);
        System.out.println(b3);

        String str2 = "wo";
        System.out.println(str1.contains(str2));

        System.out.println(str1.indexOf("ro"));
    }

    @Test
    public void test4(){
        String str1 = "beijing";
        String str2 = str1.replace('北','东');

        System.out.println(str1);
        System.out.println(str2);

        String str3 =  str1.replace("北京","上海");

        System.out.println(str3);

        System.out.println("**********");
        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成，，如果结果中开头和结尾有，的话去掉
        String string = str.replaceAll("\\d+",",").replaceAll("^,|,$","");
        System.out.println(string);

        str = "12345";
//        判断str字符串中是否全部不有数字组成，既有1-n个数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
//        判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);
    }
}
