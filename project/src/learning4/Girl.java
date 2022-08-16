package learning4;

public class Girl {


    private String name;
    private int age;

    public Girl() {
    }

    public Girl(String name) {
        this();
        this.name = name;
    }

    public Girl(String name, int age) {
        this(name);
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void marry(Boy boy) {
        System.out.println("I wanna marry" + boy.getName());
        boy.marry(this);
    }

    //比较两个对象的大小，正数：当前对象大；负数：当前对象小；0：当前对象与相残对象相等
    public int compare(Girl girl) {
//        if (this.age > girl.age) {
//            return 1;
//        } else if (this.age < girl.age) {
//            return -1;
//        } else {
//            return 0;
//        }
        return this.age - girl.age;

    }
}