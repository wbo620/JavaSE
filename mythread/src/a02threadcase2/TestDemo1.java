package a02threadcase2;

public class TestDemo1 {
    public static void main(String[] args) {
        //创建MyRun对象
        //表示多线程要执行的任务
        MyRun mr=new MyRun();

        //创建两个线程对象
        Thread t1=new Thread(mr);
        Thread t2=new Thread(mr);

        //给线程取名
        t1.setName("飞机");
        t2.setName("大炮");

        //开启线程
        t1.start();
        t2.start();

    }
}
