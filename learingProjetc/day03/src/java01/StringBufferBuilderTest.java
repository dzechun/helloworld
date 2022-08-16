package java01;

import org.junit.Test;

/*
 *关于StringBuffer和StringBuilder的使用
 *总结：
 * 增：append(xxx)
 * 删：delete(int n,int end)
 * 改：setCharAt(int n,char ch)/replace(int start, int end,String str)
 * 查：charAt(int n)
 * 插：insert(int offset,xxx)
 * 长度：length()
 * 遍历：for()+charAt()/toString()
 *
 */
public class StringBufferBuilderTest {

    /*

     */
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('a');
        System.out.println(s1);
//        s1.delete(2, 4);
//        s1.replace(2,4,"hello");
//        s1.insert(2,"false");
//        s1.reverse();
        String s2 = s1.substring(1,3);
        System.out.println(s1);
        System.out.println(s2);
    }


    /*
    String\StringBuffer\StringBuilder三者的异同
    String:不可变的字符序列；底层结构使用char[]存储
    StringBuffer:可变的字符序列，线程安全的，效率偏低，底层结构使用char[]存储
    StringBuilder:可变的字符序列，线程不安全的，效率偏高，底层结构使用char[]存储

    源码分析：
    String str = new String();//new char[0]
    String str1 = new String("abc");//new char[]{'a','b','c'}

    StringBuffer sbr = new StringBuffer();//new char[16];底层创建了一个长度是16的char型数组
    System.out.println(sbr);//0
    sbr.append('a');//value[0]='a';
    sbr.append('b');//value[1]='b';

    StringBuffer sbr1 = new StringBuffer("abc");//char[] value = new char["abc".length + 16]
    //问题1：System.out.println(sbr1.length());3
    //问题2：扩容问题：如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组
            默认情况下，扩容为原来容量的2倍+2，同时将原有的数组中的元素复制到新数组中。

            指导意义：开发中建议大家使用：StringBuffer(int capacity)或StringBuilder(int capacity)_
     */

    @Test
    public void test1() {
        StringBuffer sbr = new StringBuffer("abc");
        sbr.setCharAt(0, 'm');
        System.out.println(sbr);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());//0
    }


}
