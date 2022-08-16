package exer;

import java.util.concurrent.locks.ReentrantLock;

/*
*银行有一个账户
* 有两个储户分别向同一账户存3000元，每次存1000元，存3次。每次存完打印账户余额
*
* 分析：
* 1.是否是多线程问题？是，两个储户线程
* 2.是否有共享数据？有，账户（账户余额）
* 3.是否有线程安全问题？有，需要考虑如何解决线程安全问题
*
 */
class SaveMoney implements Runnable{
    private int balance;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try{
            lock.lock();

            for(int i = 0;i < 3;i++){
                balance += 1000;
                System.out.println(Thread.currentThread().getName() + balance);
            }
        }finally {
            lock.unlock();
        }

    }
}

public class AccountTest {
    public static void main(String[] args) {
        SaveMoney sm = new SaveMoney();

        Thread t1 = new Thread(sm);
        Thread t2 = new Thread(sm);

        t1.setName("账户一");
        t2.setName("账户二");

        t1.start();
        t2.start();
    }
}
