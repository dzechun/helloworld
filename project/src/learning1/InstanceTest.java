package learning1;
/*
*匿名对象的使用
*
 */
public class InstanceTest {
    public static void main(String[] args) {
        Phone p = new Phone();
        System.out.println(p);
        p.sendEmail();
        p.playGame();

        //匿名对象
//        new Phone().sendEmail();
//        new Phone().playGame();

        new Phone().price = 1999;
        new Phone().showPrice();

        PhoneMall mall = new PhoneMall();
        //匿名对象的使用
        mall.show((new Phone()));

    }

}
class PhoneMall{

    public void show(Phone phone){
        phone.sendEmail();
        phone.playGame();
    }
}

class Phone{
    double price;

    public void sendEmail(){
        System.out.println("send email");
    }

    public void playGame(){
        System.out.println("play game");
    }

    public void showPrice(){
        System.out.println("price:"+price);
    }
}
