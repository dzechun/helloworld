package learning17;

public class Customer {
    private String name;
    private int age;

    public Customer(){}

    public Customer(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }

    //重写的原则：比较两个对象的实体内容（即：name和age）是否相同
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Customer){
            Customer cust = (Customer)obj;
            //比较两个对象的每个属性是否都相同
            if(this.age == cust.age && this.name.equals(cust.name)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
