package a04threadmethod1;

public class MyThread extends Thread{
    @Override
    //出让线程
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ""+i);

            //表示出让cpu的线程
            Thread.yield();
        }
    }
}
