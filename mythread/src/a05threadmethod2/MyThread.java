package a05threadmethod2;

public class MyThread extends Thread{
    //插入线程
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ": " + i);
        }
    }
}
