package a03udpdemo2;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class SendMassage {
    public static void main(String[] args) throws IOException {
        //发送数据
        //1.创建DatagramSocket对象（快递公司）
        //细节：
        //绑定端口，以后我们就是通过这个端口往外发送
        //空参：所有可用的端口中随机一个进行使用

        DatagramSocket ds=new DatagramSocket();

        //打包数据
        Scanner sc=new Scanner(System.in);

        while (true) {

            System.out.println("请输入想说的话:");
            String str = sc.nextLine();
            if("886".equals(str)){
                break;
            }
            byte[] bytes = str.getBytes();
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            int port=10086;


            DatagramPacket dp=new DatagramPacket(bytes, bytes.length,addr,port);

            ds.send(dp);
        }

        ds.close();
    }
}
