package a05threadmethod2;

import a01threadcase1.MyThread;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {

        MyThread mt=new MyThread();
        mt.setName("MYthread");
        mt.start();

        //表示把t这个线程，插入到当前线程之前。
        //mt:自己创建的线程
        //当前线程：main线程
        mt.join();

        for (int i = 0; i < 10; i++) {
            System.out.println("main线程 " + i + "");
        }
    }
}
