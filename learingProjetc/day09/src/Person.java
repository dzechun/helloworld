public class Person {
    public int age;
    private String name;
    String gender;

    public Person(){

    }

    public Person(int age){
        this.age = age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    @MyAnnotation
    public void setName(){

    }


}
