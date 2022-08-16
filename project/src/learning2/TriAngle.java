package learning2;

public class TriAngle {
    private double base;//边长
    private double height;//高

    public void setBase(double b){
        base = b;
    }

    public double getBase(){
        return base;
    }

    public void setHeight(double h){
        height = h;
    }

    public double getHeight(){
        return height;
    }

    public TriAngle(){

    }

    public TriAngle(double b,double h){
        base = b;
        height = h;
    }
}
