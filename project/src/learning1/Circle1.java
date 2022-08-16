package learning1;

public class Circle1 {
    public static void main(String[] args) {
        PassObject p1 = new PassObject();
        Circle2 c2 = new Circle2();
        p1.printAreas(c2,5);
    }

}

class Circle2{
    double radius;

    public double findArea(){
        double Area = radius*radius*Math.PI;
        return Area;
    }
}

class PassObject{
    public void printAreas(Circle2 c,int time){
        for(int i = 1;i <= time;i++){
            c.radius = i;
            System.out.println("The radius is :" + c.radius + "The area is :" + c.findArea());
        }
    }
}