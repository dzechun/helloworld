package learning1;

import javax.swing.plaf.ComponentInputMapUIResource;

public class CircleTest {
    public static void main(String[] args) {

        Circle c1 = new Circle();
        c1.radius = 2;
        double area = c1.findArea();
        System.out.println(area);
    }
}

class Circle{

    //属性
    double radius;

    //求圆的面积的
    public double findArea(){
        double area = Math.PI * radius * radius;
        return area;
    }

}