package learning1;
/*
*1.编写程序，声明一个method方法，在方法中打印一个10*8的*型矩形，在main方法中调用该方法
* 2.修改上一个程序，在method方法中，除打印一个10*8的*型矩形外，再计算该矩形的面积，
* 并将其作为方法返回值，再main方法中调用该方法，接收返回的面积并打印
* 3.修改上一个程序，再method方法提供m和n两个参数，方法中打印一个m*n的*型矩形
* 并计算该举行的面积，将其作为方法返回值。再main方法中调用该方法，接受返回的面积值并打印。
 */

import java.lang.reflect.Method;

public class Exer3Test {
    public static void main(String[] args) {
        Exer3 e1 = new Exer3();
//        e1.length = 10;
//        e1.width = 8;
        int area = e1.method(8,10);
        System.out.println("The area is:"+area);
    }


}

class Exer3{

//    int length;
//    int width;
//    int area;

//    public int method(){
//        for(int j = 0;j < width;j++){
//            for(int i = 0;i < length;i++){
//                System.out.print('*');
//            }
//            System.out.println();
//        }
//
//        area = length * width;
//        return area;
//    }

    //m为矩形的宽，n为矩形的长
    public int method(int m , int n){
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++ ){
                System.out.print('*');
            }
            System.out.println();
        }
        int area = m * n;
        return area;

    }


}