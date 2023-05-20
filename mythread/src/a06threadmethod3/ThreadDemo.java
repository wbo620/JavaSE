package a06threadmethod3;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1("飞机");
        MyThread2 t2 = new MyThread2("大炮");


        //将t2线程设置为陪伴线程(舔狗线程),随着第一个线程的结束而陆续的结束
        t2.setDaemon(true);

        t1.start();
        t2.start();

    }
}
