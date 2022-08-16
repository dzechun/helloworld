package learning15;

public class GeometricTest {
    public static void main(String[] args) {
        GeometricTest test = new GeometricTest();
        Circle c1 = new Circle(2.3,"white",1.0);
        test.displayGeometricObject(c1);
        Circle c2 = new Circle(3.3,"green",2.0);
        test.displayGeometricObject(c2);

        boolean isEquals = test.equalsArea(c1,c2);
        System.out.println("c1和c2面积是否一样" + isEquals);

        MyRectangle rect = new MyRectangle(2.1, 3.4,"red",2.0);
        test.displayGeometricObject(rect);
    }

    public void displayGeometricObject(GeometricObject o) {
        System.out.println("面积为：" + o.findArea());
    }

    public boolean equalsArea(GeometricObject o1,GeometricObject o2) {
        return o1.findArea() == o2.findArea();
    }


}

class GeometricObject{
    protected String color;
    protected double weight;

    public GeometricObject(){}

    public GeometricObject(String color,double weight){
        this.color = color;
        this.weight = weight;
    }

    public void setter(String color, double weight){
        this.color = color;
        this.weight = weight;
    }

    public String getColor(){
        return this.color;
    }

    public double getWeight(){
        return this.weight;
    }

    public double findArea(){
        return 0.0;
    }
}

class Circle extends GeometricObject{//圆形
    private double radius;

    public Circle(){}

    public Circle(double radius,String color,double weight){
        super(color, weight);
        this.radius = radius;
    }

    public void setRadius(){
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

    public double findArea(){//计算圆的面积
       return Math.PI * radius * radius;
    }
}

class MyRectangle extends GeometricObject{//矩形
    private double width;
    private double height;

    public MyRectangle(){}

    public MyRectangle(double width,double height,String color,double weight){
        super(color,weight);
        this.height = height;
        this.width = width;
    }

    public void setter(double width,double height){
        this.width = width;
        this.height = height;
    }

    public double getWidth(double width){
        return this.width;
    }

    public double getHeight(double height){
        return this.height;
    }

    public double findArea(){//计算矩形的面积
       return height * width;
    }
}