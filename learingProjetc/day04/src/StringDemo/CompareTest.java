package StringDemo;/*
一、说明:java中的对象，正常情况下，只能进行比较：== 或 != ，不能使用>或<的
        但是再开发场景中，我们需要对多个对象进行排序，这就需要比较对象的大小
        使用Comparable或Comparator实现

二、Comparable接口的使用

 */

import StringDemo.Goods;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTest {
    //Comparable接口的使用举例：自然排序
//    1.像String、包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小
//    2.像String、包装类重写compareTo()方法以后，进行了从小到达的排列
//    3.重写compareTo()
    //如果当前对象this大于形参对象obj，则返回正整数；
//    如果当前对象this小于先惨对象obj，则返回负整数；
//    如果当前对象this等于形参对象obj，则返回零
//    4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，
//    重写CompareTo()方法，在compareTo()方法中指明如何排序
    @Test
    public void test1() {

        String[] arr = new String[]{"AA", "BB", "KK", "CC", "DD", "MM"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("l",34);
        arr[1] = new Goods("a",43);
        arr[2] = new Goods("b",12);
        arr[3] = new Goods("c", 65);
        arr[4] = new Goods("e", 43);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /*
    comparator接口的使用：定制排序
    1.背景：
    当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
    或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
    那么可以考虑使用Comparator的对象来排序

    2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小；
    如果方法返回正整数，则表示o1大于o2;
    如果返回0，表示相等；
    返回负整数，表示01小于o2。
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"BB","DD","AA","LL","MM","OO"};
        Arrays.sort(arr, new Comparator() {

//            按照字符串从大到校的顺序排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String)o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("lenovo",34);
        arr[1] = new Goods("dell",43);
        arr[2] = new Goods("xiaomi",12);
        arr[3] = new Goods("huawei", 65);
        arr[4] = new Goods("huawei", 224);
        arr[5] = new Goods("microsoft", 43);

        Arrays.sort(arr, new Comparator() {
            //指明商品比较大小的方式：按照产品名称从低到高排序
            // 再按照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }

                }
                throw new RuntimeException("输入的类型不一致");
            }

        });
        System.out.println(Arrays.toString(arr));
    }
}
