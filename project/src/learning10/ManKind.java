package learning10;

public class ManKind {
    private int sex;
    private int salary;

    public ManKind(){}

    public ManKind(int sex,int salary){
        this.sex = sex;
        this.salary = salary;
    }

    public void setSex(int sex){
        this.sex = sex;
    }

    public int getSex(){
        return sex;
    }

    public void setSalary(int salary){}

    public int getSalary(){
        return  salary;
    }

    public void manOrWoman(){
        if(sex == 1){
            System.out.print("man");
        }
        else if(sex == 0){
            System.out.print("woman");
        }
    }

    public void employeed(){
        if(salary == 1){
            System.out.print("job");
        }
        else if(salary == 0){
            System.out.print("no job");
        }
    }
}
