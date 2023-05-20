package a11waitANDnotify2;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadDemo {
    public static void main(String[] args) {

        /*需求：利用阻塞队列完成生产者和消费者（等待唤醒机制）的代码
        细节：
            生产者和消费者必须使用同一个阻塞队列*/

        //1.创建阻塞队列的对象
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
        //2.创建线程对象,把阻塞队列传进去
        Cook c=new Cook(queue);
        Foodie f=new Foodie(queue);

        c.start();
        f.start();
    }


}
