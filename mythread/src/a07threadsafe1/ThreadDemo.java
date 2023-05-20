package a07threadsafe1;

public class ThreadDemo {
    //电影院卖100张票,设计一个模式模拟
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        MyThread t3=new MyThread();

        t1.start();
        t2.start();
        t3.start();
    }
}
