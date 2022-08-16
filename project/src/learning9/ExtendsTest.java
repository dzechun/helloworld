package learning9;

public class ExtendsTest {
    public static void main(String[] args) {

        Person p1 = new Person();
        p1.setAge(1);
        p1.getAge();
        p1.eat();

        Student s1 = new Student();
        s1.eat();
        s1.sleep();
        s1.name = "nick";
        s1.breath();

        Creature c = new Creature();

    }
}
