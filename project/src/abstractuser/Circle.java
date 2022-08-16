package abstractuser;

public class Circle extends GeometricObject {//圆形
    private double radius;

    public Circle() {
    }

    public Circle(double radius, String color, double weight) {
        super(color, weight);
        this.radius = radius;
    }

    public void setRadius() {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public double findArea() {//计算圆的面积
        return Math.PI * radius * radius;
    }
}
