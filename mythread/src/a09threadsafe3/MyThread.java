package a09threadsafe3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
    static int stick = 0;

    //创建lock锁的实现类对象
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        //循环
        while (true) {
            //上锁
            lock.lock();
            try {
                if (stick == 100) {
                    break;
                } else {
                    Thread.sleep(10);
                    stick++;
                    System.out.println(getName() + "正在卖第" + stick + "张票");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                //解锁,在finally里,怎麽样都能运行到
                lock.unlock();
            }

        }
    }
}

