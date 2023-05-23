package a05test1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    //客户端：多次发送数据
    //服务器：接收多次接收数据，并打印

    public static void main(String[] args) throws IOException {

        //1.创建socket对象
        Socket socket = new Socket("127.0.0.1", 10000);

        //2.写出数据
        Scanner sc = new Scanner(System.in);
        OutputStream os = socket.getOutputStream();

        while (true) {
            System.out.println("请输入");
            String str = sc.nextLine();
            if ("886".equals(str)) {
                break;
            }
            os.write(str.getBytes());
        }

        //3.关流
        socket.close();


    }
}
