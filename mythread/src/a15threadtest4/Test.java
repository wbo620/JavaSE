package a15threadtest4;

public class Test {
    public static void main(String[] args) {
       /* 抢红包也用到了多线程。
        假设：100块，分成了3个包，现在有5个人去抢。
        其中，
        红包是共享数据。
        5个人是5条线程。
        打印结果如下：
                XXX抢到了XX元
                XXX抢到了XX元
                XXX抢到了XXX元
                XXX没抢到
                XXX没抢到*/
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        MyThread t3=new MyThread();
        MyThread t4=new MyThread();
        MyThread t5=new MyThread();

        t1.setName("一号");
        t2.setName("二号");
        t3.setName("三号");
        t4.setName("四号");
        t5.setName("五号");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
