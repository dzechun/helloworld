package learning10;

public class Kids extends ManKind{
    private int yearsold;

    public Kids(){}

    public Kids(int yearsold){}

    public void setYearsold(int yearsold){
        this.yearsold = yearsold;
    }

    public int getYearsold(){
        return yearsold;
    }

    public void printAge(){
        System.out.println("I am" + yearsold + "years old.");
    }

    public void employeed(){
        System.out.println("Kids should study and no job");
    }
}
