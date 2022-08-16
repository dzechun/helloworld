package ThreadUser;

class ThreadDemo2 implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i < 100;i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

public class ThreadTest2{
    public static void main(String[] args) {

        ThreadDemo2 td1 = new ThreadDemo2();

        Thread t1 = new Thread(td1);

        t1.setName("t1");

        t1.start();

    }
}


