package a11waitANDnotify2;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie extends Thread {
    ArrayBlockingQueue<String> queue;

    public Foodie(ArrayBlockingQueue<String> queue) {

        this.queue = queue;
    }
    @Override
    public void run() {
        while (true) {
            //不断把阻塞队列中的东西取出
            try {
                String food = queue.take();
                System.out.println(food);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        }
    }

}