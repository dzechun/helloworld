/*
*
 */


class Window2 extends Thread{

    private static int ticket = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while(true){

            synchronized(this){//synchronized (obj){//此时唯一的对象
                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }

        }
    }
}

