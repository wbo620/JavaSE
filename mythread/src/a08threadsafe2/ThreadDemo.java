package a08threadsafe2;

public class ThreadDemo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();

        Thread t1=new Thread(mr);
        Thread t2=new Thread(mr);
        Thread t3=new Thread(mr);

        t1.start();
        t2.start();
        t3.start();
    }
}
