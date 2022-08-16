package interfaceTest;
/*
*接口的使用
* 1.接口使用interface来定义
* 2.java中接口和类是并列的两个结构
* 3.如何定义接口：定义接口中的成员
*   3.1 JDK7及以前：只能去定义全局常量和抽象方法
*       全局常量：public static final的.但是书写时，可以省略不写
*       抽象方法：public abstract的
*
*   3.2 JDK8：除了定义全局变量和抽象犯法之外，还可以定义静态方法、默认方法（略）
*
*4.接口中不能定义构造器！意味着接口不可以实例化
*
* 5.java开发中，接口都通过让类去实现（implements）的方式来使用
*   如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化，
*   否则此类仍为抽象类
*
* 6.Java类可以实现多个接口--->弥补了Java单继承性
* 格式：class AA extends BB implements CC,DD,EE
*
* 7.接口与接口质检可以继承，而且可以多继承
*
* 8.接口的具体使用，体现多态性
* 9.接口，实际上可以看作是一种规范
*
* 面试题：抽象类与接口有哪些异同？
 */
public class InterfaceTest {
    public static void main(String[] args) {

        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);

        Plane plane = new Plane();
        plane.fly();
    }
}
interface Attack{
    public abstract void attack();
}

interface Flyable{

    //全局常量
    public static final int MAX_SPEED = 7900;//第一宇宙速度
    public static final int MIN_SPEED = 1;

    //抽象方法
    public abstract void fly();

    public abstract void stop();
}

class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("通过引擎起飞");
    }

    @Override
    public void stop() {
        System.out.println("通过手刹停止");
    }
}

class Kite implements Flyable{
    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }
}

class Bullet extends Object implements Flyable,Attack{

    @Override
    public void attack() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }
}


interface AA{
    void method1();
}

interface BB{
    void method2();
}

interface CC extends AA,BB{

}