package a02threadcase2;

public class MyRun implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //Thread.currentThread().getName() 获取当前调用者线程的名字
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
