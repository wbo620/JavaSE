package a08test4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.*;

public class Server {

    //用线程池优化
    public static void main(String[] args) throws IOException {
//创建线程池对象
        ThreadPoolExecutor pool =new ThreadPoolExecutor(
                3,//corePoolSize:核心线程数量
                16,//maximumPoolSize:线程池总大小
                60,//keepAliveTime:空闲时间
                TimeUnit.SECONDS,//空闲时间（单位）
                new ArrayBlockingQueue<>(2),//队列  capacity:2队列长度
                Executors.defaultThreadFactory(),//线程工厂，让线程池如何创建线程对象
                new ThreadPoolExecutor.AbortPolicy()//阻塞队列
        );
        //创建对象,绑定端口
        ServerSocket ss=new ServerSocket(10000);

        while (true) {
            //等待客户端发送数据
            Socket socket = ss.accept();
            //开启一条线程
            //每有一个用户上传,就开启一条线程
           // new Thread(new MyRunnable(socket)).start();

            //用线程池优化
            pool.submit(new MyRunnable(socket));

        }

    }
}
