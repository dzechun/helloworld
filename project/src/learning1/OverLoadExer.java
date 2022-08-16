package learning1;
/*
*可变个数形参的方法
* jdk 5.0 新增的内容
* 具体使用
*   可变个数形参的格式：数据类型...变量名
*   当调用可变个数形参的方法时，传入的参数个数可以是0个，1个，2个
*   可变个数形参的方法与本类中方法名相同，形参不同的方法之间构成重载
*   可变个数形参的方法与本类中方法名相同，形参类型也相同的数组之间不构成重载
*   可变个数形参在方法的形参中，必须声明在末尾
*   可变个数形参在方法的形参中，最多只能声明一个可变形参
 */

public class OverLoadExer {

    public static void main(String[] args) {
        OverLoadExer overLoadExer = new OverLoadExer();
        overLoadExer.mOL(2);
        overLoadExer.mOL("a");
        overLoadExer.mOL(3,4);
        overLoadExer.show("hello","BB","CC");
    }

    public void mOL(int a){
        int m = a * a;
        System.out.println(m);
    }
    public void mOL(int a, int b){
        int m = a * b;
        System.out.println(m);
    }
    public void mOL(String b){
        System.out.println(b);
    }

    public void show(String ... strs){
        System.out.println("show(String ... strs)");

        for(int i = 0;i < strs.length;i++){
            System.out.println(strs[i]);
        }
    }

    public void show(int i, String ... strs){

    }

//    public void show(String ... strs, int i){
//
//    }

}
