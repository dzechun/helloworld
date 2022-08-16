package learning1;
/*
*递归防范的使用
* 1.递归防范：一个方法体调用它自身
* 2.方法递归包换了一种隐式的循环，它会重复执行某段代码，但这种重复执行无须循环控制。
* 递归一定要想一直方向递归，否则这种递归就变成了无穷递归，类似于死循环
*
 */
public class RecursionTest {

    public static void main(String[] args) {
        //计算1-100之间所有自然数的和
        int sum = 0;
        for (int i = 1; i < 101; i++) {
            sum += i;
        }

    }

    public int getSum(int n) {

        if (n == 1) {
            return 1;
        } else {
            return n + getSum(n - 1);
        }

    }

//    public int getSum(int n) {
//
//        if (n == 1) {
//            return 1;
//        } else {
//            return n * getSum(n - 1);
//        }
//    }

    //已知有一个数列：f(0)=1,f(1)=4,f(n+2)=2*f(n+1)+f(n),其中n是大于0的整数，求f(10)的值
    public int getF(int n){
        if(n == 0){
            return 1;
        }else if(n == 1){
            return 4;
        }else{
            return 2*getSum(n-1) + getSum(n -2);
        }
    }
    //斐波那契数列
    //汉诺塔问题
    //快排
}
