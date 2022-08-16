package interfaceTest;

import javax.management.relation.RelationNotFoundException;

/*
*定义一个ComparableCircle类，继承Circle类并且实现ComparableObject接口
* 在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的大小。
 */
public class CompareCircle extends Circle implements CompareObject {

    public CompareCircle(double radius){
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if(this == o){
            return 0;
        }
        if(o instanceof CompareCircle){
            CompareCircle c = (CompareCircle) o;
//            //error
////            return (int)(this.getRadius() - c.getRadius());
//            if(this.getRadius() > c.getRadius()){
//                return 1;
//            }else if(this.getRadius() < c.getRadius()){
//                return -1;
//            }else{
//                return 0;
//            }
            //当属性radius声明为Double类型时，可以调用包装类的方法
            //正确的方式二：
            return this.getRadius().compareTo(c.getRadius());
        }else{
            throw new RuntimeException("传入的数据类型不匹配");
        }
    }
}
