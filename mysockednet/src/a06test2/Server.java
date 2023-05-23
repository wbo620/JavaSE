package a06test2;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建对象,绑定10000端口号
        ServerSocket ss=new ServerSocket(10000);
        //2.等待连接
        Socket socket = ss.accept();
        //3,读取数据
        //细节:
        //read会在通道中读取数据
        //但是,必须有一个结束标记,来结束读取
        //否则,就会一直等待读取,卡死在这
        InputStreamReader isr=new InputStreamReader(socket.getInputStream());
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char)b);
        }

        //4.返回回执
        OutputStream os =socket.getOutputStream();
        os.write("已接收".getBytes());
        //5.释放资源
        socket.close();
        ss.close();


    }
}
