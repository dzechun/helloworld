package interfaceTest;
/*
*接口的使用
* 1.接口使用上也满足多态性
* 2.接口，实际上就是定义了一种规范
* 3.开发中，体会面向接口编程
*
 */
public class UsbTest {
    public static void main(String[] args) {

        Computer com = new Computer();
        //1.创建了接口的非匿名实现类的非匿名对象
        Flash flash = new Flash();
        com.transferDate(flash);

        //2.创建了接口的非匿名实现类的匿名对象
        com.transferDate(new Printer());

        //3.创建了接口匿名实现类的非匿名对象
        USB phone = new USB(){

            @Override
            public void start() {
                System.out.println("work");
            }

            @Override
            public void stop() {
                System.out.println("stop");
            }
        };

        //4.创建了接口的匿名实现类的匿名对象
        com.transferDate(new USB() {
            @Override
            public void start() {
                System.out.println("mps is working");
            }

            @Override
            public void stop() {
                System.out.println("mps is stopped");
            }
        });
    }

}
class Computer{

    public void transferDate(USB usb){
        usb.start();
        System.out.println("传输数据的细节");

        usb.stop();
    }
}
interface USB{
    //定义了长、宽、最大最小的传输速度等
    void start();

    void stop();
}

class Flash implements USB{

    @Override
    public void start() {
        System.out.println("Usb is working");
    }

    @Override
    public void stop() {
        System.out.println("Usb is stopped");
    }
}

class Printer implements USB{

    @Override
    public void start(){
        System.out.println("Printer is working");
    }

    @Override
    public void stop() {
        System.out.println("Printer is stopped");
    }


}