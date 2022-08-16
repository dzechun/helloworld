package java8Test;

import interfaceTest.CompareCircle;

public class SubClassTest {

    public static void main(String[] args) {
        SubClass s = new SubClass();
//        s.method1();
//        SubClass.method1();
        //知识点1：接口中定义的静态方法，只能通过接口来调用
        CompareA.method1();
        //如果实现类重写了接口中的默认方法，调用时，仍然调用的时重写以后的方法
        s.method2();
        //知识点3：如果子类（或实现类）继承的父类和实现的接口中声明了同名同参数的方法
        //那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法-->类优先原则
        //知识点4：如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法。
        //那么在实现类没有重写此方法的情况下，报错。-->接口冲突
        //这就需要我们必须在实现类中重写此方法
        s.method3();

    }
}

//class SubClass implements CompareA{
//
//    public void method2(){
//        System.out.println("SubClass:上海");
//    }
//
//    public static void method1(){
//
//    }
//}

class SubClass extends SuperClass implements CompareA, CompareB {

    public void method2(){
        System.out.println("SubClass:上海");
    }

    public void method3(){
        System.out.println("SubClass：深圳");
    }

    //知识点5：如何在子类（或实现类）的方法中调用父类、接口中被重写的方法
    public void myMethod(){
        method3();//自己定义的方法
        super.method3();//父类方法
        CompareA.super.method2();//调用接口中的默认方法
    }
}