package abstractuser;

public class MyRectangle extends GeometricObject {//矩形
    private double width;
    private double height;

    public MyRectangle() {
    }

    public MyRectangle(double width, double height, String color, double weight) {
        super(color, weight);
        this.height = height;
        this.width = width;
    }

    public void setter(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth(double width) {
        return this.width;
    }

    public double getHeight(double height) {
        return this.height;
    }

    public double findArea() {//计算矩形的面积
        return height * width;
    }
}
