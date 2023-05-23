package a05test1;

import com.sun.jdi.event.StepEvent;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        //1.创建ServerSocket对象
        ServerSocket ss=new ServerSocket(10000);

        //2.等待客户端发送信息
        Socket socket = ss.accept();

        //3.读取数据

        InputStreamReader isr=new InputStreamReader(socket.getInputStream());
       int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char)b);
        }

        socket.close();
        ss.close();
    }
}
