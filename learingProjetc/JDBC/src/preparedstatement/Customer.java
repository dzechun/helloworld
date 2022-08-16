package preparedstatement;


public class Customer {
    private long customer_id;
    private String customer_name;
    private String salary;
    private int age;

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", salary='" + salary + '\'' +
                ", age=" + age +
                '}';
    }

    public Customer(){}

    public Customer(long customer_id, String customer_name, String salary, int age) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.salary = salary;
        this.age = age;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
