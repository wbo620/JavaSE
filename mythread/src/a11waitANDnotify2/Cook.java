package a11waitANDnotify2;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread {
    ArrayBlockingQueue<String> queue;

    public Cook(ArrayBlockingQueue<String> queue) {

        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            //不断把面条放到阻塞队列中
            try {
                queue.put("面条");
                System.out.println("厨师做了一晚面条");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        }
    }
}
