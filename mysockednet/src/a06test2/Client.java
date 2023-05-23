package a06test2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    //客户端：多次发送数据,接收服务器发送的回执
    //服务器：接收多次接收数据，并打印,发送回执
    public static void main(String[] args) throws IOException {
        //1.创建socket对象
        Socket socket = new Socket("127.0.0.1", 10000);

        //2.写出数据
        Scanner sc=new Scanner(System.in);
        OutputStream os = socket.getOutputStream();

        while (true) {
            System.out.println("请输入");
            String str = sc.nextLine();
            if ("886".equals(str)) {
                break;
            }
            os.write(str.getBytes());
        }
        //3.写出一个结束标记
        socket.shutdownOutput();


        //4.获取服务器回应
        InputStreamReader isr=new InputStreamReader(socket.getInputStream());
        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char)b);
        }
        //5.释放资源
        socket.close();

    }
}
