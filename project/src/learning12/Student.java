package learning12;

public class Student extends Person{
    String major;

    public Student(){}

    public Student(String major){
        this.major = major;
    }

    public void study() {
        System.out.println("学习" + major + "专业");
    }

     public void eat(){
        System.out.println("多吃有营养的食物");
    }

    public void show(){
        System.out.println("我不是人类");
    }

    public String info(){
        return null;
    }
}
