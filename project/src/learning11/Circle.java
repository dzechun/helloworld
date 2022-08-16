package learning11;



public class Circle {
    private double radius;

    public Circle(){
        radius = 1;
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public double findArea(){
        double area = radius * radius * 3.14;
        return area;
    }
}
