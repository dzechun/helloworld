package abstractuser;

import learning12.Person;
import learning12.Student;

/*
*抽象类的匿名子类
 */
public class PersonTest {
    public static void main(String[] args){
        method(new Student());//匿名对象

        Worker worker = new Worker();
        method1(worker);//非匿名的类非匿名对象

        method1(new Worker());//非匿名的类匿名的对象

        //创建了一匿名子类的对象：p
        Person p = new Person(){
            @Override
            public void eat(){}
        };
    }

    public static void method1(Person p){
        p.eat();
    }

    public static void method(Student s){

    }
}

class Worker extends Person {

}