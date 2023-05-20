package a01threadcase1;

public class TestDemo {
    public static void main(String[] args) {
        MyThread mt1=new MyThread();
        MyThread mt2=new MyThread();

        mt1.setName("飞机");
        mt2.setName("坦克");

        mt1.start();
        mt2.start();


    }
}
