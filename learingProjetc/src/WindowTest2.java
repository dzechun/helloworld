public class WindowTest2{
    public static void main(String[] args) {

        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("w1");
        t2.setName("w2");
        t3.setName("w3");

        t1.start();
        t2.start();
        t3.start();
    }
}