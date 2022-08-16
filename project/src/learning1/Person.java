package learning1;

public class Person {
    String name;
    int age;
    /*
       sex：1表明是男性
       sex：0表明是女性
     */
    int sex;

    public void study(){
        System.out.println("studying");
    }

    public void showAge(){
        System.out.println("age is "+age);
    }

    public int addAge(int addAge){
        age += addAge;
        return age;
    }

}
