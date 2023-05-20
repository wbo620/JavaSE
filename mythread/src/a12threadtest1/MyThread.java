package a12threadtest1;

public class MyThread extends Thread{
    static int count=0;

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class){
                if (count==1000){
                    break;
                }else {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    count++;
                    int i = 1000 - count;
                    System.out.println(getName() + "卖出了第" + count+"张票! 余票"+i);
                }
            }
        }
    }
}
