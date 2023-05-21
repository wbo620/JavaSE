package a02threadpoll2;

import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoll {
    /*public static ExecutorService newCachedThreadPool()  创建一个没有上限的线程池
    * public static ExecutorService newFixedThreadPool（int nThreads)  创建有上限的线程池
    * */
    public static void main(String[] args) {
        //1.获取线程池对象
       // ExecutorService poll1 = Executors.newCachedThreadPool();
        ExecutorService poll2 = Executors.newFixedThreadPool(3);

        //2.提交线程
       /* poll1.submit(new MyRunnable());
        poll1.submit(new MyRunnable());
        poll1.submit(new MyRunnable());
        poll1.submit(new MyRunnable());*/

        poll2.submit(new MyRunnable());
        poll2.submit(new MyRunnable());
        poll2.submit(new MyRunnable());
        poll2.submit(new MyRunnable());
        poll2.submit(new MyRunnable());

        //3.销毁线程池
       // poll1.shutdown();
    }
}
