package a07test3;

import java.io.*;
import java.net.Socket;
import java.net.SocketOption;

public class Client {
    //客户端向服务器发送文件,服务器接收到文件,返回回执,客客户端再接收回执
    //并解决文件名唯一的问题
    //采用uuid.random方法实现
    public static void main(String[] args) throws IOException {

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
