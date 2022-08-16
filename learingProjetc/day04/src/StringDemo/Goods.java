package StringDemo;

public class Goods implements Comparable{

    private String name;
    private double price;

    public Goods(){

    }

    public Goods(String name,double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

//    指明商品比较大小的方式:按照加个从低到高排序,再按照产品名称从低到高排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
                Goods goods = (Goods)o;
                if(this.price > goods.price){
                    return 1;
                }else if(this.price < goods.price){
                    return -1;
                }else{
//                    return 0;
                    return this.name.compareTo(goods.name);
                }
//                方式二
//                return Double.compare(this.price,goods.price);
            }
//        return 0;
//        throw new RuntimeException("传入的数据类型不一致");
        throw new RuntimeException("传入的数据类型不一致");
    }
}
