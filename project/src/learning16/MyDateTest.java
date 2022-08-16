package learning16;

public class MyDateTest {
    public static void main(String[] args) {
        MyDate m1 = new MyDate(14,3,1976);
        MyDate m2 = new MyDate(14,3,1976);
        if(m1 == m2){
            System.out.println("m1==m2");
        }else{
            System.out.println("m1!=m2");
        }

        if(m1.equals(m2)){
            System.out.println("m1 is equal to m2");
        }else{
            System.out.println("m1 is not equal to m2");
        }
    }
}

class MyDate{
    private int day;
    private int month;
    private int year;
    public MyDate(int day, int month, int year){
        super();
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDay(int day){
        this.day = day;
    }

    public void setMonth(int month){
        this.month = month;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        MyDate other = (MyDate) obj;
        if(day != other.day){
            return false;
        }
        if(month != other.month){
            return false;
        }
        if(year != other.year){
            return false;
        }
        return true;
    }
}
