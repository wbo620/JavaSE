package a08test4;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //客户端：将本地文件上传到服务器。接收服务器的反馈。
        //服务器：接收客户端上传的文件，上传完毕之后给出反馈。
        //避免上传文件过大,单用户上传时间过长,导致后面的用户无法上传的问题,用线程的方法
        //每当一个用户上传,就开启一个线程

        //用线程池优化

        //1.创建socket对象
        Socket socket = new Socket("127.0.0.1", 10000);

        //2.获取文件,写出文件
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("IMG_2521_副本.JPG"));
        BufferedOutputStream bos=new BufferedOutputStream(socket.getOutputStream());

        byte[] b = new byte[1024];
        int len;
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        socket.shutdownOutput();

        InputStreamReader isr=new InputStreamReader(socket.getInputStream());
        int s;
        while ((s=isr.read())!=-1){
            System.out.print((char)s);
        }

        socket.close();


    }
}
