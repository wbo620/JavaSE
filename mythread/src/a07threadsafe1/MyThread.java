package a07threadsafe1;

public class MyThread extends Thread{
    static int ticket=0;

    //创建一个唯一的锁对象,一定要是唯一的加static
    //static  Object obj=new Object();

    @Override
    public void run() {
        while (true) {
            //同步代码块
           // synchronized (obj){
            //通常用当前类的字节码文件,因为他是唯一的,不需要在创建新的锁对象了
            synchronized (MyThread.class){

                if(ticket<1000){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket++;
                    System.out.println(getName()+"正在卖第"+ticket+"张票");
                }else{
                    break;
                }
            }

        }
    }
}
