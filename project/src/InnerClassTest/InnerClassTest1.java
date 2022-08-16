package InnerClassTest;

import java8Test.CompareA;

public class InnerClassTest1 {

    public void method(){
        class AA{

        }
    }


    //返回一个实现了Comparable接口的类的对象
    public Comparable getComparable(){

        //创建一个实现了Comparable接口的类:局部内部类

        class MyComparable implements Comparable{

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }

        return new MyComparable();
    }
}
