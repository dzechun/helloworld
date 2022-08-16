package learning11;

public class Cylinder extends Circle{
    private double length;

    public Cylinder(){

        length = 1;
    }

    public void setLength(double length){
        this.length = length;
    }
    public double getLength(){

        return length;
    }
    //返回圆柱的体积
    public double findVolume(){

        return Math.PI * getRadius() * getRadius() * getLength();
    }

    //返回圆柱的表面积
    public double findArea(){
        return Math.PI * getRadius() * getRadius() * 2 + 2 * Math.PI * getRadius() * getLength();
    }

}
